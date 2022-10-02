package com.sys.dao;

import java.util.*;
import com.sys.bean.*;
import com.sys.exceptions.ExecutionException;

public interface EmployeeDao {

	public boolean login(Employee e) throws ExecutionException;
	
	public boolean registerComplaint(ProblemDTO PDTO)throws ExecutionException;
	
	public ProblemDTO seeStatus(int complaintId,Employee x) throws ExecutionException;
	
	public List<ProblemDTO> seeComplainHistory(Employee e) throws ExecutionException;
	
	public boolean changePassword(Employee e) throws ExecutionException;
	
}
