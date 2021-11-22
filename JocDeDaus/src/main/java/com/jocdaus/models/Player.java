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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jocdaus.controller.GameController;
@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String password;
	@Column(name="register_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date registerDate;
	@Column(columnDefinition = "varchar(255) default 'ANONIMO'", unique=true)
	private String name;
	
	@OneToMany(mappedBy="player")
	@JsonIgnore
	private List<Dice> dices= new ArrayList<Dice>();
	
	
	@OneToMany(targetEntity=Game.class)
	@JsonIgnore
	private List<Game> gamesPlayed;
	
	@Column
	private double winRate;
	
	@OneToMany(mappedBy = "player")
	@JsonIgnore
	private List<Roll> rolls;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Game> getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(List<Game> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public List<Roll> getRolls() {
		return rolls;
	}
	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}
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
	
	
	public Player(int id, String password, Date registerDate, String name, List<Dice> dices, List<Game> gamesPlayed,
			double winRate, List<Roll> rolls) {
		super();
		this.id = id;
		this.password = password;
		this.registerDate = registerDate;
		this.name = name;
		this.dices = dices;
		this.gamesPlayed = gamesPlayed;
		this.winRate = winRate;
		this.rolls = rolls;
	}
	public Player( Date registerDate, String name) {
		super();
	
		this.registerDate = registerDate;
		this.name = name;
//		Dice dice1= new Dice(this);
//		Dice dice2= new Dice(this);
//		this.dices.add(dice1);
//		this.dices.add(dice2);

	}
	
	public Player() {};
	
	public Player( String name, String password) {
		super();
		this.name = name;
		this.password=password;
		Dice dice1= new Dice(this);
		Dice dice2= new Dice(this);
		this.dices.add(dice1);
		this.dices.add(dice2);

	}
	
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", password=" + password + ", registerDate=" + registerDate + ", name=" + name
				+ ", dices=" + dices + ", gamesPlayed=" + gamesPlayed + ", winRate=" + winRate + ", rolls=" + rolls
				+ "]";
	}
	public  int rollDices(Game game) {
		// Definimos una partida actual que elabora toda la lógica del programa y le añadimos este jugador
		//mediante "this". El método lanza ambos dados, si el resultado de la suma es 7, añadimos ganador,
		// de lo contrario, perdedor. Además, añadimos la partida a la lista de partidas del jugador y
		// añadimos la tirada al hashmap que contiene la partida junto al resultado.
		 Game currentGame = new Game(this);
		 
		int result=0;
		for(Dice d: dices) {
			result =result+d.rollDice();
		}
	
	
		if(result==7) {
			currentGame.setWinner(getName());
		}else {
			currentGame.setLoser(getName());
		}
		
		this.gamesPlayed.add(currentGame);
		 
		return result;
	}
}
