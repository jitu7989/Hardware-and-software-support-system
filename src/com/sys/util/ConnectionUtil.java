package com.sys.util;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionUtil {

	public static Connection provideConnection() {
		
		Connection con =null;
		String url = "jdbc:mysql://localhost:3306/HSMS";
		try {
			con = DriverManager.getConnection( url , "root" ,"e12ald234fdkf32aksd32asd" );
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	
				
		return con;
	}
	
}
