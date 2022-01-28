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
@Table(name="moveset")
public class Moveset {
	// Class Variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="moveset_id")
	private int movesetId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_move_id")
	private ChiMove chiMove;
	@Column(name="c_move_use")
	private boolean cMoveUse;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="k_move_id")
	private KenMove kenMove;
	@Column(name="k_move_use")
	private boolean kMoveUse;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="s_move_id")
	private SeiMove seiMove;
	@Column(name="s_move_use")
	private boolean sMoveUse;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="p_move_id")
	private SurpriseMove surpriseMove;
	@Column(name="p_move_use")
	private boolean pMoveUse;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="z_move_id")
//	private SuperMove superMove;
//	@Column(name="z_move_use")
//	private boolean zMoveUse;
	// Basic Constructor
	public Moveset() {
		
	}
	// Getters and Setters
	public int getMovesetId() {
		return movesetId;
	}
	public void setMovesetId(int movesetId) {
		this.movesetId = movesetId;
	}
	public ChiMove getChiMove() {
		return chiMove;
	}
	public void setChiMove(ChiMove chiMove) {
		this.chiMove = chiMove;
	}
	public boolean getcMoveUse() {
		return cMoveUse;
	}
	public void setcMoveUse(boolean cMoveUse) {
		this.cMoveUse = cMoveUse;
	}
	public KenMove getKenMove() {
		return kenMove;
	}
	public void setKenMove(KenMove kenMove) {
		this.kenMove = kenMove;
	}
	public boolean getkMoveUse() {
		return kMoveUse;
	}
	public void setkMoveUse(boolean kMoveUse) {
		this.kMoveUse = kMoveUse;
	}
	public SeiMove getSeiMove() {
		return seiMove;
	}
	public void setSeiMove(SeiMove seiMove) {
		this.seiMove = seiMove;
	}
	public boolean getsMoveUse() {
		return sMoveUse;
	}
	public void setsMoveUse(boolean sMoveUse) {
		this.sMoveUse = sMoveUse;
	}
	public SurpriseMove getSurpriseMove() {
		return surpriseMove;
	}
	public void setSurpriseMove(SurpriseMove surpriseMove) {
		this.surpriseMove = surpriseMove;
	}
	public boolean getpMoveUse() {
		return pMoveUse;
	}
	public void setpMoveUse(boolean pMoveUse) {
		this.pMoveUse = pMoveUse;
	}
//	public SuperMove getSuperMove() {
//		return superMove;
//	}
//	public void setSuperMove(SuperMove superMove) {
//		this.superMove = superMove;
//	}
	@Override
	public String toString() {
		return "Moveset: " + movesetId + ", Chi Move = " + chiMove.getMoveName() + " ready for use: " + cMoveUse + ", Ken Move = " + kenMove.getMoveName() 
		+ " ready for use: " + kMoveUse + ", Sei Move = " + seiMove.getMoveName() + " ready for use: " + sMoveUse + ", Surprise Move = "
		+ surpriseMove.getMoveName()+ " ready for use: " + pMoveUse;
	}
	
}
