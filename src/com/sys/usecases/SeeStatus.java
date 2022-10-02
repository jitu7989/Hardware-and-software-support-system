package com.sys.usecases;

import com.sys.bean.*;
import com.sys.dao.*;
import  java.util.*;

public class SeeStatus {
	public static void run(Employee e) {
		
		EmployeeDao ed = new EmployeeDaoImpl(); 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter complaint id: ");
		int complaintid = sc.nextInt();
		
		try {
			ProblemDTO pd= ed.seeStatus( complaintid , e );
			System.out.println("====================");
			System.out.println("Complaint: ");
			System.out.println("Complaint description:- "+pd.getDescription()+" -|- Raised date:- "+pd.getRaiseddate());
			System.out.println("Engineer ID:- "+ pd.getEngineerid());
			if(pd.getStatus())
				System.out.println("Status:- "+"Resolved");
			else System.out.println("Status:- "+"Not Resolved");
			System.out.println("====================");
		}
		catch(Exception exce) {
			System.out.println(exce.getMessage());
		}
		
	}
}
