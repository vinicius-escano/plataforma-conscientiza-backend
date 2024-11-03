package com.platcon.model.dto;

public class DataAgeDTO {

	private Integer interval;
	private Integer value;

	public DataAgeDTO(Integer interval, Integer value) {
		super();
		this.interval = interval;
		this.value = value;
	}
	
	public Integer getInterval() {
		return interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
