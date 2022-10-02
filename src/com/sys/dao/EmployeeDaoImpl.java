package com.sys.dao;

import java.util.ArrayList;
import java.util.List;

import com.sys.bean.*;
import com.sys.exceptions.ExecutionException;
import com.sys.util.ConnectionUtil;
import java.sql.*;


public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public boolean login(Employee e) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("Select * from employee where username=? AND password=?");
			
			ps.setString( 1 , e.getUsername() );
			ps.setString( 2 , e.getPassword() );
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				e.setEmployeeid( rs.getInt("employeeid") );
				return true;
			}
			
			if(con.prepareStatement("Select * from engineer where username="+e.getUsername() ).executeUpdate()==1) {
				throw new ExecutionException("Wrong Password");
			}
			throw new ExecutionException("User does not exist");
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
	}


	@Override
	public boolean registerComplaint(ProblemDTO PDTO) throws ExecutionException{
		
		try( Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement preps = con.prepareStatement("SELECT EngineerId from Engineer");
			
			ResultSet rs = preps.executeQuery();
			List<ProblemDTO> lst = new ArrayList<>();
			
			while( rs.next() ) {
				
				ProblemDTO pd = new ProblemDTO();
				pd.setEngineerid( rs.getInt(1) );
				
				lst.add( pd);
				
			}
			
			PreparedStatement preps1 = con.prepareStatement("SELECT EngineerAssigned , count( EngineerAssigned ) from problems group by EngineerAssigned");
			
			ResultSet rs1 = preps1.executeQuery();
			
			while( rs1.next() ) {
				
				int engineerAssigned = rs1.getInt(1);
				int count = rs1.getInt(2);
				
				for(ProblemDTO pd:lst) {
					
					if( pd.getEngineerid() == engineerAssigned ){
						pd.setCount(count);
						break;
					}
				}
				
			}
			int min = Integer.MAX_VALUE;
			int engineerid = -1;
			
			for(ProblemDTO i:lst) {
				if(i.getCount()<=min) {
					
					min = i.getCount();
					engineerid = i.getEngineerid();
							
				}
			}
			
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO problems(description,EngineerAssigned,raisedby,raisedDate,status) values(?,?,?,CURDATE() ,0 )");
			
			ps.setString( 1 , PDTO.getDescription() );
			ps.setInt( 2 , engineerid );
			ps.setInt( 3 , PDTO.getEmployeeid() );
			
			if(ps.executeUpdate()==1) {
				return true;
			}
			else {
				throw new ExecutionException("Cannot register complain for now");
			}
			
		}catch(SQLException sqle){
			throw new ExecutionException( sqle.getMessage() );
		}
		
	}

	@Override
	public ProblemDTO seeStatus(int complaintId,Employee x) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection() ){
			PreparedStatement ps = con.prepareStatement("select p.problemid, p.description, p.status, p.raisedDate, e.engineerid, e.username, em.employeeid,em.username From problems p Inner Join engineer e INNER JOIN employee em ON p.problemid=? AND p.EngineerAssigned=e.engineerid And p.raisedby = em.employeeid;");
			ps.setInt(1,complaintId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
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
				
				return pdto;
			}
			else {
				throw new ExecutionException("No complain done with this id");
			}
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		
	}

	@Override
	public List<ProblemDTO> seeComplainHistory(Employee e)throws ExecutionException{
		
		List<ProblemDTO> ret = null;
		
		try(Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("select p.problemid, p.description, p.status, p.raisedDate, e.engineerid, e.username, em.employeeid,em.username From problems p Inner Join engineer e INNER JOIN employee em ON p.raisedby=? AND p.status=1 AND p.EngineerAssigned=e.engineerid And p.raisedby = em.employeeid ;");
			
			ps.setInt(1, e.getEmployeeid() );
			
			ResultSet rs = ps.executeQuery();
			ret = new ArrayList<>();
			
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
				
				ret.add(pdto);
				
			}
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		return ret;
	}

	@Override
	public boolean changePassword(Employee e) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection( )){
			
			PreparedStatement ps = con.prepareStatement("update employee set password=? where employeeid=?");
			
			ps.setString(1, e.getPassword() );
			ps.setInt(2, e.getEmployeeid());
			
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
