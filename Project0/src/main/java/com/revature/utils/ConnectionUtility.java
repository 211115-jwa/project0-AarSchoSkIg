package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {
	private static ConnectionUtility connUtil;
	private static Properties databaseProps;
	
	private ConnectionUtility() {
		databaseProps = new Properties();
		
		try {
			// grabbing the properties file using the JVM's class loader
			InputStream propertiesFileStream = ConnectionUtility.class.
					getClassLoader().getResourceAsStream("database.properties");
			databaseProps.load(propertiesFileStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ConnectionUtility getConnectionUtil() {
		if (connUtil == null)
			connUtil = new ConnectionUtility();
		return connUtil;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(databaseProps.getProperty("drv"));
			conn = DriverManager.getConnection(
					databaseProps.getProperty("brand"),
					databaseProps.getProperty("color"),
					databaseProps.getProperty("terrainType"));
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
