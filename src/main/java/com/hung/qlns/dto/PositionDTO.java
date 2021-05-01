package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionDTO {
	@JsonProperty("pos_name")
	private String posName;
	@JsonProperty("pos_code")
	private String posCode;
	@JsonProperty("pos_desc")
	private String posDesc;
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getPosCode() {
		return posCode;
	}
	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}
	public String getPosDesc() {
		return posDesc;
	}
	public void setPosDesc(String posDesc) {
		this.posDesc = posDesc;
	}
	public PositionDTO(String posName, String posCode, String posDesc) {
		super();
		this.posName = posName;
		this.posCode = posCode;
		this.posDesc = posDesc;
	}
	public PositionDTO() {
		
	}
	

}
