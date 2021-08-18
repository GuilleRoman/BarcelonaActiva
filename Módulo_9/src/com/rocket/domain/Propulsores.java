package com.rocket.domain;
import javax.swing.JOptionPane;

public class Propulsores  {
	public int getPotenciaMaxima() {
		return potenciaMaxima;
	}
	public void setPotenciaMaxima(int potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}
	public int getPotenciaActual() {
		return potenciaActual;
	}
	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual = potenciaActual;
	}
	public int getPotenciaObjetivo() {
		return potenciaObjetivo;
	}
	public void setPotenciaObjetivo(int potenciaObjetivo) {
		this.potenciaObjetivo = potenciaObjetivo;
	}
	public int getOrdenCreado() {
		return ordenCreado;
	}
	public void setOrdenCreado(int ordenCreado) {
		this.ordenCreado = ordenCreado;
	}
	private int potenciaMaxima;
	private int potenciaActual;
	private int potenciaObjetivo;
	private int ordenCreado;
	public Propulsores(int p) {
		this.potenciaMaxima=p;
	}
	public Propulsores() {
		this.potenciaMaxima= Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce potencia máxima"));
//		this.potenciaObjetivo= Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce potencia objetivo"));
		this.potenciaActual=0;
		
	}
	
	
	
}