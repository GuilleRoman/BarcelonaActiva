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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rolls")
public class Roll {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(targetEntity=Game.class, cascade=CascadeType.ALL)
	@JoinColumn(name="game_id", referencedColumnName = "id")
	@JsonIgnore
	private Game game;
	
	@OneToOne(targetEntity=Player.class, cascade=CascadeType.ALL)
	@JoinColumn(name="player_id", referencedColumnName = "id")
	@JsonIgnore
	private Player player;
	
	@Column(columnDefinition = "integer not null default 0")
	private int result;
	@Column(columnDefinition = "integer not null default 0")
	private int resultdice1;
	@Column(columnDefinition = "integer not null default 0")
	private int resultdice2;
	
	
	
	public int getResultdice1() {
		return resultdice1;
	}
	public void setResultdice1(int resultdice1) {
		this.resultdice1 = resultdice1;
	}
	public int getResultdice2() {
		return resultdice2;
	}
	public void setResultdice2(int resultdice2) {
		this.resultdice2 = resultdice2;
	}
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
//	public List<Dice> getDices() {
//		return dices;
//	}
//	public void setDices(List<Dice> dices) {
//		this.dices = dices;
//	}
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
//		this.resultdice1=player.getDices().get(0).rollDice();
//		this.resultdice2=player.getDices().get(1).rollDice();
//		this.result= resultdice1 + resultdice2;
		
	}
	public Roll() {
		super();
	}
	
	public void rollDices() {
		
		 
		int result=0;
		int sum=0;
		for(Dice d: this.player.getDices()) {
			
			result= d.rollDice();
			sum=sum+result;
			
			if (d.equals(player.getDices().get(0))) {
				this.resultdice1 = result;
			}else if(d.equals(player.getDices().get(1))) {
				this.resultdice2 = result;
			}
			
		}
		this.result=sum;
		if(sum==7) {
			this.game.setWinner(this.getPlayer().getName());
		}else {
			this.game.setLoser(this.getPlayer().getName());
		}
		

	}
	
}
