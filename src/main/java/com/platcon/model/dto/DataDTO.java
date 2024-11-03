package com.platcon.model.dto;

import java.util.List;

public class DataDTO {

	private List<DataOriginSourceDTO> dataOriginSource;
	private List<DataAgeDTO> dataAge;

	public DataDTO(List<DataOriginSourceDTO> dataOriginSource, List<DataAgeDTO> dataAge) {
		super();
		this.dataOriginSource = dataOriginSource;
		this.dataAge = dataAge;
	}

	public List<DataOriginSourceDTO> getDataOriginSource() {
		return dataOriginSource;
	}

	public void setDataOriginSource(List<DataOriginSourceDTO> dataOriginSource) {
		this.dataOriginSource = dataOriginSource;
	}

	public List<DataAgeDTO> getDataAge() {
		return dataAge;
	}

	public void setDataAge(List<DataAgeDTO> dataAge) {
		this.dataAge = dataAge;
	}

}
