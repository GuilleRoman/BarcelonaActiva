package com.rocket.domain;
import java.util.ArrayList;

public class Rocket {
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
		return propulsores;
	}
	public void setPropulsores(ArrayList<Propulsores> propulsores) {
		this.propulsores = propulsores;
	}
	
	public Rocket(String c, int n) throws Exception {
		this.codigo= c;
		if(c.length()<8 || c.length()>8)
			throw new Exception();
		this.numPropulsores=n;
		this.propulsores= new ArrayList<Propulsores>();
		for(int i=0; i<=n;i++) {
			Propulsores propulsor= new Propulsores();
			this.propulsores.add(propulsor);
		}
	}
	
}
