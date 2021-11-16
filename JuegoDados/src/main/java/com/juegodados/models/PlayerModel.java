package com.juegodados.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.juegodados.documents.Game;

public class PlayerModel {
    
	
	private Date registerDate;
	
	
	private String name;
	
	private List<GameModel> gamesPlayed;
	private double winRate;
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

	public List<GameModel> getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(List<GameModel> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}
	public PlayerModel(Date registerDate, String name, List<GameModel> gamesPlayed, double winRate) {
		super();
		this.registerDate = registerDate;
		this.name = name;
		this.gamesPlayed = gamesPlayed;
		this.winRate = winRate;
	}
	public PlayerModel() {
		super();
	}
	@Override
	public String toString() {
		return "PlayerModel [registerDate=" + registerDate + ", name=" + name + ", gamesPlayed=" + gamesPlayed
				+ ", winRate=" + winRate + "]";
	}

	
}
