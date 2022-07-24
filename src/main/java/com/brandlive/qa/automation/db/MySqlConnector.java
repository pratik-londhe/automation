package com.brandlive.qa.automation.db;

import com.brandlive.qa.automation.utils.Doer;
import com.brandlive.qa.automation.utils.LoginInfo;
import com.brandlive.qa.automation.utils.LoginXmlParser;
import com.brandlive.qa.automation.utils.PropertiesParser;

public class MySqlConnector extends Doer {

	private MySqlDb db = null;

	protected void connectToGreenroomDb() {
		String loginKey = PropertiesParser.instance().get(PropertiesParser.LOGIN_KEY);
		LoginInfo login = LoginXmlParser.instance().getLogin(loginKey);
		log.debug("  login: " + login);
		String hostname = login.getGreenroomDBHost();
		String port = login.getGreenroomDBPort();
		String dbname = login.getGreenroomDBName();
		String username = login.getGreenroomDBUser();
		String password = login.getGreenroomDBPassword();
		connectToDb(hostname, dbname, port, username, password);
	}

	protected void connectToEventDb() {
		String loginKey = PropertiesParser.instance().get(PropertiesParser.LOGIN_KEY);
		LoginInfo login = LoginXmlParser.instance().getLogin(loginKey);
		log.debug("  login: " + login);
		String hostname = login.getEventsDBHost();
		String port = login.getEventsDBPort();
		String dbname = login.getEventsDBName();
		String username = login.getEventsDBUser();
		String password = login.getEventsDBPassword();
		connectToDb(hostname, dbname, port, username, password);
	}

	protected void connectToDb(String hostname, String dbname, String port, String username, String password) {
		if (hostname == null || dbname == null || port == null || username == null || password == null) {
			log.debug(String.format("Hostname: %s, DB: %s, Port: %s, Username: %s, Password: %s", hostname, dbname,
					port, username, password));
			skipScenario("Missing database connection information, fix your blLogins.xml");
			return;
		}
		try {
			db = new MySqlDb(hostname, port, dbname, username, password);
		} catch (Exception e) {
			skipScenario(e, "Unable to connect to mysql");
		}
	}

	protected void closeConnection() {
		db.closeConnection();
	}

	public String getGR_TableColumnValue(String columnName, String columnDataType, String query) {
		connectToGreenroomDb();
		String columnValue = db.getValue(columnName, columnDataType, query);
		closeConnection();
		if (columnValue == null)
			return "0";
		else
			return columnValue;
	}
	
	public String getEvents_TableColumnValue(String columnName, String columnDataType, String query) {
		connectToEventDb();
		String columnValue = db.getValue(columnName, columnDataType, query);
		closeConnection();
		if (columnValue == null)
			return "0";
		else
			return columnValue;
	}
}
