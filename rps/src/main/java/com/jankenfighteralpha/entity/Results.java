package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="results")
public class Results {
	// Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="result_id")
	private int resultId;
	@Column(name="winner")
	private String winner;
	@Column(name="round_count")
	private int roundCount;
	@Column(name="formula")
	private String formula;
//	@Column(name="round_list")
//	private String roundList; 
	// Basic Constructor
	public Results() {
		
	}
	// Getters and Setters
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public int getRoundCount() {
		return roundCount;
	}
	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
//	public String getRoundList() {
//		return roundList;
//	}
//	public void setRoundList(String roundList) {
//		this.roundList = roundList;
//	}
	@Override
	public String toString() {
		return "In Battle #: " + resultId + ", the winner is " + winner + " in " + roundCount + " rounds. Round Formula: " + formula + "! Full battle results: ";
	}
	
}
