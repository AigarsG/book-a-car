package bookacar.common.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnectionPool {
	private static final DataSource dataSource;

	static {
		// TODO Create database if not exists or something
		try {
			Context initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:comp/env");
			dataSource = (DataSource) context.lookup("jdbc/postgres");
		} catch (NamingException e) {
			System.err.println(e);
			throw new ExceptionInInitializerError("dataSource not initialized");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
