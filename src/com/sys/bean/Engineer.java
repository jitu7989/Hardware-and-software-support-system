package com.sys.bean;

public class Engineer {

	private int engineerID=-1;
	private String username;
	private String password;
	
	
	@Override
	public String toString() {
		return "Enginner [engineerID=" + engineerID  + ", username=" + username + " ]";
	}


	public int getEngineerID() {
		return engineerID;
	}


	public void setEngineerID(int engineerID) {
		this.engineerID = engineerID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
