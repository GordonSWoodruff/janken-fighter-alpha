package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="back_torso")
public class BackTorso {
	// Class Variables
	@Id
	@Column(name="back_torso_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int backTorsoId;
	@Column(name="back_torso")
	private String backTorso;
	@Column(name="torso_name")
	private String torsoName;
	@Column(name="torso_desc")
	private String torsoDesc;
	@Column(name="torso_image_file")
	private String torsoImageFile;
	// Basic Constructor
	public BackTorso() {
		
	}
	// Getters and Setters
	public int getBackTorsoId() {
		return backTorsoId;
	}
	public void setBackTorsoId(int backTorsoId) {
		this.backTorsoId = backTorsoId;
	}
	public String getBackTorso() {
		return backTorso;
	}
	public void setTorso(String backTorso) {
		this.backTorso = backTorso;
	}
	public String getTorsoName() {
		return torsoName;
	}
	public void setTorsoName(String torsoName) {
		this.torsoName = torsoName;
	}
	public String getTorsoDesc() {
		return torsoDesc;
	}
	public void setTorsoDesc(String torsoDesc) {
		this.torsoDesc = torsoDesc;
	}
	public String getTorsoImageFile() {
		return torsoImageFile;
	}
	public void setTorsoImageFile(String torsoImageFile) {
		this.torsoImageFile = torsoImageFile;
	}
	@Override
	public String toString() {
		return "Torso " + backTorso;
	}
}
