package com.sys.bean;

public class Employee {
	
	private int employeeid;
	private String username;
	private String password;
	
	
	
	public int getEmployeeid() {
		return employeeid;
	}



	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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



	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", username=" + username + "]";
	}
	
	
	
}
