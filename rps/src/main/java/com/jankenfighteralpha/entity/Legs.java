package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="legs")
public class Legs {
	// Class Variables
	@Id
	@Column(name="legs_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int legsId;
	@Column(name="legs")
	private String legs;
	@Column(name="legs_name")
	private String legsName;
	@Column(name="legs_desc")
	private String legsDesc;
	@Column(name="Legs_image_file")
	private String legsImageFile;
	// Basic Constructor
	public Legs() {
		
	}
	//Getters and Setters
	public int getLegsId() {
		return legsId;
	}
	public void setLegsId(int legsId) {
		this.legsId = legsId;
	}
	public String getLegs() {
		return legs;
	}
	public void setLegs(String legs) {
		this.legs = legs;
	}
	public String getLegsName() {
		return legsName;
	}
	public void setLegsName(String legsName) {
		this.legsName = legsName;
	}
	public String getLegsDesc() {
		return legsDesc;
	}
	public void setLegsDesc(String legsDesc) {
		this.legsDesc = legsDesc;
	}
	public String getLegsImageFile() {
		return legsImageFile;
	}
	public void setLegsImageFile(String legsImageFile) {
		this.legsImageFile = legsImageFile;
	}
	@Override
	public String toString() {
		return "Legs " + legsId + ": " + legsName + ", " + legsDesc + ", Image File: " + legsImageFile;
	}
}
