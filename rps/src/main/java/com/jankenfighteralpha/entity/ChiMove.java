package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chi_move")
public class ChiMove {
	// Class Variables
	@Id
	@Column(name="c_move_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cMoveId;
	@Column(name="c_move")
	private String cMove;
	@Column(name="c_move_key")
	private String cMoveKey;
	@Column(name="move_name")
	private String moveName;
	@Column(name="move_desc")
	private String moveDesc;
	@Column(name="move_stat")
	private int moveStat;
	@Column(name="move_buff")
	private float moveBuff;
	// Basic Constructor
	public ChiMove() {
		
	}
	// Getters and Setters
	public int getcMoveId() {
		return cMoveId;
	}
	public void setcMoveId(int cMoveId) {
		this.cMoveId = cMoveId;
	}
	public String getcMove() {
		return cMove;
	}
	public void setcMove(String cMove) {
		this.cMove = cMove;
	}
	public String getcMoveKey() {
		return cMoveKey;
	}
	public void setcMoveKey(String cMoveKey) {
		this.cMoveKey = cMoveKey;
	}
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public String getMoveDesc() {
		return moveDesc;
	}
	public void setMoveDesc(String moveDesc) {
		this.moveDesc = moveDesc;
	}
	public int getMoveStat() {
		return moveStat;
	}
	public void setMoveStat(int moveStat) {
		this.moveStat = moveStat;
	}
	public float getMoveBuff() {
		return moveBuff;
	}
	public void setMoveBuff(float moveBuff) {
		this.moveBuff = moveBuff;
	}
	@Override
	public String toString() {
		return "Chi Move: " + moveName  + "(" + cMoveId + "): " + moveDesc;
	}
	public int toIDString() {
		return cMoveId;
	}
}
