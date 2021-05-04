package com.hung.qlns.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="de_id")
	private Long deId;
	@Column(name="de_name")
	private String deName;
	@Column(name="de_code")
	private String deCode;
	@Column(name="de_desc")
	private String deDesc;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("department")
	private List<EmployeeDepartment> empDeList;
	public Long getDeId() {
		return deId;
	}
	public void setDeId(Long deId) {
		this.deId = deId;
	}
	public String getDeName() {
		return deName;
	}
	public void setDeName(String deName) {
		this.deName = deName;
	}
	public String getDeCode() {
		return deCode;
	}
	public void setDeCode(String deCode) {
		this.deCode = deCode;
	}
	public String getDeDesc() {
		return deDesc;
	}
	public void setDeDesc(String deDesc) {
		this.deDesc = deDesc;
	}
	public List<EmployeeDepartment> getEmpDeList() {
		return empDeList;
	}
	public void setEmpDeList(List<EmployeeDepartment> empDeList) {
		this.empDeList = empDeList;
	}
	public Department(Long deId, String deName, String deCode, String deDesc, List<EmployeeDepartment> empDeList) {
		super();
		this.deId = deId;
		this.deName = deName;
		this.deCode = deCode;
		this.deDesc = deDesc;
		this.empDeList = empDeList;
	}
	public Department() {
		
	}

}
