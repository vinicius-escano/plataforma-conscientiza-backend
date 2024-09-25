package com.platcon.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platcon.model.Registry;

public interface RegistryRepository extends JpaRepository<Registry, UUID> {

}
