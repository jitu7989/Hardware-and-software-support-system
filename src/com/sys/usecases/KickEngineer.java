package com.sys.usecases;

//import com.sys.util.*;
import java.util.*;
//import java.sql.*;
import com.sys.bean.*;
import com.sys.dao.*;

public class KickEngineer {
	
	
	public static void run() {
		
		Scanner sc = new Scanner(System.in);
		
		Engineer eng = new Engineer();
		
		System.out.println("Enter engineer id to kick: ");
		eng.setEngineerID(Integer.parseInt(sc.nextLine() ));
		
		HodDAO hd = new HodDAOImpl();
		
		try {
			
			System.out.println( hd.kickEngineer(eng) );
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
