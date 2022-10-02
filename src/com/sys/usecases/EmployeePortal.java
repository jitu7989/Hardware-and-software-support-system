package com.sys.usecases;

import java.util.Scanner;

import com.sys.bean.*;
import com.sys.dao.*;

public class EmployeePortal {
	public static boolean start() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Log in into your account");
		System.out.println("Press # to go Back to home: ");
		
		EmployeeDao empi = new EmployeeDaoImpl();
		
		Employee emp = new Employee();
		
		while(true) {
			
			
			
			System.out.println("Enter username: ");
			String username = sc.nextLine();
			if( username.equals("#") ) return true;
			
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			if( password.equals("#") ) return true;
			
			emp.setUsername(username);
			emp.setPassword(password);
			
			try {
				if( empi.login(emp) ) {
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
			
			System.out.println("1.) Register a complaint: ");
			System.out.println("2.) See complaint Status: ");
			System.out.println("3.) See complaint history: ");
			System.out.println("4.) Change Password: ");
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
					RegisterComplaint.run(emp);
					break;
				case 2: 
					SeeStatus.run(emp);
					break;
				case 3: 
					ComplaintHistory.run(emp);
					break;
				case 4: 
					ChangePasswordEmployee.run(emp);
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
