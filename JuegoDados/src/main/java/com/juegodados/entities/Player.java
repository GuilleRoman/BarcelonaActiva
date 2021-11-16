package com.juegodados.entities;

import java.util.Date;

import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.juegodados.documents.Game;
import com.juegodados.models.GameModel;

@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private Date registerDate;
	
	@Column(columnDefinition = "varchar(255) default 'ANONIMO'")
	private String name;
	

	private double winRate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
	public Player() {
		super();
	}
	public Player(int id, Date registerDate, String name,  double winRate) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.name = name;
		this.winRate = winRate;
	}
	@Override
	public String toString() {
		return "Player [id=" + id + ", registerDate=" + registerDate + ", name=" + name + ", winRate=" + winRate + "]";
	}

	public int rollDice() {
		Random r = new Random();
		int low = 1;
		int high = 6;
		int result = r.nextInt(high-low+1) + low;
		return result;
	}
	public void rollDices(Game game) {
		
		 
		int result=0;
		int sum=0;
		for(int i = 0 ; i <2; i++) {
			
			result= this.rollDice();
			sum=sum+result;
			if(i==0) {
			game.setResultDice1(result);	
			}else {
				game.setResultDice2(result);
			}
			
			
		}
		game.setResult(sum);
		if(sum==7) {
			game.setWinner(this.getName());
		}else {
			game.setLoser(this.getName());
		}
		

	}
	
	
}
