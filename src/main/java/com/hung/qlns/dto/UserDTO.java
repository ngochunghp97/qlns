package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	@JsonProperty("username")
	private String userName;
	@JsonProperty("password")
	private String passWord;
}
