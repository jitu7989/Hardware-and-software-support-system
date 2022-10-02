package com.sys.usecases;

import java.util.Scanner;

import com.sys.bean.*;
import com.sys.dao.*;

public class EngineerPortal {
	public static boolean start() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Log in into your account: ");
		System.out.println("Press # to go Back to home: ");
		EngineerDao engi = new EngineerDaoImpl();
		
		Engineer eng = new Engineer();
		
		while(true) {
			
			
			
			System.out.println("Enter username: ");
			String username = sc.nextLine();
			if( username.equals("#") ) return true;
			
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			if( password.equals("#") ) return true;
			
			eng.setUsername(username);
			eng.setPassword(password);
			
			try {
				if( engi.login(eng) ) {
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
			
			System.out.println("1.) View Problems : ");
			System.out.println("2.) Update problem status: ");
			System.out.println("3.) View problem attended: ");
			System.out.println("4.) Change Password ");
			System.out.println("5.) Go back to home");
			System.out.println("6.) Exit");
			
			int x = 0;
			
			try {
				x = Integer.parseInt( sc.nextLine() );
			}
			catch(Exception e) {
				x=0;
			}
			switch(x) {
				
				case 1: 
					ViewAssignedProblem.run(eng);
					break;
				case 2: 
					UpdateProblemStatus.run(eng);
					break;
				case 3: 
					ViewAttendedProblem.run(eng);
					break;
				case 4: 
					ChangePasswordEngineer.run(eng);
					break;
				case 5: 
					return true;
				case 6: 
					return false;
				default:System.out.println("Try again");
			
			}
			
		}
		
		return false;
		
	}
}
