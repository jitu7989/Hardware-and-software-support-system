package com.sys.dao;

import java.util.*;
import com.sys.bean.*;
import com.sys.exceptions.*;

public interface EngineerDao {

	public boolean login(Engineer e)throws ExecutionException;
	public List<ProblemDTO> viewProblems(Engineer e)throws ExecutionException;
	public boolean updateProblemStatus(int problemid,int update)throws ExecutionException;
	public List<ProblemDTO> viewProblemAttended( Engineer e )throws ExecutionException;
	public boolean changePassword(Engineer e ) throws ExecutionException;
	
}
