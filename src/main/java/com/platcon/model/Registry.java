package com.platcon.model;

import java.time.LocalDate;
import java.util.UUID;

import com.platcon.model.enumerators.EnumOrigemAcesso;
import com.platcon.model.enumerators.EnumTipoAparelho;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registry")
public class Registry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String navegador;
	private LocalDate horarioAcesso;
	private Integer idade;
	private EnumTipoAparelho tipoAparelho;
	private EnumOrigemAcesso origemAcesso;

	public Registry() {
		super();
	}

	public Registry(UUID id, String navegador, LocalDate horarioAcesso, Integer idade, EnumTipoAparelho tipoAparelho,
			EnumOrigemAcesso origemAcesso) {
		super();
		this.id = id;
		this.navegador = navegador;
		this.horarioAcesso = horarioAcesso;
		this.idade = idade;
		this.tipoAparelho = tipoAparelho;
		this.origemAcesso = origemAcesso;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNavegador() {
		return navegador;
	}

	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}

	public LocalDate getHorarioAcesso() {
		return horarioAcesso;
	}

	public void setHorarioAcesso(LocalDate horarioAcesso) {
		this.horarioAcesso = horarioAcesso;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public EnumTipoAparelho getTipoAparelho() {
		return tipoAparelho;
	}

	public void setTipoAparelho(EnumTipoAparelho tipoAparelho) {
		this.tipoAparelho = tipoAparelho;
	}

	public EnumOrigemAcesso getOrigemAcesso() {
		return origemAcesso;
	}

	public void setOrigemAcesso(EnumOrigemAcesso origemAcesso) {
		this.origemAcesso = origemAcesso;
	}
}
