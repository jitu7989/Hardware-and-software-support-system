package com.sys.main;

import java.util.*;
import com.sys.usecases.*;
import com.sys.dao.*;
import com.sys.exceptions.ExecutionException;
import com.sys.bean.*;

public class Main {

	public static void main(String[] args) {
		System.out.println( "Welcome to Hardware and Software Support system:- " );
		
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.println( "Select one of these option:- " );
			System.out.println("0.) House of Department Login: ");
			System.out.println("1.) Engineer login: ");
			System.out.println("2.) Employee login: ");
			System.out.println("3.) Exit ");
			int x;
			try {
				x = sc.nextInt();
			}
			catch(NumberFormatException e) {
				System.out.println("Try again wrong option");
				continue;
			}
			
			
			switch(x) {
			case 0:
				if(!HouseOfDepartmentPortal.start()) flag= false;
			case 1:
				if(!EngineerPortal.start()) flag = false;
				break;
			case 2:
				if(!EmployeePortal.start()) flag = false;
				break;
			case 3:
				flag = false;
				break;
			default: System.out.println("Try again wrong option choosed");
				
			}
		}
		
		System.out.println("Thanks for using the service! ");
		
		
	}

}
