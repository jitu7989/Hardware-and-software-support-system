package com.sys.dao;
import java.util.*;
import com.sys.bean.HouseOfDepartmentDao;
import com.sys.exceptions.ExecutionException;
import com.sys.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Objects;
import com.sys.bean.*;

public interface HodDAO {
	
//	public HouseOfDepartmentDao login( String username , String password );
	
	public boolean registerEngineer(Engineer e) throws Exception;
	
	default boolean authenthicate(HouseOfDepartmentDao a) throws Exception{
		
		try(Connection con = ConnectionUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM HouseOfDepartment WHERE username=? AND password=?");
			
			ps.setString(1, a.getUserName());
			ps.setInt(2, Objects.hash(a.getPassword()));
			
			
			if(ps.executeQuery().next()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(SQLException e){
			throw new ExecutionException( e.getMessage() );
		}
	}
	
	public List<Engineer> getEnginners() throws ExecutionException;
	
	public String kickEngineer(Engineer e) throws ExecutionException;
	
	public List<ProblemDTO> getRaisedProblem() throws ExecutionException;
	
	public boolean assignProblem(int problemid,int engineerid)throws ExecutionException;
	
}
