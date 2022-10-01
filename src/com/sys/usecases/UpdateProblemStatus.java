package com.sys.usecases;

import java.util.*;
import com.sys.dao.*;
import com.sys.bean.*;

public class UpdateProblemStatus {

	public static void run(Engineer engineer) {
		
		System.out.println("To update the problem status ");
		
		Scanner sc = new Scanner(System.in);
		
		int problemid;
		int status;
		
		while(true) {
			System.out.println("Enter Problem id: ");
			try {
				problemid = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Enter a valid integer value");
				continue;
			}
			System.out.println("Enter update: ( 0 and negetive = Not Attend and positive integer = Attended )");
			try {
				status = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Enter a valid integer value");
				continue;
			}
			break;
			
		}
		if(status<=0) status = 0;
		else status =1 ;
		
		EngineerDao ed = new EngineerDaoImpl();
		
		try {
			ed.updateProblemStatus(problemid, status,engineer);
		}
		catch(Exception e) {
			
		}
		
	}
	
}
