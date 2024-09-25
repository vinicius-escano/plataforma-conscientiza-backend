package com.platcon.model.enumerators;

public enum EnumOrigemAcesso {
	DESKTOP_MESSAGE("DESKTOP_MESSAGE"), DESKTOP_EMAIL("DESKTOP_EMAIL"), MOBILE_MESSAGE("MOBILE_MESSAGE"),
	MOBILE_QRCODE("MOBILE_QRCODE");

	private final String origem;

	EnumOrigemAcesso(String origem) {
		this.origem = origem;
	}

	public String getorigem() {
		return origem;
	}
}
