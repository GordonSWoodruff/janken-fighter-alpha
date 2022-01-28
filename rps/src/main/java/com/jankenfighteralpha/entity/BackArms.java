package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="back_arms")
public class BackArms {
	// Class Variables
	@Id
	@Column(name="back_arms_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int backArmsId;
	@Column(name="back_arms")
	private String backArms;
	@Column(name="arms_name")
	private String armsName;
	@Column(name="arms_desc")
	private String armsDesc;
	@Column(name="arms_image_file")
	private String armsImageFile;
	// Basic Constructor
	public BackArms() {
		
	}
	public int getBackArmsId() {
		return backArmsId;
	}
	public void setBackArmsId(int backArmsId) {
		this.backArmsId = backArmsId;
	}
	public String getBackArms() {
		return backArms;
	}
	public void setBackArms(String backArms) {
		this.backArms = backArms;
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
		return "Arms " + backArms;
	}
}
