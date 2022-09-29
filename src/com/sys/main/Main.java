package com.sys.main;

import java.util.*;
import com.sys.dao.*;
import com.sys.exceptions.ExecutionException;
import com.sys.bean.*;

public class Main {

	public static void main(String[] args) {
		
		HodDAOImpl hd = new HodDAOImpl();
		
		try {
		hd.getRaisedProblem().forEach(i->System.out.println(i));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
