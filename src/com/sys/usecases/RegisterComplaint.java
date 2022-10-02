package com.sys.usecases;

import com.sys.bean.*;
import java.util.*;
import com.sys.dao.*;

public class RegisterComplaint {
	
	public static void run(Employee e) {
		
		Scanner sc  =new Scanner(System.in);
		
		System.out.println("Enter Problem Discription: ");
		String desc = sc.nextLine();
		
		try {
			
			EmployeeDaoImpl edi =new EmployeeDaoImpl();
			ProblemDTO pdto = new ProblemDTO();
			
			pdto.setDescription(desc);
			pdto.setEmployeeid(e.getEmployeeid());
			
			edi.registerComplaint(pdto);
			System.out.println("Registration Done");
		}
		catch(Exception exe) {
			
			System.out.println( exe.getMessage() );
			
		}
		
	}
	
}
