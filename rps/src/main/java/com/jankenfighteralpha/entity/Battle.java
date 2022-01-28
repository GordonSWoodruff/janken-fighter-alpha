package com.jankenfighteralpha.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="battle")
@DynamicUpdate
public class Battle {
	// Declare Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="battle_id")
	private int battleId;
	@Column(name="attacker_id")
	private int attacker;
	@Column(name="attacker_hp")
	private float attackerHP;
	@Column(name="attacker_surprise_count")
	private int attackerSurpriseCount;
	@Column(name="defender_id")
	private int defender;
	@Column(name="defender_hp")
	private float defenderHP;
	@Column(name="defender_surprise_count")
	private int defenderSurpriseCount;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="result_id")
	private Results result;
	// Basic Constructor
	public Battle() {
		
	}
	// Getters and Setters
	public int getBattleId() {
		return battleId;
	}
	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}
	public int getAttacker() {
		return attacker;
	}
	public void setAttacker(int attacker) {
		this.attacker = attacker;
	}
	public float getAttackerHP() {
		return attackerHP;
	}
	public void setAttackerHP(float attackerHP) {
		this.attackerHP = attackerHP;
	}
	public int getAttackerSurpriseCount() {
		return attackerSurpriseCount;
	}
	public void setAttackerSurpriseCount(int attackerSurpriseCount) {
		this.attackerSurpriseCount = attackerSurpriseCount;
	}
	public int getDefender() {
		return defender;
	}
	public void setDefender(int defender) {
		this.defender = defender;
	}
	public float getDefenderHP() {
		return defenderHP;
	}
	public void setDefenderHP(float defenderHP) {
		this.defenderHP = defenderHP;
	}
	public int getDefenderSurpriseCount() {
		return defenderSurpriseCount;
	}
	public void setDefenderSurpriseCount(int defenderSurpriseCount) {
		this.defenderSurpriseCount = defenderSurpriseCount;
	}
	public Results getResult() {
		return result;
	}
	public void setResult(Results result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Battle Results: This battle (" + battleId + ") was fought with the initiating attacker (ID: " + attacker + ") who started with HP of " 
				+ attackerHP + " faced against defender (ID: " + defender + ") who started with HP of " + defenderHP + ". Final Results: " + result;
	}	
}
