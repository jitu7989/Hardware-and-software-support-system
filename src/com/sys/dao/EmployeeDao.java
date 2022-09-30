package com.sys.dao;

import java.util.*;
import com.sys.bean.*;
import com.sys.exceptions.ExecutionException;

public interface EmployeeDao {

	public boolean login(Employee e) throws ExecutionException;
	
	public boolean registerComplaint()throws ExecutionException;
	
	public ProblemDTO seeStatus(int complaintId) throws ExecutionException;
	
	public List<ProblemDTO> seeComplainHistory() throws ExecutionException;
	
	public boolean changePassword(Employee e) throws ExecutionException;
	
}
