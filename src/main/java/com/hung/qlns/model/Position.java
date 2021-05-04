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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pos_id")
	private Long posId;
	@Column(name = "pos_name")
	@JsonProperty("pos_name")
	private String posName;
	@Column(name = "pos_code")
	@JsonProperty("pos_code")
	private String posCode;
	@Column(name = "pos_desc")
	@JsonProperty("pos_desc")
	private String posDesc;
	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<PositionEmployee> posEmpList;
	
	public Long getPosId() {
		return posId;
	}

	public void setPosId(Long posId) {
		this.posId = posId;
	}

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

	public List<PositionEmployee> getPosEmpList() {
		return posEmpList;
	}

	public void setPosEmpList(List<PositionEmployee> posEmpList) {
		this.posEmpList = posEmpList;
	}

	public Position(Long posId, String posName, String posCode, String posDesc, List<PositionEmployee> posEmpList) {
		super();
		this.posId = posId;
		this.posName = posName;
		this.posCode = posCode;
		this.posDesc = posDesc;
		this.posEmpList = posEmpList;
	}

	public Position() {
		
	}
	
}
