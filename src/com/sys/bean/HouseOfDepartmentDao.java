package com.sys.bean;

public class HouseOfDepartmentDao {

	private String userName;
	private String password;
	
	public HouseOfDepartmentDao( ) {};
	public HouseOfDepartmentDao( String userName ,String password ){
		
		this.userName= userName;
		this.password= password;
		
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
