package com.platcon.model.dto;

import com.platcon.model.enumerators.EnumOrigemAcesso;

public class DataOriginSourceDTO {

	private EnumOrigemAcesso type;
	private Integer value;
	
	public DataOriginSourceDTO(EnumOrigemAcesso type, Integer value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	public EnumOrigemAcesso getType() {
		return type;
	}
	public void setType(EnumOrigemAcesso type) {
		this.type = type;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
