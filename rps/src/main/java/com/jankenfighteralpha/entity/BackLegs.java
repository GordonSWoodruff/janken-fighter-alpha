package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="back_legs")
public class BackLegs {
	// Class Variables
	@Id
	@Column(name="back_legs_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int backLegsId;
	@Column(name="back_legs")
	private String backLegs;
	@Column(name="legs_name")
	private String legsName;
	@Column(name="legs_desc")
	private String legsDesc;
	@Column(name="Legs_image_file")
	private String legsImageFile;
	// Basic Constructor
	public BackLegs() {
		
	}
	// Getters and Setters
	public int getBackLegsId() {
		return backLegsId;
	}
	public void setBackLegs(int backLegsId) {
		this.backLegsId = backLegsId;
	}
	public String getBackLegs() {
		return backLegs;
	}
	public void setBackLegs(String backLegs) {
		this.backLegs = backLegs;
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
		return "Legs " + backLegs;
	}
}
