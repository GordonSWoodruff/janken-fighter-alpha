package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waist")
public class Waist {
	// Class Variables
	@Id
	@Column(name="waist_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int waistId;
	@Column(name="waist")
	private String waist;
	@Column(name="waist_name")
	private String waistName;
	@Column(name="waist_desc")
	private String waistDesc;
	@Column(name="waist_image_file")
	private String waistImageFile;
	// Basic Constructor
	public Waist() {
		
	}
	// Getters and Setters
	public int getWaistId() {
		return waistId;
	}
	public void setWaistId(int waistId) {
		this.waistId = waistId;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getWaistName() {
		return waistName;
	}
	public void setWaistName(String waistName) {
		this.waistName = waistName;
	}
	public String getWaistDesc() {
		return waistDesc;
	}
	public void setWaistDesc(String waistDesc) {
		this.waistDesc = waistDesc;
	}
	public String getWaistImageFile() {
		return waistImageFile;
	}
	public void setWaistImageFile(String waistImageFile) {
		this.waistImageFile = waistImageFile;
	}
	public String toString() {
		return "Waist " + waistId + ": " + waistName + ", " + waistDesc + ", Image File: " + waistImageFile;
	}
}
