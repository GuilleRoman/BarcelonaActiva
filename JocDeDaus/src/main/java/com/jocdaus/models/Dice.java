package com.jocdaus.models;

import java.util.HashMap;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dices")
public class Dice {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Player.class)
	@JoinColumn(name="player_id")
	private Player player;
	private HashMap<String, Integer> rolls;
	private int result;

	private String rollCounter;
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Dice(Player player) {
		super();
		this.player = player;
	}
	public Dice(Player player, int result) {
		super();
		this.player = player;
		this.result=result;
	}
	
	public Dice() {super();}
	public Dice(int id, Player player, HashMap<String, Integer> rolls, int result, String rollCounter) {
		super();
		this.id = id;
		this.player = player;
		this.rolls = rolls;
		this.result = result;
		this.rollCounter = rollCounter;
	}
	public int rollDice() {
		Random r = new Random();
		int low = 1;
		int high = 6;
		int result = r.nextInt(high-low) + low;
		this.rolls.put("Roll nº: "+this.rollCounter, result);
		return result;
	}
}
