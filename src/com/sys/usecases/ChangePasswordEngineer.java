package com.sys.usecases;

import com.sys.bean.*;
import com.sys.dao.*;
import java.util.*;

public class ChangePasswordEngineer {

	public static void run(Engineer e) {
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter your current password: ");
			try {
				String oldpass = sc.next();
				if( oldpass.equals( e.getPassword() ) ) break;
				else System.out.println("Password do not match: ");
			}
			catch(Exception exc) {
				System.out.println("Wrong input");
			}
		}
		
		String newpass;
		String confirmpass;
		
		while(true) {
			
			
			try {
				System.out.println("Enter your new password: ");
				newpass = sc.next();
			}
			catch(Exception exce) {
				System.out.println("Enter valid input");
				continue;
			}
			
			
			try {
				System.out.println("Confirm your password: ");
				confirmpass = sc.next();
			}
			catch(Exception exce) {
				System.out.println("Enter valid input");
				continue;
			}
			
			
			
			if(!newpass.equals( confirmpass ) ) {
				System.out.println("Password do not match");
				continue;
			}
			if( !password(newpass) ) {
				System.out.println("your password must contain more than 8 characters.");
			}
			
			break;
		}
		
		EngineerDao ed = new EngineerDaoImpl();
		e.setPassword(confirmpass);
		try {
			ed.changePassword(e);
		}
		catch(Exception exce) {
			System.out.println(exce.getMessage());
		}

	}
	public static boolean password(String newpass) {
		
		try {
			if(newpass.length()<8) return false;
		}
		catch(Exception e) {
			return false;
		}
		
		
		return true;
	}
}
