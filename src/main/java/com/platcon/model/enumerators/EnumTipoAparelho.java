package com.platcon.model.enumerators;

public enum EnumTipoAparelho {

	DESKTOP("DESKTOP"), MOBILE("MOBILE");

	private final String tipo;

	EnumTipoAparelho(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
