package com.jankenfighteralpha.entity;

public class Rounds {
	// Class Variables
	private int roundId;
	private String attacker;
	private String attackerMove;
	private String attackerMoveType;
	private String attackerPon;
	private float attackerAtk;
	private String defender;
	private String defenderMove;
	private String defenderMoveType;
	private String defenderPon;
	private float defenderDef;
	private float dmgCalculated;
	private String firstToZero;
	// Basic Constructor
	public Rounds() {
		
	}
	// Getters and Setters
	public int getRoundId() {
		return roundId;
	}
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	public String getAttacker() {
		return attacker;
	}
	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}
	public String getDefender() {
		return defender;
	}
	public void setDefender(String defender) {
		this.defender = defender;
	}
	public String getAttackerMove() {
		return attackerMove;
	}
	public void setAttackerMove(String attackerMove) {
		this.attackerMove = attackerMove;
	}
	public String getAttackerMoveType() {
		return attackerMoveType;
	}
	public void setAttackerMoveType(String attackerMoveType) {
		this.attackerMoveType = attackerMoveType;
	}
	public String getAttackerPon() {
		return attackerPon;
	}
	public void setAttackerPon(String attackerPon) {
		this.attackerPon = attackerPon;
	}
	public String getDefenderMove() {
		return defenderMove;
	}
	public void setDefenderMove(String defenderMove) {
		this.defenderMove = defenderMove;
	}
	public String getDefenderMoveType() {
		return defenderMoveType;
	}
	public void setDefenderMoveType(String defenderMoveType) {
		this.defenderMoveType = defenderMoveType;
	}
	public String getDefenderPon() {
		return defenderPon;
	}
	public void setDefenderPon(String defenderPon) {
		this.defenderPon = defenderPon;
	}
	public float getAttackerAtk() {
		return attackerAtk;
	}
	public void setAttackerAtk(float attackerAtk) {
		this.attackerAtk = attackerAtk;
	}
	public float getDefenderDef() {
		return defenderDef;
	}
	public void setDefenderDef(float defenderDef) {
		this.defenderDef = defenderDef;
	}
	public float getDmgCalculated() {
		return dmgCalculated;
	}
	public void setDmgCalculated(float dmgCalculated) {
		this.dmgCalculated = dmgCalculated;
	}
	public String getFirstToZero() {
		return firstToZero;
	}
	public void setFirstToZero(String firstToZero) {
		this.firstToZero = firstToZero;
	}	
	@Override
	public String toString() {
		return "Round #" + roundId + ", Attacker: " + attacker + ", Defender: " + defender + ", Atk Move: "
				+ attackerMove + ", Def Move: " + defenderMove + ", Attack: " + attackerAtk + ", Defense: " 
				+ defenderDef + ", Defeated: " + firstToZero;
	}	
}
