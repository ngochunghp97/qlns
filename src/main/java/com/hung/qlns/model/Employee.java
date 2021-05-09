package com.hung.qlns.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="em_id")
	@JsonProperty("em_id")
	private Long emId;
	@Column(name ="name")
	private String name;
	@Column(name="birthday")
	private Date birthDay;
	@Column(name="address")
	private String address;
	@Column(name="start_date")
	@JsonProperty("start_date")
	private Date startDate;
	@Column(name="end_date")
	@JsonProperty("end_date")
	private Date endDate;
	@Column(name="experience")
	private String experience;
	@Column(name = "language")
	private String language;
	@Column(name="computer")
	private String computer;
	@Column(name ="major")
	private String major;
	@Column(name="gender")
	private int gender;
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<PositionEmployee> posEmList;
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<EmployeeDepartment> empDeList;
	public Long getEmId() {
		return emId;
	}
	public void setEmId(Long emId) {
		this.emId = emId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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
	public List<PositionEmployee> getPosEmList() {
		return posEmList;
	}
	public void setPosEmpList(List<PositionEmployee> posEmList) {
		this.posEmList = posEmList;
	}
	public List<EmployeeDepartment> getEmpDeList() {
		return empDeList;
	}
	public void setEmpDeList(List<EmployeeDepartment> empDeList) {
		this.empDeList = empDeList;
	}
	public Employee(Long emId, String name, Date birthDay, String address, Date startDate, Date endDate, String experience,
			String language, String computer, String major, int gender, List<PositionEmployee> posEmList,
			List<EmployeeDepartment> empDeList) {
		super();
		this.emId = emId;
		this.name = name;
		this.birthDay = birthDay;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.experience = experience;
		this.language = language;
		this.computer = computer;
		this.major = major;
		this.gender = gender;
		this.posEmList = posEmList;
		this.empDeList = empDeList;
	}
	public Employee() {
		
	}
	
}
