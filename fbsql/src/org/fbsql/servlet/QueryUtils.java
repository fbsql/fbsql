/*
MIT License

Copyright (c) 2020 FBSQL Team

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

Home:   https://fbsql.github.io
E-Mail: fbsql.team.team@gmail.com
*/

package org.fbsql.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;

import org.apache.hive.common.util.Murmur3;
import org.fbsql.json.parser.JsonUtils;

/**
 * Provides utility methods for convert ResutlSet to JSON.
*/
public class QueryUtils {
	//
	// The format constants
	// This constants used in client side JavaScript
	//

	/**
	 * Format results as JSON array of objects
	 * Default format
	 */
	public static final int RESULT_FORMAT_ARRAY_OF_OBJECTS = 0; // the default

	/**
	 * Format results as JSON array of arrays
	 * 2D-array (this format may be useful in case you want to hide ResultSet column names from client)
	 */
	public static final int RESULT_FORMAT_ARRAY_OF_ARRAYS = 1; // 2D-array (this format may be useful in case you want to hide ResultSet column names from client)

	/**
	 * Format results as JSON object of arrays (pivot)
	 * 
	 * WARNING! This format supported by client side JavaScript
	 * Server side receive it as RESULT_FORMAT_ARRAY_OF_OBJECTS,
	 * so this constant is never used on server side
	 * We preserve this comment for client and server code consistency
	 */
	//public static final int RESULT_FORMAT_OBJECT_OF_ARRAYS = 2; // pivot (processed on client side)

	/**
	 * Parse JSON array of objects
	 *
	 * @param jsonArrayOfObjects
	 * @return
	 */
	public static List<Map<String /* column name */, String /* JSON value */>> convertJsonArrayOfObjectsToListOfMaps(String jsonArrayOfObjects) {
		List<String>                                                 listOfJsonStrings = JsonUtils.parseJsonArray(jsonArrayOfObjects);
		List<Map<String /* column name */, String /* JSON value */>> list              = new ArrayList<>(listOfJsonStrings.size());
		for (String jsonString : listOfJsonStrings) {
			Map<String, String> map = JsonUtils.parseJsonObject(jsonString);
			list.add(map);
		}
		return list;
	}

