package com.juegodados.models;

import com.juegodados.entities.Player;

public class GameModel {
	
	
	private String winner;
	private String loser;
	private int resultDice1;
	private int resultDice2;
	private int result;
	private String playerName;

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
	public GameModel(String winner, String loser, int resultDice1, int resultDice2, int result, String playerName) {
		super();
		this.winner = winner;
		this.loser = loser;
		this.resultDice1 = resultDice1;
		this.resultDice2 = resultDice2;
		this.result = result;
		this.playerName = playerName;
	}
	public GameModel() {
		super();
	}
	@Override
	public String toString() {
		return "GameModel [winner=" + winner + ", loser=" + loser + ", resultDice1=" + resultDice1 + ", resultDice2="
				+ resultDice2 + ", result=" + result + ", playerName=" + playerName + "]";
	}
	
	
	
}
