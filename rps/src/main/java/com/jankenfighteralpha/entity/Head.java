package com.jankenfighteralpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="head")
public class Head {
	// Class Variables
	@Id
	@Column(name="head_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int headId;
	@Column(name="head")
	public String head;
	@Column(name="head_name")
	public String headName;
	@Column(name="head_desc")
	public String headDesc;
	@Column(name="head_image_file")
	private String headImageFile;
	// Basic Constructor
	public Head() {
		
	}
	// Getters and Setters
	public int getHeadId() {
		return headId;
	}
	public void setHeadId(int headId) {
		this.headId = headId;
	}
	public String getHead() {
		return head;
	}
	public void setHeadId(String head) {
		this.head = head;
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
		return "Head " + headId + ": " + headName + ", " + headDesc + ", Image File: " + headImageFile;
	}
}
