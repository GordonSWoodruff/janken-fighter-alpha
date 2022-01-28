package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arms")
public class Arms {
	// Class Variables
	@Id
	@Column(name="arms_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int armsId;
	@Column(name="arms")
	private String arms;
	@Column(name="arms_name")
	private String armsName;
	@Column(name="arms_desc")
	private String armsDesc;
	@Column(name="arms_image_file")
	private String armsImageFile;
	// Basic Constructor
	public Arms() {
		
	}
	public int getArmsId() {
		return armsId;
	}
	public void setArmsId(int armsId) {
		this.armsId = armsId;
	}
	public String getArms() {
		return arms;
	}
	public void setArms(String arms) {
		this.arms = arms;
	}
	public String getArmsName() {
		return armsName;
	}
	public void setArmsName(String armsName) {
		this.armsName = armsName;
	}
	public String getArmsDesc() {
		return armsDesc;
	}
	public void setArmsDesc(String armsDesc) {
		this.armsDesc = armsDesc;
	}
	public String getArmsImageFile() {
		return armsImageFile;
	}
	public void setArmsImageFile(String armsImageFile) {
		this.armsImageFile = armsImageFile;
	}
	@Override
	public String toString() {
		return "Arms " + armsId + ": " + armsName + ", " + armsDesc + ", Image File: " + armsImageFile;
	}
}
