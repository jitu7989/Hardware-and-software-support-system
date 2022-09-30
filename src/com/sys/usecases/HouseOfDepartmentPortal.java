package com.sys.usecases;

import java.util.*;
import java.sql.*;

import com.sys.bean.*;
import com.sys.dao.*;

public class HouseOfDepartmentPortal {
	
	public static boolean start() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("To manage the system login: ");
		System.out.println("Press # to go Back to home: ");
		HodDAO admin = new HodDAOImpl();
		
		while(true) {
			
			HouseOfDepartmentDao hod = new HouseOfDepartmentDao();
			
			System.out.println("Enter username: ");
			String username = sc.nextLine();
			if( username.equals("#") ) return true;
			
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			if( password.equals("#") ) return true;
			
			hod.setUserName(username);
			hod.setPassword(password);
			
			try {
				if(admin.authenthicate(hod)) {
					break;
				}
				else {
					System.out.println("Wrong credentials try again");
				}
				
			}
			catch(Exception sqle) {
				
				System.out.println(sqle.getMessage());
				return true;
			}
			
		}
		
		System.out.println("Login Successfully");
		boolean flag = true;
		while(flag) {
			
			System.out.println("1.) Register a engineer: ");
			System.out.println("2.) Get list of register engineers: ");
			System.out.println("3.) Kick an engineer: ");
			System.out.println("4.) Get list of raised problem: ");
			System.out.println("5.) Assign a problem to an engineer: ");
			System.out.println("6.) Go back to home");
			System.out.println("7.) Exit");
			
			int x = 0;
			try {
				x = Integer.parseInt( sc.nextLine() );
			}
			catch(Exception e) {
				x=0;
			}
			switch(x) {
				
				case 1: 
					RegisterEngineer.run();
					break;
				case 2: 
					GetEngineers.run();
					break;
				case 3: 
					KickEngineer.run();
					break;
				case 4: 
					GetProblems.run();
					break;
				case 5: break;
				case 6: break;
				case 7: return false;
				default:System.out.println("Try again");
			
			}
			
		}
		
		return false;
	}
	
}
