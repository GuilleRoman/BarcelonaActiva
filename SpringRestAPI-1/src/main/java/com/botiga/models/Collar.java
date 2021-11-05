package com.botiga.models;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="collares")
public class Collar {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	private String author;
	private double price;
	private Date arrival;
	@ManyToOne
	@JoinColumn(name="tienda_id")
	private Tienda tienda;

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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	@JsonBackReference
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public Collar(int id, String name, String author, double price, Date arrival, Tienda tienda) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.arrival = arrival;
		this.tienda = tienda;
	}
	public Collar() {}
	public Collar(String string, String string2, double double1, Date date) {
		// Creado para la BBDD JDBC
		this.name= string;
		this.author= string2;
		this.price= double1;
		this.arrival=date;
	}
	public Collar(int int1, String string, String string2, double double1, Date date) {
		// Creado para la BBDD JDBC
		this.id=int1;
		this.name=string;
		this.author=string2;
		this.price=double1;
		this.arrival=date;
	}
}