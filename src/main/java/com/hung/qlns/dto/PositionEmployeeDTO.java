package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionEmployeeDTO {
	
	@JsonProperty("em_id")
	private Long emId;
	@JsonProperty("pos_id")
	private Long posId;
	public Long getEmId() {
		return emId;
	}
	public void setEmId(Long emId) {
		this.emId = emId;
	}
	public Long getPosId() {
		return posId;
	}
	public void setPosId(Long posId) {
		this.posId = posId;
	}
	public PositionEmployeeDTO(Long emId, Long posId) {
		super();
		this.emId = emId;
		this.posId = posId;
	}
	
	public PositionEmployeeDTO() {
		
	}

}
