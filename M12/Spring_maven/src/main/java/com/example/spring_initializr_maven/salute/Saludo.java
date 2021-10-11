package com.example.spring_initializr_maven.salute;

public class Saludo {
	private String mensaje;
	
	public Saludo(String mensaje) {
		super();
		this.mensaje = mensaje;
		
	}
	public String getMensaje() {
		return mensaje;
	}

	
}