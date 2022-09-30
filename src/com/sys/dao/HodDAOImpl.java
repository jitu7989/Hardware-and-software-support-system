package com.sys.dao;

import com.sys.util.ConnectionUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import com.sys.bean.*;
import com.sys.exceptions.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet ;
public class HodDAOImpl implements HodDAO {

	//This method will return boolean if registration is successfull
	public boolean registerEngineer(Engineer e) throws Exception {
		
//		if( ! this.authenthicate( o )) return false;
		
		try (Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO engineer(username,password) values( ?, ? )");
			
			ps.setString( 1 , e.getUsername() );
			ps.setString(2, e.getPassword());
			try {
				ps.executeUpdate();
			}
			catch(SQLException sqle) {
				throw new ExecutionException(sqle.getMessage());
			}
			
		} catch (SQLException sqle) {
			throw new AuthenthicationException(sqle.getMessage());
		}
		
		return false;
	}

	@Override
	public List<Engineer> getEnginners( ) throws ExecutionException{
		
		List<Engineer> ls = null;
		
		
		try ( Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ENGINEER");
			
			ResultSet rs = ps.executeQuery();
			
			ls = new ArrayList<>();
			
			while(rs.next()) {
				
				int id = rs.getInt("engineerid");
				String username = rs.getString("username");
				
				Engineer eng = new Engineer();
				
				eng.setUsername(username);
				eng.setEngineerID(id);
				
				ls.add(eng);
				
			}
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		
		return ls;
	}

	public String kickEngineer(Engineer e) throws ExecutionException{
		
		String res = null;
		try ( Connection con = ConnectionUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("delete from engineer where engineerid=?");
			
			ps.setInt(1, e.getEngineerID());
			
			if(ps.execute()) {
				
				res = "Engineer has been removed";
			}
			else {
				res = "Failed to remove Engineer please enter correct ID";
			}
			
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		return res;
	}
	
	public List<ProblemDTO> getRaisedProblem() throws ExecutionException{
		List<ProblemDTO> ret = null;
		
		try(Connection con = ConnectionUtil.provideConnection() ){
			PreparedStatement ps = con.prepareStatement("select p.problemid, p.description, p.status, p.raisedDate, e.engineerid, e.username, em.employeeid,em.username From problems p Inner Join engineer e INNER JOIN employee em ON  p.EngineerAssigned=e.engineerid And p.raisedby = em.employeeid AND p.status=0");
			
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
	public boolean assignProblem(int problemid,int engineerid) throws ExecutionException{
		
		try(Connection con = ConnectionUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("update  problems set engineerAssigned=? where problemid=?");
			
			ps.setInt(1, problemid);
			ps.setInt(2,engineerid);
			
			if(!ps.execute()) throw new ExecutionException("Failed to set engineer");
			
		}
		catch(SQLException sqle) {
			throw new ExecutionException(sqle.getMessage());
		}
		
		return true;
	}

	
	
}
