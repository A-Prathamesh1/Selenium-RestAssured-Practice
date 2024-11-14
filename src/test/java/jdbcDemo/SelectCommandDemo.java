package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectCommandDemo {
	public static void main(String[] args) throws SQLException  {
		/*
		 * 1) Create a connection 2) Create statement/Query 3) Execute statement/Query
		 * 4) Store results into result set 5) close connection
		 */
		// 1) creating connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "root");

		// 2) create statement / query
		Statement stmt = con.createStatement();

//		String insertQuery = "INSERT INTO STUDENTS VALUES(4,'Prat')";
//		String updateQuery = "UPDATE STUDENTS SET SNAME='dav' WHERE SID=3";
//		String deleteQuery = "DELETE FROM STUDENTS WHERE SID= 3";
		String selectQuery = "SELECT EMPLOYEE_ID,FIRST_NAME,last_name FROM EMPLOYEES";
//		3) execute the query
		ResultSet res = stmt.executeQuery(selectQuery);
		while (res.next()) {
			int eid = res.getInt("EMPLOYEE_ID");
			String first_name = res.getString("FIRST_NAME");
			String last_name = res.getString("last_name");
			System.out.println(eid + " " + first_name + " " + last_name);
		}
//		4) close connection
		con.close();

//		System.out.println("Inserted");
	}
}
