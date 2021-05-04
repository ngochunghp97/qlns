package com.hung.qlns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employee_department")
public class EmployeeDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@ManyToOne
	@JoinColumn(name="em_id")
	@JsonIgnoreProperties("empDeList")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name="de_id")
	@JsonIgnoreProperties("empDeList")
	private Department department;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	

	public EmployeeDepartment(Long id, Employee employee, Department department) {
		super();
		this.id = id;
		this.employee = employee;
		this.department = department;
	}


	public EmployeeDepartment() {
		
	}

}
