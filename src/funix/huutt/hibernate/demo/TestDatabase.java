package funix.huutt.hibernate.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDatabase {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try { 
			
			System.out.println("Connecting to database: " + jdbcURL);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcURL, user, pass);
			
			System.out.println("Connection successful!!!!");
			
			System.out.println(myConn);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
