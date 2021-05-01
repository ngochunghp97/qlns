package com.hung.qlns.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData<T> {
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("data")
	private T data;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResponseData(int statusCode, T data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}
	public ResponseData() {
		
	}
	
}
