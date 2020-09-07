package com.cricket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	

	public static Connection getDBConnection() {
		Connection con=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/siva","root","siva");
			 System.out.println("Connected");
			}
		catch(Exception e){ 
			System.out.println(e);}
		return con;  
	}	

}
