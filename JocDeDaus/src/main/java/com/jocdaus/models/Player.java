package com.jocdaus.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jocdaus.controller.GameController;
@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private Date registerDate;
	@Column(columnDefinition = "varchar(255) default 'ANONIMO'")
	private String name;
	
	@OneToMany(mappedBy="player")
	private List<Dice> dices;
	
	private int currentRoll;
	
	@OneToMany(targetEntity=Game.class)
	private List<Game> gamesPlayed;
	
	@Column
	private HashMap<Game, Integer> rolls;
	@Column
	private double winRate;
	
//	private int rollCounter=0;
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

	public HashMap<Game, Integer> getRolls() {
		return rolls;
	}
	public void setRolls(HashMap<Game, Integer> rolls) {
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

	public Player( Date registerDate, String name, List<Dice> dices) {
		super();
	
		this.registerDate = registerDate;
		this.name = name;
		this.dices = dices;
//		GameController.players.add(this);

	}
	
	public Player( Date registerDate, String name, int currentRoll) {
		super();
	
		this.registerDate = registerDate;
		this.name = name;
		this.currentRoll=currentRoll;
//		GameController.players.add(this);

	}
	
	public Player() {};
	
	public Player( String name) {
		super();
		this.name = name;

	}
	
	
	public  int rollDices() {
		// Definimos una partida actual que elabora toda la lógica del programa y le añadimos este jugador
		//mediante "this". El método lanza ambos dados, si el resultado de la suma es 7, añadimos ganador,
		// de lo contrario, perdedor. Además, añadimos la partida a la lista de partidas del jugador y
		// añadimos la tirada al hashmap que contiene la partida junto al resultado.
		 Game currentGame = new Game(this);
		 
		int result=0;
		for(Dice d: dices) {
			result =result+d.rollDice();
		}
	
		this.currentRoll= result;
		if(result==7) {
			currentGame.setWinner(getName());
		}else {
			currentGame.setLoser(getName());
		}
		this.currentRoll=result;
		this.gamesPlayed.add(currentGame);
		this.rolls.put(currentGame, result);
//		this.rollCounter++;
		return result;
	}
}
