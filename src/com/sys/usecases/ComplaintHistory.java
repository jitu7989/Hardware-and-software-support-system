package com.sys.usecases;

import com.sys.bean.*;
import com.sys.dao.*;
import java.util.*;

public class ComplaintHistory {
	
	public static void run(Employee e) {
		
		System.out.println("Complaint History");
		System.out.println("=================");
		
		EmployeeDao ed = new EmployeeDaoImpl();
		try {
			
			List<ProblemDTO> ls = ed.seeComplainHistory(e);
			
			ls.sort( (a,b)->a.getRaiseddate().compareTo(b.getRaiseddate()) );
			
			ls.forEach( i->{
				
				System.out.println("Complaint ID:- "+i.getProblemid());
				System.out.println("Complain decription:- "+i.getDescription()+" -|- Raised date:- "+i.getRaiseddate());
				String x;
				if(i.getStatus()) x ="Ressolved";
				else x= "Not Ressolved";
				System.out.println("Assigned Engineer:- ID = "+i.getEngineerid()+" -|- Status:- "+x);
				System.out.println("================");
				
			} );
			
		}
		catch(Exception exe) {
			System.out.println(exe.getMessage());
		}
		
	}
	
}
