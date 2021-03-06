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
E-Mail: fbsql.team@gmail.com
*/

package org.fbsql_server;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import org.fbsql.servlet.DbServlet;
import org.fbsql.servlet.SqlParseUtils;

public class Main {

	/**
	 * Called from start.sh script
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String fbsql_home_dir = System.getenv(DbServlet.FBSQL_HOME_DIR_ENV_NAME);
		if (fbsql_home_dir == null)
			fbsql_home_dir = System.getProperty("user.home");
		new File(fbsql_home_dir).mkdirs();

		/* Process application settings directory (child of user home directory) */
		String appDir        = fbsql_home_dir + "/fbsql";  // *** BRANDING ARTIFACT *** //
		String logsDir       = appDir + "/logs";
		String configDir     = appDir + "/config";
		String fbsqlConfDir  = configDir + "/init";
		String tomcatDir     = configDir + "/tomcat";
		String tomcatConfDir = tomcatDir + "/conf";
		String tomcatBinDir  = tomcatDir + "/bin";
		String tomcatROOTDir = tomcatDir + "/webapps/ROOT";
		String jreConfDir    = configDir + "/jre/conf";

		Path appDirPath = Paths.get(appDir);

		if (Files.exists(appDirPath) && Files.isDirectory(appDirPath)) {
			/* Java Runtime Environment (JRE) configuration (optional) */
			Path jreConfDirPath = Paths.get(jreConfDir);

			if (Files.exists(jreConfDirPath) && Files.isDirectory(jreConfDirPath))
				copyDir(jreConfDir, "jre/conf");

			Path tomcatConfDirPath = Paths.get(tomcatConfDir);

			/* Patch conf/logging.properties file */
			Path   loggingPropertiesPath    = Paths.get(tomcatConfDir, "logging.properties");
			String loggingPropertiesContent = new String(Files.readAllBytes(loggingPropertiesPath), StandardCharsets.UTF_8);
			loggingPropertiesContent = loggingPropertiesContent.replace("${catalina.base}/logs", logsDir);
			Files.write(loggingPropertiesPath, loggingPropertiesContent.getBytes(StandardCharsets.UTF_8));

			/* Patch conf/server.xml file */
			Path   serverXmlPath    = Paths.get(tomcatConfDir, "server.xml");
			String serverXmlContent = new String(Files.readAllBytes(serverXmlPath), StandardCharsets.UTF_8);
			serverXmlContent = serverXmlContent.replace("directory=\"logs\"", "directory=" + '"' + logsDir + '"');
			Files.write(serverXmlPath, serverXmlContent.getBytes(StandardCharsets.UTF_8));

			/* setenv.sh */
			// copy setenv.sh if not exits from server to user home directory
			Path tomcatBinDirPath = Paths.get(tomcatBinDir);
			Path setenvPath       = Paths.get(tomcatBinDir, "setenv.sh");
			if (!Files.exists(setenvPath)) {
				Path serverSetenvPath = Paths.get("bin/setenv.sh");
				Files.copy(serverSetenvPath, tomcatBinDirPath.resolve(serverSetenvPath.getFileName()), StandardCopyOption.COPY_ATTRIBUTES);
			}

			/* Custom Apache Tomcat configuration (optional) */
			if (Files.exists(tomcatConfDirPath) && Files.isDirectory(tomcatConfDirPath))
				copyDir(tomcatConfDir, "conf");

			/* public files index.html etc. (optional) */
			Path tomcatROOTDirPath = Paths.get(tomcatROOTDir);
			if (Files.exists(tomcatROOTDirPath) && Files.isDirectory(tomcatROOTDirPath))
				copyDir(tomcatROOTDir, "webapps/ROOT");
		}

		System.out.println("    • Config directory: " + configDir);
		System.out.println("    • Logs directory  : " + logsDir);
		System.out.println("    • JDBC drivers:");
		ServiceLoader<Driver> loadedDrivers = ServiceLoader.load(Driver.class);
		for (Driver driver : loadedDrivers) {
			try {
				DriverManager.registerDriver(driver);
				String driverClassName = driver.getClass().getName();
				String driveName       = driver.toString();
				String s               = "      • " + driverClassName;
				if (!driveName.startsWith(driverClassName + "@")) // we print only meaningful name 
					s += " (" + driveName + ")";
				System.out.println(s);
			} catch (SQLException e) {
				// ignore
			}
		}
		System.out.println("    • Connectors:");
		Path fbsqlConfDirPath = Paths.get(fbsqlConfDir);

		Map<String /* connection name */, List<String /* SQL statements */>> initSqlMap         = new HashMap<>();
		Map<String /* connection name */, String /* parent directory */>     parentDirectoryMap = new HashMap<>();
		SqlParseUtils.processInitSqlFiles(new File(fbsqlConfDirPath.toString()), initSqlMap, parentDirectoryMap);
		for (String /* connection name */ instanceName : initSqlMap.keySet())
			System.out.println("      • " + instanceName);

		int instancesCount = initSqlMap.size();
		if (instancesCount == 0)
			System.out.println("No instances found");
		System.out.println();
		System.out.println();
	}

	private static boolean copyDir(String src, String dest) throws IOException {
		Path      sourcePath = Paths.get(src);  // source
		Path      targetPath = Paths.get(dest); // target
		boolean[] copied     = new boolean[1];
		Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
				Files.createDirectories(targetPath.resolve(sourcePath.relativize(dir)));
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
				Files.copy(file, targetPath.resolve(sourcePath.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
				copied[0] = true;
				return FileVisitResult.CONTINUE;
			}
		});
		return copied[0];
	}
}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
