package com.juegomongo.documents;

import java.util.Date;
import java.util.Random;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="players")
public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	
	@Indexed(unique=true)
	private String name;
	private double winRate;
	@CreationTimestamp
	private Date registerDate ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public Player() {
		super();
	}
	public Player(String id, String name, double winRate, Date registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.winRate = winRate;
		this.registerDate = registerDate;
	}
	
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", winRate=" + winRate + ", registerDate=" + registerDate + "]";
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
