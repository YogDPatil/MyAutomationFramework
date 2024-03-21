package com.api.pojo;

public final class LoginApiPojo {

	private String username;
	private String password;
	
	public LoginApiPojo(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginApiPojo [username=" + username + ", password=" + password + "]";
	}
}
