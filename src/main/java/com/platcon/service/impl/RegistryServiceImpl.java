package com.platcon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platcon.repository.RegistryRepository;

@Service
public class RegistryServiceImpl {

	@Autowired
	private RegistryRepository registryRepository;
	
	

}
