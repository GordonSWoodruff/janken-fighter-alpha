package com.jankenfighteralpha.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avatar")
public class Avatar {
	// Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="avatar_id")
	private int avatarId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="arms_part")
	private Arms armsPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="back_arms_part")
	private BackArms backArmsPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="head_part")
	private Head headPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="back_head_part")
	private BackHead backHeadPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="legs_part")
	private Legs legsPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="back_legs_part")
	private BackLegs backLegsPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="torso_part")
	private Torso torsoPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="back_torso_part")
	private BackTorso backTorsoPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="waist_part")
	private Waist waistPart;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="back_waist_part")
	private BackWaist backWaistPart;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="accessory")
//	private Accessory accessory;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="back_accessory")
//	private BackAccessory backAccessory;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="pet")
//	private Pets pet;
	// Basic Constructor
	public Avatar() {
		
	}
	// Getters and Setters
	public int getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(int avatarId) {
		this.avatarId = avatarId;
	}
	public Arms getArmsPart() {
		return armsPart;
	}
	public void setArmsPart(Arms armsPart) {
		this.armsPart = armsPart;
	}
	public BackArms getBackArmsPart() {
		return backArmsPart;
	}
	public void setBackArmsPart(BackArms backArmsPart) {
		this.backArmsPart = backArmsPart;
	}
	public Head getHeadPart() {
		return headPart;
	}
	public void setHeadPart(Head headPart) {
		this.headPart = headPart;
	}
	public BackHead getBackHeadPart() {
		return backHeadPart;
	}
	public void setBackHeadPart(BackHead backHeadPart) {
		this.backHeadPart = backHeadPart;
	}
	public Legs getLegsPart() {
		return legsPart;
	}
	public void setLegsPart(Legs legsPart) {
		this.legsPart = legsPart;
	}
	public BackLegs getBackLegsPart() {
		return backLegsPart;
	}
	public void setBackLegsPart(BackLegs backLegsPart) {
		this.backLegsPart = backLegsPart;
	}
	public Torso getTorsoPart() {
		return torsoPart;
	}
	public void setTorsoPart(Torso torsoPart) {
		this.torsoPart = torsoPart;
	}
	public BackTorso getBackTorsoPart() {
		return backTorsoPart;
	}
	public void setBackTorsoPart(BackTorso backTorsoPart) {
		this.backTorsoPart = backTorsoPart;
	}
	public Waist getWaistPart() {
		return waistPart;
	}
	public void setWaistPart(Waist waistPart) {
		this.waistPart = waistPart;
	}
	public BackWaist getBackWaistPart() {
		return backWaistPart;
	}
	public void setBackWaistPart(BackWaist backWaistPart) {
		this.backWaistPart = backWaistPart;
	}
//	public Accessory getAccessory() {
//		return accessory;
//	}
//	public void setAccesory(Accessory accessory) {
//		this.accessory = accessory;
//	}
//	public BackAccessory getBackAccessory() {
//	return backAccessory;
//	}
//	public void setBackAccesory(BackAccessory backAccessory) {
//		this.backAccessory = backAccessory;
//	}
//	public Pets getPet() {
//		return pet;
//	}
//	public void setPet(Pets pet) {
//		this.pet = pet;
//	}
	@Override
	public String toString() {
		return "Avatar " + avatarId + ": " + "\nHead: " + headPart.toString() + backHeadPart.toString() + "\nTorso: " + torsoPart.toString() 
			+ backTorsoPart.toString() + "\nArms: " +  armsPart.toString() + backArmsPart.toString() + "\nWaist: " + waistPart.toString() 
			+ backWaistPart.toString() + "\nLegs: " + legsPart.toString() + backLegsPart.toString();
	}
}
