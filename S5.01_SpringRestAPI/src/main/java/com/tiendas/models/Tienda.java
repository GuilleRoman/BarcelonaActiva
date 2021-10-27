package com.tiendas.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Tienda")
public class Tienda {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
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
}