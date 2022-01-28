package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_stats")
public class UserStats {
	// Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stat_id")
	private int statId;
	@Column(name="chisei")
	private int chisei;
	@Column(name="ken")
	private int ken;
	@Column(name="seishin")
	private int seishin;
	@Column(name="attack")
	private float attack;
	@Column(name="defense")
	private float defense;
	@Column(name="hit")
	private float hit;
	@Column(name="pwr")
	private float pwr;
	// Basic Constructor
	public UserStats() {
		
	}
	// Getters and Setters
	public int getStatId() {
		return statId;
	}
	public void setStatId(int statId) {
		this.statId = statId;
	}
	public int getChisei() {
		return chisei;
	}
	public void setChisei(int chisei) {
		this.chisei = chisei;
	}
	public int getKen() {
		return ken;
	}
	public void setKen(int ken) {
		this.ken = ken;
	}
	public int getSeishin() {
		return seishin;
	}
	public void setSeishin(int seishin) {
		this.seishin = seishin;
	}
	public float getAttack() {
		return attack;
	}
	public void setAttack(float attack) {
		this.attack = attack;
	}
	public float getDefense() {
		return defense;
	}
	public void setDefense(float defense) {
		this.defense = defense;
	}
	public float getHit() {
		return hit;
	}
	public void setHit(float hit) {
		this.hit = hit;
	}
	public float getPwr() {
		return pwr;
	}
	public void setPwr(float pwr) {
		this.pwr = pwr;
	}
	@Override
	public String toString() {
		return "CHI: " + chisei + "\nKEN: " + ken + "\nSEI:" + seishin + "\nATK: " + attack
				+ "  DEF: " + defense + "\nHEALTH: " + hit + "\nPOWER:" + pwr;
	}
}

