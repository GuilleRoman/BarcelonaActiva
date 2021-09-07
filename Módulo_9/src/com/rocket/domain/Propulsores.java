package com.rocket.domain;
import javax.swing.JOptionPane;

public class Propulsores extends Thread{
	private int potenciaMaxima;
	private int potenciaActual;
	private int potenciaObjetivo;
	private int ordenCreado;
	private boolean listo= false;
	private Rocket rocket;
	
	
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
	
	
	public void setListo(boolean t) {
		this.listo=t;
	}
	public boolean getListo() {
		return listo;
	}
	public void setRocket(Rocket r) {
		this.rocket=r;
	}
	
	public Propulsores(int p) {
		this.potenciaMaxima=p;
		this.potenciaActual=0;
	}
	public Propulsores() {
		this.potenciaMaxima= Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce potencia máxima"));
//		this.potenciaObjetivo= Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce potencia objetivo"));
		this.potenciaActual=0;
		
	}
	
public void run() {
	this.rocket.getLamina().cuadroInfo.append("\nInicio del Thread del propulsor"+ getOrdenCreado()
	+ "del Rocket: "+this.rocket.getCodigo()+" "+ Thread.currentThread().getName());
		while(this.listo!=true) {
			try {
				Thread.sleep(1000);
				if(this.potenciaActual < this.potenciaObjetivo) {
					this.rocket.getLamina().cuadroInfo.append("\n"+this.rocket.getCodigo()+": "+"Propulsor nº: "+getOrdenCreado()+" Potencia actual: "
							+getPotenciaActual()+" Potencia objetivo: "
									+ getPotenciaObjetivo()+" Potencia máxima: "+getPotenciaMaxima());
					potenciaActual++;
				}else if(this.potenciaActual > this.potenciaObjetivo) {
					this.rocket.getLamina().cuadroInfo.append("\n"+this.rocket.getCodigo()+": "+"Propulsor nº: "+getOrdenCreado()+" Potencia actual: "
							+getPotenciaActual()+" Potencia objetivo: "
									+ getPotenciaObjetivo()+" Potencia máxima: "+getPotenciaMaxima());
					potenciaActual--;
				}else {
					this.rocket.getLamina().cuadroInfo.append("\nPropulsor " + getOrdenCreado()+" listo");
					this.rocket.setListos();
					this.setListo(true);
				}
				//this.rocket.generarPotencia(this);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		this.rocket.getLamina().cuadroInfo.append("\nFin del Thread del propulsor "+ getOrdenCreado()
		+ "del Rocket: "+this.rocket.getCodigo()+" "+ Thread.currentThread().getName());
	}
}