package com.jocdaus.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="rolls")
public class Roll {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(targetEntity=Game.class, cascade=CascadeType.ALL)
	@JoinColumn(name="game_id", referencedColumnName = "id")
	private Game game;
	
	@OneToOne(targetEntity=Player.class, cascade=CascadeType.ALL)
	@JoinColumn(name="player_id", referencedColumnName = "id")
	private Player player;
	
	@ManyToOne(targetEntity=Dice.class, cascade=CascadeType.ALL)
	@JoinColumn(name="dice_id", referencedColumnName = "id")
	private List<Dice> dices;
	
	@Column(columnDefinition = "integer not null default 0")
	private int result;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public List<Dice> getDices() {
		return dices;
	}
	public void setDices(List<Dice> dices) {
		this.dices = dices;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Roll( Game game, Player player) {
		super();
		
		this.game = game;
		this.player = player;
		this.dices = player.getDices();
		this.result= player.rollDices();
	}
	public Roll() {
		super();
	}
	
}
