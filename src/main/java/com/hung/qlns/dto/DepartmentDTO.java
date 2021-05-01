package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentDTO {
	@JsonProperty("de_name")
	private String deName;
	@JsonProperty("de_code")
	private String deCode;
	@JsonProperty("de_desc")
	private String deDesc;
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
	public DepartmentDTO(String deName, String deCode, String deDesc) {
		super();
		this.deName = deName;
		this.deCode = deCode;
		this.deDesc = deDesc;
	}
	public DepartmentDTO() {
		
	}
	

}
