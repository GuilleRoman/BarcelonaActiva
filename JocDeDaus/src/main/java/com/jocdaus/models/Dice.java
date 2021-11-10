package com.jocdaus.models;

import java.util.HashMap;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@OneToOne(mappedBy = "dices")
	private Roll rolls;

	
	public Roll getRolls() {
		return rolls;
	}
	public void setRolls(Roll rolls) {
		this.rolls = rolls;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	public Dice(Player player) {
		super();
		this.player = player;
		
	}
	
	public Dice() {super();}
	public Dice(int id, Player player,  int result) {
		super();
		this.id = id;
		this.player = player;
		
		
	}
	public int rollDice() {
		Random r = new Random();
		int low = 1;
		int high = 6;
		int result = r.nextInt(high-low) + low;
		return result;
	}
}
