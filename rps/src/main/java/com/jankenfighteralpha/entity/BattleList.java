package com.jankenfighteralpha.entity;

public class BattleList {
	// Class Variables
	private int battleId;
	// Basic Constructor
	public BattleList() {
		
	}
	// Getters and Setters
	public int getBattleId() {
		return battleId;
	}
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}
	@Override
	public String toString() {
		return "Battle List " + "Battle ID: " + battleId;
	}
	
}
