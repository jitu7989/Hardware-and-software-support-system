package com.sys.dao;

import java.util.ArrayList;
import java.util.List;

import com.sys.bean.*;
import com.sys.util.*;
import java.sql.*;
import com.sys.exceptions.*;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public boolean login(Engineer e) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("Select * from engineer where username=? AND password=?");
			
			ps.setString( 1 , e.getUsername() );
			ps.setString( 2 , e.getPassword() );
			
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) {
				e.setEngineerID(rs.getInt(1) );
				return true;
			}
			
			if(con.prepareStatement("Select * from engineer where username=?").executeUpdate()==1) {
				throw new ExecutionException("Wrong Password");
			}
			throw new ExecutionException("User does not exist");
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
	}

	@Override
	public List<ProblemDTO> viewProblems( Engineer e )throws ExecutionException{
		
		List<ProblemDTO> ls = null;
		
		try(Connection con = ConnectionUtil.provideConnection()){
			System.out.println("Enginnerid: "+e.getEngineerID());
			PreparedStatement ps = con.prepareStatement("select p.problemid, p.description, p.status, p.raisedDate, e.engineerid, e.username, em.employeeid,em.username From problems p Inner Join engineer e INNER JOIN employee em ON p.EngineerAssigned=? AND p.EngineerAssigned=e.engineerid And p.raisedby = em.employeeid AND p.status=0");
			
			ps.setInt(1, e.getEngineerID());
			
			ResultSet rs = ps.executeQuery();
			ls = new ArrayList<>();
			while(rs.next()) {
				
				ProblemDTO pdto = new ProblemDTO();
				
				pdto.setProblemid(rs.getInt(1));
				pdto.setDescription(rs.getString(2));
				if( rs.getInt(3) == 0 ) 
					pdto.setStatus(false);
				else pdto.setStatus(true);
				
				pdto.setRaiseddate( rs.getDate(4));
				pdto.setEngineerid(rs.getInt(5));
				pdto.setEngineerUsername(rs.getString(6));
				pdto.setEmployeeid(rs.getInt(7));
				pdto.setEmployeeUsername(rs.getString(8));
				
				ls.add(pdto);
				
			}
		}
		catch(SQLException sqle){
			throw new ExecutionException(sqle.getMessage());
		}
		
		return ls;
	}

	@Override
	public boolean updateProblemStatus(int problemid,int update,Engineer e) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update problems Set status=? where problemid=? And engineerAssigned=?");
			
			ps.setInt(1, update );
			ps.setInt( 2 , problemid);
			ps.setInt(3, e.getEngineerID());
			
			if(ps.executeUpdate()!=1) {
				throw new ExecutionException("Failed to update");
			}
			return true;
			
		}
		catch(SQLException sqle){
			throw new ExecutionException(sqle.getMessage());
		}
		
		
	}

	@Override
	public List<ProblemDTO> viewProblemAttended( Engineer e ) throws ExecutionException{
		
		List<ProblemDTO> ls = null;
		
		try(Connection con = ConnectionUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select p.problemid, p.description, p.status, p.raisedDate, e.engineerid, e.username, em.employeeid,em.username From problems p Inner Join engineer e INNER JOIN employee em ON p.EngineerAssigned=? AND p.EngineerAssigned=e.engineerid And p.raisedby = em.employeeid AND p.status=1");
			
			ps.setInt(1, e.getEngineerID());
			
			ResultSet rs = ps.executeQuery();
			
			ls = new ArrayList<>();
			while(rs.next()) {
				
				ProblemDTO pdto = new ProblemDTO();
				
				pdto.setProblemid(rs.getInt(1));
				pdto.setDescription(rs.getString(2));
				if( rs.getInt(3) == 0 ) 
					pdto.setStatus(false);
				else pdto.setStatus(true);
				
				pdto.setRaiseddate( rs.getDate(4));
				pdto.setEngineerid(rs.getInt(5));
				pdto.setEngineerUsername(rs.getString(6));
				pdto.setEmployeeid(rs.getInt(7));
				pdto.setEmployeeUsername(rs.getString(8));
				
				ls.add(pdto);
				
			}
		}
		catch(SQLException sqle){
			
			throw new ExecutionException(sqle.getMessage());
		}
		
		return ls;
	}

	@Override
	public boolean changePassword(Engineer e) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection( )){
			
			PreparedStatement ps = con.prepareStatement("update engineer set password=? where engineerid=?");
			
			ps.setString(1, e.getPassword() );
			ps.setInt(2, e.getEngineerID());
			
			if(ps.executeUpdate()!=1) {
				throw new ExecutionException("Failed to change password");
			}
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		
		
		return true;
	}
	
	
	
}
	
