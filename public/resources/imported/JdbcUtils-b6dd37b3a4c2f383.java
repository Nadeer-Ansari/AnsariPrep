package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {
	//This is a utility class meant for establishing a DB Connection
	//and returning the same.
	public static Connection buildConnection() throws Exception {
		String URL = "jdbc:mysql://localhost:3306/cdac";
		String UID = "root";
		String PWD = "password";
		Connection dbConnection = 
				DriverManager.getConnection(URL, UID, PWD);
		return dbConnection;
	}
	
}
