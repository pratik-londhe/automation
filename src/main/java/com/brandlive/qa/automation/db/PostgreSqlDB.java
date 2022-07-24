package com.brandlive.qa.automation.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class PostgreSqlDB {
	
	private Connection connection = null;
	private final Logger log = Logger.getLogger(getClass());

	@SuppressWarnings("deprecation")
	protected PostgreSqlDB(String hostName, String port, String databaseName, String dataBaseUserName,
			String dataBasePassword) {
		String url = "jdbc:postgresql://" + hostName + ":" + port + "/" + databaseName;

		log.debug("HostName : " + hostName);
		log.debug("Port : " + port);
		log.debug("DatabaseName : " + databaseName);
		log.debug("Url : " + url);
		log.debug("DB UserName : " + dataBaseUserName);
		log.debug("DB Password : " + dataBasePassword);

		try {
			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(url, dataBaseUserName, dataBasePassword);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} catch (ClassNotFoundException ex) {
			log.warn("Caught ClassNotFoundException, while trying to connect to DB : " + ex.getMessage());
			throw new RuntimeException(ex);
		} catch (Exception ex) {
			log.warn("Caught Exception, while trying to connect to DB : " + ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	protected ResultSet execute(String query) {
		Statement statement = null;
		try {
			log.debug("Executing SQL: " + query);
			statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException ex) {
			log.error("SQL Exception, while executing Query : " + ex.getMessage());
			return null;
		} catch (Exception ex) {
			log.error("Caught Exception, while executing Query : " + ex.getMessage());
			return null;
		} finally {
		}
	}

	protected void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException sqlExp) {
			log.info("Caught SQLException while trying to close the connection in closeConnection : "
					+ sqlExp.getMessage());
		} finally {
			log.info("Closing connection ...");
		}
	}

	protected void closeConnection() {
		closeConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	protected String getValue(String column, String columnDataType, String query) {
		ResultSet rs = execute(query);
		String returnValue = new String();
		try {
			if (!rs.next()) {
				return null;
			} else {
				switch(columnDataType) {
					case "String": returnValue = rs.getString(column); break;
					case "Boolean": returnValue = String.valueOf(rs.getBoolean(column)); break;
					case "Date": returnValue = rs.getDate(column).toString(); break;
					case "Int": returnValue = String.valueOf(rs.getInt(column)); break;
					case "Float": returnValue = String.valueOf(rs.getFloat(column)); break;
					case "Double": returnValue = String.valueOf(rs.getDouble(column)); break;
					case "Long": returnValue = String.valueOf(rs.getLong(column)); break;
					case "Short": returnValue = String.valueOf(rs.getShort(column)); break;
					case "Time": returnValue = rs.getTime(column).toString(); break;
					case "Timestamp": returnValue = rs.getTimestamp(column).toString(); break;	
					default: log.debug("Incorrect data type");			
				}
			}
			return returnValue;
		} catch (SQLException e) {
			log.error("Error in SQL Query " + query + ": " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
