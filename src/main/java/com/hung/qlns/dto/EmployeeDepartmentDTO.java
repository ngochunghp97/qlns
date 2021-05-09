package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDepartmentDTO {
	
	@JsonProperty("em_id")
	private Long emId;
	@JsonProperty("de_id")
	private Long deId;
	public Long getEmId() {
		return emId;
	}
	public void setEmId(Long emId) {
		this.emId = emId;
	}
	public Long getDeId() {
		return deId;
	}
	public void setDeId(Long deId) {
		this.deId = deId;
	}
	public EmployeeDepartmentDTO(Long emId, Long deId) {
		super();
		this.emId = emId;
		this.deId = deId;
	}
	public EmployeeDepartmentDTO() {
		
	}
	
}
