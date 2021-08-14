package com.rocket.domain;
import javax.swing.JOptionPane;

public class Propulsores {
	int potenciaMaxima;
	
	public Propulsores(int p) {
		this.potenciaMaxima=p;
	}
	public Propulsores() {
		this.potenciaMaxima= Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce potencia"));
	}
}
