package com.rocket.domain;
 
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Rocket extends Thread{
	private String codigo;
	private int numPropulsores;
	private ArrayList<Propulsores> propulsores;
	private int velocidadInicial;
	private int pt=0;
	private int velocidadActual;
	private int velocidad;
	private boolean frenado= false;
	private Lamina lamina;
	private int propulsoresListos=0;
	private int velocidadAceleracion=15;
	public void setVelocidadAceleracion(int e) {
		velocidadAceleracion=e;
	}
	public int getPT() {
		return pt;
	}
	public void setLamina(Lamina r) {
		this.lamina=r;
	}
	public Lamina getLamina() {
		return this.lamina;
	}
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
	public void setVelocidad(int v) {
		this.velocidad=v;
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
	public int getListos() {
		return propulsoresListos;
	}
	public void setListos() {
		this.propulsoresListos++;
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
		int potenciaRepartir;
		int potenciaRestante=pt;
		this.velocidad= (int) (velocidadInicial+100+Math.sqrt(this.pt));
		for(int i=0; i<n;i++) {
			Propulsores propulsor= new Propulsores();
			
			this.propulsores.add(propulsor);
			this.propulsores.get(i).setOrdenCreado(i+1);
			
		for(Propulsores e:this.propulsores) {
			pt= pt+e.getPotenciaMaxima();
			
		}
		
		for(Propulsores e:this.propulsores) {
			
			e.setRocket(this);
			
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
	public void repartirPotenciaMaxima() {
		for(Propulsores e:this.propulsores) {
			pt= pt+e.getPotenciaMaxima();
			
		}
	}
	public void repartirPotenciaObjetivo() {
		for(Propulsores e:this.propulsores) {
			
			int potenciaRepartir= e.getPotenciaMaxima()/this.numPropulsores;
			int potenciaRestante=0;
			potenciaRestante=potenciaRestante-potenciaRepartir;
			if(potenciaRestante==0) {
				e.setPotenciaObjetivo(0);
				this.lamina.cuadroInfo.append("\nLa potencia se ha asignado a los propulsores en su totalidad.");
				
			}else {
				e.setPotenciaObjetivo(potenciaRepartir);
			}
			
			
			
			
		}
	}
	public void crearPropulsores() {
		for(int i=0; i<this.getNumPropulsores();i++) {
			Propulsores propulsor= new Propulsores();
			
			this.propulsores.add(propulsor);
			this.propulsores.get(i).setOrdenCreado(i+1);
		}
	}
	public Rocket() {
		
	}

	public void run() {
		this.lamina.cuadroInfo.append("\nInicio del Thread del Rocket "+ Thread.currentThread().getName());
		while(!(Thread.currentThread().isInterrupted())) {
			
				try {
					Thread.sleep(1000);	
			
					
				if(!(this.propulsoresListos==this.getNumPropulsores())) {

					
				}
				else {

						if(this.pt<this.velocidad) {
							
							this.lamina.cuadroInfo.append("\nNo hay potencia suficiente para alcanzar la velocidad estimada");
							this.interrupt();
							
						}else {
							
							while(!(this.velocidadActual==this.velocidad)) {
								if(frenado==true) {
									Thread.sleep(1000);
									this.velocidadActual--;
									
									
									this.lamina.cuadroInfo.append("\n"+"---------------\nAcelerando Rocket: "
											+this.codigo+"\nVelocidad actual: "
											+this.velocidadActual+"\nVelocidad objetivo: "
											+this.velocidad+"\n---------------");
								}
									
								else {
									Thread.sleep(1000);

									
									this.lamina.cuadroInfo.append("\n"+"---------------\nAcelerando Rocket: "
											+this.codigo+"\nVelocidad actual: "
											+this.velocidadActual+"\nVelocidad objetivo: "
											+this.velocidad+"\n---------------");
									
									this.velocidadActual+=this.velocidadAceleracion;
								}
						}
							
							this.lamina.cuadroInfo.append("\nSe ha alcanzado la velocidad objetivo del Rocket: "+this.codigo);
					}
				} 
				 
					
			
				
		}
				
		catch (InterruptedException e1) {
			Thread.currentThread().interrupt();
			//e1.printStackTrace();
		}			
		}

		this.lamina.cuadroInfo.append("Fin del Thread\n"+ Thread.currentThread().getName());	
	}
		

	
	public void acelerar() {
		this.getDatos();
		for(Propulsores e:this.getPropulsores()) {
			e.start();
				
			}
		this.start();
		
			
		
		
	}
	public void frenar() {
		if(this.frenado==false) {
		
			this.lamina.cuadroInfo.append("\nReduciendo velocidad...");
			this.frenado=true;
		}else {
		
			this.lamina.cuadroInfo.append("\nAumentando velocidad...");
			this.frenado=false;
		}
		
		
	}
	public void generarPotencia(Propulsores e) {
					
					
					if(e.getPotenciaActual()<e.getPotenciaObjetivo()) {
						
						e.setPotenciaActual(e.getPotenciaActual()+1);


						this.lamina.cuadroInfo.append("\n"+this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia actual: "
						+e.getPotenciaActual()+" Potencia objetivo: "
								+ e.getPotenciaObjetivo()+" Potencia máxima: "+e.getPotenciaMaxima());
					}
					else if(e.getPotenciaActual()>e.getPotenciaObjetivo()) {
						e.setPotenciaActual(e.getPotenciaActual()-1);

						this.lamina.cuadroInfo.append("\n"+this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia actual: "
								+e.getPotenciaActual()+" Potencia objetivo: "
										+ e.getPotenciaObjetivo()+" Potencia máxima: "+e.getPotenciaMaxima());
						
					}else {


						this.lamina.cuadroInfo.append("\n"+this.codigo+": "+"Propulsor nº: "+e.getOrdenCreado()+" Potencia alcanzada");
						e.setListo(true);
						
						

					}
	}
	public void getDatos() {
		
		this.lamina.cuadroInfo.append("\nRocket id: "+this.getCodigo()+ 
				"\nPotencia máxima: "+this.getPropulsoresInfo());
	}
	
}
