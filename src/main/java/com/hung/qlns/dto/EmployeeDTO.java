package com.hung.qlns.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("birthday")
	private Date birthday;
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
	@JsonProperty("pos_code")
	private String posCode;
	@JsonProperty("de_code")
	private String deCode;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPosCode() {
		return posCode;
	}

	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	public String getDeCode() {
		return deCode;
	}

	public void setDeCode(String deCode) {
		this.deCode = deCode;
	}
	
	public EmployeeDTO(String name, Date birthday, String address, Date startDate, Date endDate, String experience,
			String language, String computer, String major, int gender, String posCode, String deCode) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.experience = experience;
		this.language = language;
		this.computer = computer;
		this.major = major;
		this.gender = gender;
		this.posCode = posCode;
		this.deCode = deCode;
	}

	public EmployeeDTO() {
		
	}
	

}
