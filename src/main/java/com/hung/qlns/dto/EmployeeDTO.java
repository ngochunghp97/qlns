package com.hung.qlns.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {
	@JsonProperty("name")
	private String name;
	@JsonProperty("birthday")
	private Date birthDay;
	@JsonProperty("address")
	private String address;
	@JsonProperty("start_date")
	private Date startDate;
	@JsonProperty("end_date")
	private Date endDate;
	@JsonProperty("experience")
	private String experience;
	@JsonProperty("language")
	private String language;
	@JsonProperty("computer")
	private String computer;
	@JsonProperty("major")
	private String major;
	@JsonProperty("gender")
	private int gender;
	
	

}
