package com.sys.usecases;

import java.util.List;

import com.sys.bean.ProblemDTO;
import com.sys.dao.EngineerDao;
import com.sys.dao.EngineerDaoImpl;
import com.sys.exceptions.ExecutionException;
import com.sys.bean.*;

public class ViewAttendedProblem {

	public static void run(Engineer e) {
		
		System.out.println("Attended Problems:-");
		System.out.println("===================");
		
		EngineerDao ed = new EngineerDaoImpl();
		
		
		try {
			
			List<ProblemDTO> p = ed.viewProblemAttended(e);
			
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
