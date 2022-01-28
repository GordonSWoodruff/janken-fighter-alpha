package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="back_head")
public class BackHead {
	// Class Variables
	@Id
	@Column(name="back_head_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int backHeadId;
	@Column(name="back_head")
	public String backHead;
	@Column(name="head_name")
	public String headName;
	@Column(name="head_desc")
	public String headDesc;
	@Column(name="head_image_file")
	private String headImageFile;
	// Basic Constructor
	public BackHead() {
		
	}
	// Getters and Setters
	public int getBackHeadId() {
		return backHeadId;
	}
	public void setBackHeadId(int backHeadId) {
		this.backHeadId = backHeadId;
	}
	public String getBackHead() {
		return backHead;
	}
	public void setBackHead(String backHead) {
		this.backHead = backHead;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getHeadDesc() {
		return headDesc;
	}
	public void setHeadDesc(String headDesc) {
		this.headDesc = headDesc;
	}
	public String getHeadImageFile() {
		return headImageFile;
	}
	public void setHeadImageFile(String headImageFile) {
		this.headImageFile = headImageFile;
	}
	@Override
	public String toString() {
		return "Head " + backHead;
	}
}
