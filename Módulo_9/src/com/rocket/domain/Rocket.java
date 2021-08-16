package com.rocket.domain;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Rocket extends Thread{
	private String codigo;
	private int numPropulsores;
	private ArrayList<Propulsores> propulsores;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getNumPropulsores() {
		return numPropulsores;
	}
	public void setNumPropulsores(int numPropulsores) {
		this.numPropulsores = numPropulsores;
	}
	public ArrayList<Propulsores> getPropulsores() {
		return this.propulsores;
	}
	public String getPropulsoresInfo() {
		String propulsoresInfo="";
		for (Propulsores p:propulsores) {
			propulsoresInfo=propulsoresInfo+ " "+ p.getPotenciaMaxima();
		}
		
		return "["+propulsoresInfo+"]";
	}
	public void setPropulsores(ArrayList<Propulsores> propulsores) {
		this.propulsores = propulsores;
	}
	
	public Rocket(String c, int n) throws Exception {
		this.propulsores= new ArrayList<Propulsores>();
		this.codigo= c;
		if(c.length()<8 || c.length()>8)
			throw new Exception();
		this.numPropulsores=n;
		
		for(int i=0; i<n;i++) {
			Propulsores propulsor= new Propulsores();
			
			this.propulsores.add(propulsor);
			this.propulsores.get(i).setOrdenCreado(i);
		}
	}
	public void run() {
		
		while(true) {
			
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e1) {
			
					e1.printStackTrace();
				}
			for(Propulsores e:this.getPropulsores()) {
				
				System.out.println(this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia actual: "+e.getPotenciaActual()+" Potencia objetivo: "
			+ e.getPotenciaObjetivo()+" Potencia máxima: "+e.getPotenciaMaxima());
				
				if(e.getPotenciaActual()<e.getPotenciaObjetivo()) {
					
					e.setPotenciaActual(e.getPotenciaActual()+1);
				}
				else if(e.getPotenciaActual()>e.getPotenciaObjetivo()) {
					e.setPotenciaActual(e.getPotenciaActual()-1);
				}else {
					
					e.setPotenciaObjetivo(Integer.parseInt(JOptionPane.showInputDialog("Introduce nueva P.O. para el Propulsor nº: "
					+e.getOrdenCreado()+ "con Potencia máxima: "+e.getPotenciaMaxima())));
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//this.frenar();
				}
			}
				
					
		}
	}
		

	
	public void acelerar() {
		
		this.start();
			
		
		
	}
	public void frenar() {
		this.interrupt();
	}
	
}
