package com.sys.bean;

import java.sql.Date;



public class ProblemDTO {
	
	private int problemid;
	private String description;
	private String raisedby;
	private Date raiseddate;
	private boolean status;
	private int engineerid;
	private int employeeid;
	private String engineerUsername;
	private String employeeUsername;
	
	
	
	@Override
	public String toString() {
		return "problemid=" + problemid + "\nDescription=" + description + ", raisedby=" + raisedby
				+ ", raiseddate=" + raiseddate + ", status=" + status + "\nengineerid=" + engineerid + ", employeeid="
				+ employeeid + ", engineerUsername=" + engineerUsername + ", employeeUsername=" + employeeUsername
				+ "";
	}
	
	public int getProblemid() {
		return problemid;
	}
	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRaisedby() {
		return raisedby;
	}
	public void setRaisedby(String raisedby) {
		this.raisedby = raisedby;
	}
	public Date getRaiseddate() {
		return this.raiseddate;
	}
	public void setRaiseddate(Date raiseddate) {
		this.raiseddate = raiseddate;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getEngineerid() {
		return engineerid;
	}
	public void setEngineerid(int engineerid) {
		this.engineerid = engineerid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEngineerUsername() {
		return engineerUsername;
	}
	public void setEngineerUsername(String engineerUsername) {
		this.engineerUsername = engineerUsername;
	}
	public String getEmployeeUsername() {
		return employeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}
	
	
	
}
