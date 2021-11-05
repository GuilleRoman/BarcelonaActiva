package com.JocDaus.models;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Date registerDate;
	@Column
	private String name;
	@OneToMany(mappedBy="players")
	private List<Dice> dices;
	private int currentRoll;
	private int previousRolls;
	@Column
	private HashMap<String, Integer> rolls;
	@Column
	private double winRate;
	
	private int rollCounter=0;
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
	public List<Dice> getDices() {
		return dices;
	}
	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}
	public int getCurrentRoll() {
		return currentRoll;
	}
	public void setCurrentRoll(int currentRoll) {
		this.currentRoll = currentRoll;
	}
	public int getPreviousRolls() {
		return previousRolls;
	}
	public void setPreviousRolls(int previousRolls) {
		this.previousRolls = previousRolls;
	}
	public HashMap<String, Integer> getRolls() {
		return rolls;
	}
	public void setRolls(HashMap<String, Integer> rolls) {
		this.rolls = rolls;
	}
	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
	
	public void addDice (Dice dice) {
		this.dices.add(dice);
	}

	public Player(int id, Date registerDate, String name, List<Dice> dices) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.name = name;
		this.dices = dices;
	}
	public Player() {};
	
	public  int rollDices() {
		int result=0;
		for(Dice d: dices) {
			result =result+d.rollDice();
		}
		this.previousRolls=currentRoll;
		this.currentRoll= result;
		this.rolls.put("Roll nº: "+this.rollCounter, result);
		this.rollCounter++;
		return result;
	}
}
