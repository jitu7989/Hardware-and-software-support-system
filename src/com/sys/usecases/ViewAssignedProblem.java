package com.sys.usecases;

import com.sys.dao.*;
import com.sys.exceptions.ExecutionException;
import com.sys.bean.*;
import java.util.*;

public class ViewAssignedProblem {
	
	public static void run(Engineer e) {
	
		System.out.println("Assigned Problem");
		System.out.println("================");
		
		EngineerDao ed = new EngineerDaoImpl();
		
		
		try {
			
			List<ProblemDTO> p = ed.viewProblems(e);
			
			p.forEach( i->{
				System.out.println("===============");
				System.out.println("ProblemID: "+i.getProblemid()+" Raised date:- "+i.getRaiseddate().toLocalDate());
				System.out.println("Problem Description: "+i.getDescription());
				System.out.println("Engineer Details:- Id="+i.getEngineerid()+" UserName="+i.getEngineerUsername());
				System.out.println("Employee Details:- Id="+i.getEmployeeid() +" UserName="+i.getEmployeeUsername() );
				System.out.println("===============");
			});
			
		} catch (ExecutionException e1) {
			System.out.println( e1.getMessage() );
		}
		
	}
	
}
