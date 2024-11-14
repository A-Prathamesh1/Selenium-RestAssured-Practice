package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDMLCommands {
	public static void main(String[] args) throws SQLException {
		/*
		 * 1) Create a connection 2) Create statement/Query 3) Execute statement/Query
		 * 4) Store results into result set 5) close connection
		 */
		// 1) creating connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		// 2) create statement / query
		Statement stmt = con.createStatement();

		String insertQuery = "INSERT INTO STUDENTS VALUES(4,'Prat')";
		String updateQuery = "UPDATE STUDENTS SET SNAME='dav' WHERE SID=3";
		String deleteQuery = "DELETE FROM STUDENTS WHERE SID= 3";
//		3) execute the query
		stmt.execute(deleteQuery);

//		4) close connection
		con.close();

		System.out.println("Inserted");
	}
}
