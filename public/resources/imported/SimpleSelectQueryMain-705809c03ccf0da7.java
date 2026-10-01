package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQueryMain {
	static {
		//Static Block gets called when the class is loaded
	}

	public static void main(String[] args) {
		/*
		 1.	Load the driver (Load the driver specific class)
		 2.	Establish Connection
		 3.	Obtain some Statement
		 4.	Execute SQL Query
		 5.	In case of SELECT query, obtain a ResultSet and perform navigation
		 */
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverClassName);
			System.out.println("Driver loaded.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String URL = "jdbc:mysql://localhost:3306/cdac";
		String UID = "root";
		String PWD = "password";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet recordSet = null;
		
		try {
			dbConnection = DriverManager.getConnection(URL, UID, PWD);
			System.out.println("Connected to MySQL DB.");
			stmt = dbConnection.createStatement();
			String sqlQuery = "select dname, loc, deptno from dept";
			recordSet = stmt.executeQuery(sqlQuery);
			while(recordSet.next()) {
				String deptName = recordSet.getString(1);
				String deptLoc = recordSet.getString(2);
				int deptNo = recordSet.getInt(3);
				System.out.println(deptName + " " + deptLoc + " " + deptNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				recordSet.close();
				stmt.close();
				dbConnection.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

}






