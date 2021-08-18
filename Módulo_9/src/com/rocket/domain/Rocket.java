package com.rocket.domain;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Rocket extends Thread{
	private String codigo;
	private int numPropulsores;
	private ArrayList<Propulsores> propulsores;
	private int velocidadInicial;
	private int pt=0;
	private int velocidadActual;
	private int velocidad;
	
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
		this.velocidadInicial= 0;
		this.velocidadActual= this.velocidadInicial;
		for(int i=0; i<n;i++) {
			Propulsores propulsor= new Propulsores();
			
			this.propulsores.add(propulsor);
			this.propulsores.get(i).setOrdenCreado(i+1);
			
		for(Propulsores e:this.propulsores) {
			pt= pt+e.getPotenciaMaxima();
			
		}
		int potenciaRepartir;
		int potenciaRestante=pt;
		this.velocidad= (int) (velocidadInicial+100+Math.sqrt(this.pt));
		for(Propulsores e:this.propulsores) {
			
			potenciaRepartir= e.getPotenciaMaxima()/this.numPropulsores;
			potenciaRestante=potenciaRestante-potenciaRepartir;
			if(potenciaRestante==0) {
				e.setPotenciaObjetivo(0);
				System.out.println("La potencia se ha asignado a los propulsores en su totalidad.");
				
			}else {
				e.setPotenciaObjetivo(potenciaRepartir);
			}
			
			
			
			
		}
		
		}
	}
	//int propulsoresListos=0;
	public void run() {
		
		while(!(this.velocidadActual==this.velocidad)) {
			
				try {
					Thread.sleep(1000);	
			for(Propulsores e:this.getPropulsores()) {
				if(!(e.getPotenciaActual()==e.getPotenciaObjetivo())) {
					this.generarPotencia(e);
				}
				else {
//					propulsoresListos++;
//					System.out.println("Propulsores listos: "+this.propulsoresListos);
//					if(propulsoresListos==this.numPropulsores){
						if(this.pt<this.velocidad) {
							System.out.println("No hay potencia suficiente para alcanzar la velocidad estimada");
							
							break;
						}else {
							while(!(this.velocidadActual==this.velocidad)) {
								if((this.velocidad-this.velocidadActual)<=10) {
									Thread.sleep(1000);
									this.velocidadActual++;
									System.out.println("---------------\nAcelerando Rocket: "+this.codigo+"\nVelocidad actual: "
									+this.velocidadActual+"\nVelocidad objetivo: "+this.velocidad+"\n---------------");
								}else {
									Thread.sleep(1000);
									System.out.println("---------------\nAcelerando Rocket: "+this.codigo+"\nVelocidad actual: "
									+this.velocidadActual+"\nVelocidad objetivo: "+this.velocidad+"\n---------------");
									this.velocidadActual+=10;
								}
						}
					}
				} 
				 
					
			}
				
		}
				
		catch (InterruptedException e1) {
			Thread.currentThread().interrupt();
			e1.printStackTrace();
		}			
		}
			System.out.println("Se ha alcanzado la velocidad objetivo del Rocket: "+this.codigo);
	}
		

	
	public void acelerar() {
		
		this.start();
			
		
		
	}
	public void frenar() {
		this.interrupt();
	}
	public void generarPotencia(Propulsores e) {
	
					
					if(e.getPotenciaActual()<e.getPotenciaObjetivo()) {
						
						e.setPotenciaActual(e.getPotenciaActual()+1);
						System.out.println(this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia actual: "+e.getPotenciaActual()+" Potencia objetivo: "
								+ e.getPotenciaObjetivo()+" Potencia máxima: "+e.getPotenciaMaxima());
					}
					else if(e.getPotenciaActual()>e.getPotenciaObjetivo()) {
						e.setPotenciaActual(e.getPotenciaActual()-1);
					}else {
						System.out.println(this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia alcanzada");
						
//						e.setPotenciaObjetivo(Integer.parseInt(JOptionPane.showInputDialog("Introduce nueva P.O. para el Propulsor nº: "
//						+e.getOrdenCreado()+ "con Potencia máxima: "+e.getPotenciaMaxima())));
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						//this.frenar();
					}
	}
	
}
