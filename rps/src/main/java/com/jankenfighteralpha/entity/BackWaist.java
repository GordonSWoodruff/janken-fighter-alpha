package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="back_waist")
public class BackWaist {
	// Class Variables
	@Id
	@Column(name="back_waist_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int backWaistId;
	@Column(name="back_waist")
	private String backWaist;
	@Column(name="waist_name")
	private String waistName;
	@Column(name="waist_desc")
	private String waistDesc;
	@Column(name="waist_image_file")
	private String waistImageFile;
	// Basic Constructor
	public BackWaist() {
		
	}
	// Getters and Setters
	public int getBackWaistId() {
		return backWaistId;
	}
	public void setBackWaistId(int backWaistId) {
		this.backWaistId = backWaistId;
	}
	public String getBackWaist() {
		return backWaist;
	}
	public void setWaist(String backWaist) {
		this.backWaist = backWaist;
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
		return "Waist " + backWaist;
	}
}
