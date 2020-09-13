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

package org.fbsql.servlet;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ServiceLoader;

import javax.servlet.http.HttpServlet;

public class ClassLoaderUtils extends HttpServlet {

	/**
	 * Load JDBC driver class from jar files specified as value of "jdbc.jars" property name in configuration file
	 * Value "jdbc.jars" must contains comma-separated JARs file names or URLs
	 * 
	 * @param  array of JAR files
	 * @return custom URL ClassLoader based on specified JAR files
	 */
	static ClassLoader createClassLoader(List<String> jars) {
		URL[] urls = new URL[jars.size()];
		for (int i = 0; i < urls.length; i++) {
			String el = jars.get(i).trim();
			if (el.isEmpty())
				continue;
			if (!el.startsWith("file://") && !el.startsWith("http://") && !el.startsWith("https://"))
				el = "file://" + el;
			try {
				urls[i] = new URL(el);
			} catch (MalformedURLException e) {
				System.out.println("WARNING Ignored malformed URL: " + el);
			}
		}
		return new URLClassLoader(urls);
	}

	/**
	 * Register JDBC driver
	 * 
	 * DriverManager will refuse to use a driver not loaded by
	 * the system ClassLoader
	 * The workaround for this is to use a shim class that implements
	 * java.sql.Driver. This shim class will do nothing but call the methods
	 * of an instance of a JDBC driver that is loaded dynamically. This works
	 * because DriverShim is loaded by the system class loader, and DriverManager
	 * doesn't care that it invokes a class that wasn't.
	 * 
	 * @see DriverShim
	 * 
	 * @param jars        value of "jdbc.jars" property name in configuration file
	 * @param classLoader custom URL ClassLoader
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static void registerJdbcDriver(String jdbcDriverClassName, List<String> driverJars) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, ClassNotFoundException {
		if (jdbcDriverClassName == null && driverJars != null) {
			ClassLoader           classLoader = ClassLoaderUtils.createClassLoader(driverJars);
			ServiceLoader<Driver> loader      = ServiceLoader.load(Driver.class, classLoader);
			for (Driver driver : loader)
				DriverManager.registerDriver(new DriverShim(driver));
		} else if (jdbcDriverClassName != null && driverJars != null) {
			ClassLoader classLoader = ClassLoaderUtils.createClassLoader(driverJars);
			Driver      driver      = (Driver) Class.forName(jdbcDriverClassName, true, classLoader).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver(new DriverShim(driver));
		} else if (jdbcDriverClassName != null && driverJars == null) {
			Driver driver = (Driver) Class.forName(jdbcDriverClassName).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver(new DriverShim(driver));
		}
	}

}

/*
Please contact FBSQL Team by E-Mail fbsql.team@gmail.com
or visit https://fbsql.github.io if you need additional
information or have any questions.
*/

/* EOF */
