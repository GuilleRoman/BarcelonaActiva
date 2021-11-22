package com.jocdaus.models;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity=Player.class)
	@JoinColumn(name="player_id")
	private Player player;
	private String winner;
	private String loser;
	@OneToOne(mappedBy = "game")
	private Roll rolls;
	
	public Roll getRolls() {
		return rolls;
	}
	public void setRolls(Roll rolls) {
		this.rolls = rolls;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getLoser() {
		return loser;
	}
	public void setLoser(String loser) {
		this.loser = loser;
	}
	public Game( Player player) {
		super();
		
		this.player = player;
	}
	
	public Game( Player player, String winner, String loser) {
		super();
		
		this.player = player;
		this.winner= winner;
		this.loser=loser;
	}
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
