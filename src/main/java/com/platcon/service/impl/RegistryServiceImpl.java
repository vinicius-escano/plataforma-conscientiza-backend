package com.platcon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platcon.model.Registry;
import com.platcon.model.dto.DataAgeDTO;
import com.platcon.model.dto.DataDTO;
import com.platcon.model.dto.DataOriginSourceDTO;
import com.platcon.model.enumerators.EnumOrigemAcesso;
import com.platcon.repository.RegistryRepository;

@Service
public class RegistryServiceImpl {

	@Autowired
	private RegistryRepository registryRepository;
	
	public DataDTO findAll() {
		var registries = registryRepository.findAll();
		var dataDto = new DataDTO(getOriginSource(registries), getAgeData(registries));
		return dataDto;
	}
	
	private List<DataOriginSourceDTO> getOriginSource(List<Registry> registries) {
		AtomicInteger totalDesktop = new AtomicInteger(0);
		AtomicInteger totalMobile = new AtomicInteger(0);
		AtomicInteger totalQR = new AtomicInteger(0);
		registries.stream().forEach(r ->{
			if(r.getOrigemAcesso().equals(EnumOrigemAcesso.DESKTOP_EMAIL) || r.getOrigemAcesso().equals(EnumOrigemAcesso.DESKTOP_MESSAGE)) {
				totalDesktop.getAndAdd(1);
			} else if (r.getOrigemAcesso().equals(EnumOrigemAcesso.MOBILE_MESSAGE)) {
				totalMobile.getAndAdd(1);
			} else {
				totalQR.getAndAdd(1);
			}
		});
		
		List<DataOriginSourceDTO> dataOrigin = new ArrayList<>();
		dataOrigin.add(new DataOriginSourceDTO(EnumOrigemAcesso.DESKTOP_EMAIL, totalDesktop.get()));
		dataOrigin.add(new DataOriginSourceDTO(EnumOrigemAcesso.MOBILE_MESSAGE, totalMobile.get()));
		dataOrigin.add(new DataOriginSourceDTO(EnumOrigemAcesso.MOBILE_QRCODE, totalQR.get()));
		return dataOrigin;
	}
	
	private List<DataAgeDTO> getAgeData(List<Registry> registries) {
		AtomicInteger minus18 = new AtomicInteger(0);
		AtomicInteger between19and30 = new AtomicInteger(0);
		AtomicInteger between31and50 = new AtomicInteger(0);
		AtomicInteger plus51 = new AtomicInteger(0);

		registries.stream().forEach(r ->{
			if(r.getIdade() < 18) {
				minus18.getAndAdd(1);
			} else if (r.getIdade() > 18 && r.getIdade() <= 30) {
				between19and30.getAndAdd(1);
			} else if (r.getIdade() > 31 && r.getIdade() <= 50){
				between31and50.getAndAdd(1);
			} else {
				plus51.getAndAdd(1);
			}
		});
		
		List<DataAgeDTO> dataAge = new ArrayList<>();
		dataAge.add(new DataAgeDTO(1, minus18.get()));
		dataAge.add(new DataAgeDTO(2, between19and30.get()));
		dataAge.add(new DataAgeDTO(3, between31and50.get()));
		dataAge.add(new DataAgeDTO(4, plus51.get()));
		return dataAge;
	}
}
