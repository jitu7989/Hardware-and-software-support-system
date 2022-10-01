package com.sys.usecases;

import java.util.List;

import com.sys.bean.ProblemDTO;
import com.sys.dao.*;

public class GetProblems {
	public static void run() {
		System.out.println("Getting Problem Raised...");
		HodDAO hd = new HodDAOImpl();
		try {
			List<ProblemDTO> ls= hd.getRaisedProblem();
			
			ls.forEach(i->{
				System.out.println("===============");
				System.out.println("ProblemID: "+i.getProblemid()+" Raised date:- "+i.getRaiseddate().toLocalDate());
				System.out.println("Problem Description: "+i.getDescription()+" Attended:- "+i.getStatus() );
				System.out.println("Engineer Details:- Id="+i.getEngineerid()+" UserName="+i.getEngineerUsername());
				System.out.println("Employee Details:- Id="+i.getEmployeeid() +" UserName="+i.getEmployeeUsername() );
				System.out.println("===============");
			});
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
