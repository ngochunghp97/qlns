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
@Table(name = "position_employee")
public class PositionEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "pos_id")
	@JsonIgnoreProperties("posEmpList")
	private Position position;
	@ManyToOne
	@JoinColumn(name = "em_id")
	@JsonIgnoreProperties("empDeList")
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PositionEmployee(Long id, Position position, Employee employee) {
		super();
		this.id = id;
		this.position = position;
		this.employee = employee;
	}

	public PositionEmployee() {
		
	}
	
}
