package com.sys.bean;

public class Engineer {

	private int engineerID;
	private String username;
	private String password;
	
	
	@Override
	public String toString() {
		return "Enginner [engineerID=" + engineerID  + ", username=" + username + " ]";
	}
	
	public int getEngineerID() {
		return engineerID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String s) {
		
	}

	public void setEngineerID(int engineerID) {
		this.engineerID = engineerID;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}
