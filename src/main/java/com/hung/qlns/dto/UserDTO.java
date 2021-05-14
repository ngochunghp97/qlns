package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	@JsonProperty("username")
	private String userName;
	@JsonProperty("password")
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public UserDTO(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public UserDTO() {
		
	}
}