	/**
	 * Converts list of results to ReadyResult object
	 *
	 * @param list            - result list to convert
	 * @param resultSetFormat - result set format
	 * @param encoder         - Base64 encoder
	 * @return                - ReadyResult object
	 * 
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static ReadyResult createReadyResult(List<Map<String /* column name */, String /* JSON value */>> list, int resultSetFormat, int compressionLevel, Base64.Encoder encoder) throws SQLException, IOException {
		String json = convertToJsonArray(list, resultSetFormat);

		//
		// Compression optimization for "too short" results.
		// We need prevent compression in case empty result set, because output
		// compressed array (even in best compression level) will have length = 10
		// and no compressed array have length = 2 for string "[]",
		// so, we override user-declared compression level with NO COMPRESSION value
		//
		if (json.length() == 2) // empty result set case: []
			compressionLevel = CompressionLevel.NO_COMPRESSION;

		ReadyResult readyResult = new ReadyResult();

		readyResult.bs = json.getBytes(StandardCharsets.UTF_8);
		if (compressionLevel == CompressionLevel.BEST_SPEED) {
			readyResult.compressed = true;
			readyResult.bs         = compress(readyResult.bs, Deflater.BEST_SPEED);
		} else if (compressionLevel == CompressionLevel.BEST_COMPRESSION) {
			readyResult.compressed = true;
			readyResult.bs         = compress(readyResult.bs, Deflater.BEST_COMPRESSION);
		} else if (compressionLevel == CompressionLevel.NO_COMPRESSION)
			readyResult.compressed = false;
		else
			throw new IllegalArgumentException(Integer.toString(compressionLevel));
		readyResult.etag = "\"" + Integer.toHexString(Murmur3.hash32(readyResult.bs)) + "\""; // Murmur3 32-bit variant

		return readyResult;
	}

	/**
	 * Converts list of maps to list of maps Json strings
	 *
	 * @param rs      - ResultSet to convert
	 * @param encoder - Base64 encoder
	 * @return        - list of maps
	 *
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static List<Map<String /* column name */, String /* JSON value */>> listOfMapsToListOfMapsJsonValues(List<Map<String, Object>> list, Base64.Encoder encoder) throws SQLException, IOException {
		List<Map<String /* column name */, String /* JSON value */>> jlist = new ArrayList<>(list.size());
		for (Map<String, Object> map : list) {
			Map<String /* column name */, String /* JSON value */> jmap = new LinkedHashMap<>();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String columnName = entry.getKey();
				Object value      = entry.getValue();

				String svalue = valueToJsonString(value, encoder);
				jmap.put(columnName, svalue);
			}
			jlist.add(jmap);
		}
		return jlist;
	}

	public static List<Map<String /* column name */, String /* JSON value */>> resutlSetToListOfMapsJsonValues(ResultSet rs, Base64.Encoder encoder) throws SQLException, IOException {
		try (rs) {
			List<Map<String /* column name */, Object /* column value */>> resultsListOfMaps = QueryUtils.resutlSetToListOfMaps(rs);
			return QueryUtils.listOfMapsToListOfMapsJsonValues(resultsListOfMaps, encoder);
		}
	}

	/**
	 * 
	 * @param value
	 * @param encoder
	 * @return
	 * @throws SQLException
	 */
	public static String /* JSON value */ valueToJsonString(Object value, Base64.Encoder encoder) throws SQLException {
		String svalue = null;
		/* NULL */
		if (value == null) // NULL
			svalue = "null";
		else if (value instanceof Blob) {
			Blob   blob = (Blob) value;
			byte[] bs   = blob.getBytes(1L, (int) blob.length());
			svalue = "\"" + encoder.encodeToString(bs) + "\"";
		}
		/* BINARY, VARBINARY, LONGVARBINARY, BLOB */
		else if (value instanceof byte[]) { // value returned as Base64 encoded string
			byte[] bs = (byte[]) value;
			svalue = "\"" + encoder.encodeToString(bs) + "\"";
			/* CHAR, VARCHAR, CLOB && JSON */
		} else if (value instanceof String) {
			String strValue = ((String) value).trim();
			/* JSON Types */
			if ( //
			(strValue.startsWith("{") && strValue.endsWith("}")) || // JSON Objecty
					(strValue.startsWith("[") && strValue.endsWith("]")) || // JSON Array
					(strValue.startsWith("\"") && strValue.endsWith("\"")) || // JSON String
					(strValue.equals("null")) || // JSON null
					(strValue.equals("true")) || // JSON true
					(strValue.equals("false")) // JSON false
			)
				svalue = strValue;
			/* CHAR, VARCHAR, CLOB etc. */
			else
				svalue = "\"" + value + "\"";
			/* DATE, TIME, TIMESTAMP */
		} else if (value instanceof Date || value instanceof Time || value instanceof Timestamp)
			svalue = "\"" + value + "\"";
		/* NUMBER, BOOLEAN, etc */
		else if (value instanceof Number || value instanceof Boolean)
			svalue = value.toString();
		/* Other types */
		else
			svalue = "\"" + value.toString() + "\"";
		return svalue;
	}

	/**
	 * Converts ResutlSet to list of maps
	 *
	 * @param rs      - ResultSet to convert
	 * @param encoder - Base64 encoder
	 * @return        - list of maps
	 *
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static List<Map<String /* column name */, Object /* value */>> resutlSetToListOfMaps(ResultSet rs) throws SQLException, IOException {
		List<Map<String /* column name */, Object /* column value */>> list        = new ArrayList<>();
		ResultSetMetaData                                              md          = rs.getMetaData();
		int                                                            columnCount = md.getColumnCount();
		while (rs.next()) {
			Map<String /* column name */, Object /* column value */> map = new LinkedHashMap<>();
			for (int i = 0; i < columnCount; i++) {
				int    n          = i + 1;
				String columnName = md.getColumnName(n);
				int    columnType = md.getColumnType(n);
				Object value;
				if (columnType == Types.BINARY || columnType == Types.VARBINARY || columnType == Types.LONGVARBINARY)
					value = rs.getBytes(n);
				else if (columnType == Types.BLOB)
					value = rs.getBlob(n);
				else
					value = rs.getObject(n);
				map.put(columnName, value);
			}
			list.add(map);
		}
		return list;
	}

	public static String convertToJsonArray(List<String /* JSON object */> paramJsons) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < paramJsons.size(); i++) {
			if (i != 0)
				sb.append(',');
			sb.append(paramJsons.get(i));
		}
		sb.append(']');
		return sb.toString();
	}

	/**
	 * Converts list of results to JSON array
	 * 
	 * @param list            - result list to convert
	 * @param resultSetFormat - result set format
	 * @return                - JSON array
	 */
	public static String convertToJsonArray(List<Map<String /* column name */, String /* JSON value */>> list, int resultSetFormat) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < list.size(); i++) {
			if (i != 0)
				sb.append(',');
			Map<String /* column name */, String /* JSON value */> row = list.get(i);
			if (resultSetFormat == RESULT_FORMAT_ARRAY_OF_OBJECTS)
				map2JsonObject(row, sb);
			else if (resultSetFormat == RESULT_FORMAT_ARRAY_OF_ARRAYS)
				map2JsonArray(row, sb);
		}
		sb.append(']');
		return sb.toString();
	}

	/**
	 * Converts list with only one element (list.size() == 1) to JSON object
	 * 
	 * @param list            - result list with only one element (list.size() == 1) to convert
	 * @param resultSetFormat - result set format
	 * @return                - JSON object
	 */
	public static String convertToJsonObject(List<Map<String /* column name */, String /* JSON value */>> list, int resultSetFormat) {
		String jsonArray = convertToJsonArray(list, resultSetFormat);
		return jsonArray.substring(1, jsonArray.length() - 1);
	}

	/**
	 * Converts map to JSON array
	 *
	 * @param map - map to convert
	 * @param sb  - StringBuilder to output results
	 */
	private static void map2JsonArray(Map<String /* column name */, String /* JSON value */> map, StringBuilder sb) {
		boolean first = true;
		sb.append('[');
		for (String /* JSON value */ value : map.values()) {
			if (first)
				first = false;
			else
				sb.append(',');
			sb.append(value);
		}
		sb.append(']');
	}

	/**
	 * Converts map to JSON object
	 *
	 * @param map - map to convert
	 * @param sb  - StringBuilder to output results
	 */
	private static void map2JsonObject(Map<String /* column name */, String /* JSON value */> map, StringBuilder sb) {
		boolean first = true;
		sb.append('{');
		for (Map.Entry<String /* column name */, String /* JSON value */> entry : map.entrySet()) {
			if (first)
				first = false;
			else
				sb.append(',');
			sb.append("\"" + entry.getKey() + "\":" + entry.getValue());
		}
		sb.append('}');
	}

	/**
	 * Compress byte array using ZLIB compression algorithm
	 * 
	 * @param bs - source byte array
	 * @return   - compressed byte array
	 *
	 * @throws IOException
	 */
	public static byte[] compress(byte[] bs, int compressionLevel) throws IOException {
		byte[]   tmp      = new byte[bs.length];
		Deflater deflater = new Deflater();
		deflater.setLevel(compressionLevel);
		deflater.setInput(bs);
		deflater.finish();
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			while (!deflater.finished()) {
				int size = deflater.deflate(tmp);
				baos.write(tmp, 0, size);
			}
			deflater.end();
			return baos.toByteArray();
		}
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
