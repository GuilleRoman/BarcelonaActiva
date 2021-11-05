package com.botiga.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tiendas")
public class Tienda {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="capacidad_maxima")
	private int capacidadMaxima;
	@OneToMany(mappedBy="tienda")
	private List<Collar> collares;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	@JsonIgnore
	public List<Collar> getCollares() {
		return collares;
	}

	public void setCollares(List<Collar> collares) {
		this.collares = collares;
	}

	public Tienda(int id, String name, int capacidadMaxima, List<Collar> collares) {
		super();
		this.id = id;
		this.name = name;
		this.capacidadMaxima = capacidadMaxima;
		this.collares = collares;
	}

	public Tienda() {
}

	public Tienda(String string, int int1) {
		// Creado para la BBDD JDBC
		this.name= string;
		this.capacidadMaxima= int1;
	}

	public Tienda(int int1, String string, int int2) {
		// Creado para la BBDD JDBC
		this.id= int1;
		this.name=string;
		this.capacidadMaxima=int2;
	}
}