package com.juegomongo.documents;

import java.util.Random;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="games")
public class Game {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	
	private String playerName;
	private String winner;
	private String loser;
	private int resultDice1;
	private int resultDice2;
	private int result;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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
	public int getResultDice1() {
		return resultDice1;
	}
	public void setResultDice1(int resultDice1) {
		this.resultDice1 = resultDice1;
	}
	public int getResultDice2() {
		return resultDice2;
	}
	public void setResultDice2(int resultDice2) {
		this.resultDice2 = resultDice2;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Game() {
		super();
	}
	public Game(String id, String playerName, String winner, String loser, int resultDice1, int resultDice2,
			int result) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.winner = winner;
		this.loser = loser;
		this.resultDice1 = resultDice1;
		this.resultDice2 = resultDice2;
		this.result = result;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", playerName=" + playerName + ", winner=" + winner + ", loser=" + loser
				+ ", resultDice1=" + resultDice1 + ", resultDice2=" + resultDice2 + ", result=" + result + "]";
	}
	
	
	
}
