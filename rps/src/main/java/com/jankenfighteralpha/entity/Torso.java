package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="torso")
public class Torso {
	// Class Variables
	@Id
	@Column(name="torso_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int torsoId;
	@Column(name="torso")
	private String torso;
	@Column(name="torso_name")
	private String torsoName;
	@Column(name="torso_desc")
	private String torsoDesc;
	@Column(name="torso_image_file")
	private String torsoImageFile;
	// Basic Constructor
	public Torso() {
		
	}
	// Getters and Setters
	public int getTorsoId() {
		return torsoId;
	}
	public void setTorsoId(int torsoId) {
		this.torsoId = torsoId;
	}
	public String getTorso() {
		return torso;
	}
	public void setTorso(String torso) {
		this.torso = torso;
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
		return "Torso " + torsoId + ": " + torsoName + ", " + torsoDesc + ", Image File: " + torsoImageFile;
	}
}
