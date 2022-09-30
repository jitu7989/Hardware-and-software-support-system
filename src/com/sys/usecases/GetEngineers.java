package com.sys.usecases;

import com.sys.dao.*;
import java.util.List;
import com.sys.bean.Engineer;

public class GetEngineers {
	
	public static void run() {
		
		
		System.out.println("Getting enginners... ");
		HodDAO hd =  new HodDAOImpl();
		
		try {
			List<Engineer> ls = hd.getEnginners();
			
			for(Engineer i:ls) {
				
				System.out.println("Enginner ID: "+i.getEngineerID());
				System.out.println("Engineer Username: " + i.getUsername());
				System.out.println("==================================");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
