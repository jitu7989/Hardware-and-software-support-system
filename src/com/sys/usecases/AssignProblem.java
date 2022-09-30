package com.sys.usecases;

import com.sys.dao.*;
import java.util.Scanner;

public class AssignProblem {
	public static void run() {
		HodDAO hd = new HodDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Problem Id");
		int x = sc.nextInt();
		System.out.println("Enter engineer id to assigned: ");
		int y =  sc.nextInt();
		sc.close();
		try {
			hd.assignProblem(x, y);
			System.out.println("Problem Assigned successfully");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
