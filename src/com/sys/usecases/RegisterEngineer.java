package com.sys.usecases;

import com.sys.bean.Engineer;
import com.sys.dao.*;
import java.util.Scanner;

public class RegisterEngineer {
	
	public static boolean run() {
		
		Scanner sc = new Scanner(System.in);
		Engineer e = new Engineer();
		
		System.out.println("To register engineer enter initial username and password");
		
		System.out.println("Enter username: ");
		e.setUsername(sc.next());
		
		System.out.println("Enter password:");
		e.setPassword( sc.next() );
//		sc.close();
		
		HodDAOImpl hodimpl = new HodDAOImpl();
		
		try {
		hodimpl.registerEngineer(e);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		
		return true;
	}
	
}
