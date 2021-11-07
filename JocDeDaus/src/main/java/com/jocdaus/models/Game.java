package com.jocdaus.models;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="games")
public class Game {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity=Player.class)
	@JoinColumn(name="player_id")
	private List<Player> players;
	private HashMap<Player, Integer> rolls;
	private String winner;
	private String loser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public HashMap<Player, Integer> getRolls() {
		return rolls;
	}
	public void setRolls(HashMap<Player, Integer> rolls) {
		this.rolls = rolls;
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
	public Game(int id, List<Player> players) {
		super();
		this.id = id;
		this.players = players;
	}
	
	
	
}
