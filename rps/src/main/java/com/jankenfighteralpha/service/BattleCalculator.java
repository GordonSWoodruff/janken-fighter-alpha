package com.jankenfighteralpha.service;

import org.springframework.stereotype.Service;

import com.jankenfighteralpha.entity.Moveset;
import com.jankenfighteralpha.entity.Users;

@Service
public class BattleCalculator {	
	// Randomly decide the computer opponent's moveset
	public Moveset determineCPUInput(Moveset nonHumanMoves,int surpriseCount) {
		int randomNum = 0;
		System.out.println("Imported Moveset: " + nonHumanMoves.toString());
		// RNG
		randomNum = (int) Math.round(Math.random()*100);
		System.out.println("********\nRANDOM NUMBER: " + randomNum + "\n********"); // CORRECT
		// Decide move based on Random Number
		if(randomNum >= 0 && randomNum < 30) {
			System.out.println("********\nRandom Number (" + randomNum + ") translates to Chi Move " + nonHumanMoves.getChiMove().getMoveName()+"\n********"); // CORRECT
			nonHumanMoves.setcMoveUse(true);
			nonHumanMoves.setkMoveUse(false);
			nonHumanMoves.setsMoveUse(false);
			nonHumanMoves.setpMoveUse(false);
		} else if(randomNum >= 30 && randomNum < 60) {
			System.out.println("********\nRandom Number (" + randomNum + ") translates to Ken Move " + nonHumanMoves.getKenMove().getMoveName()+"\n********");
			nonHumanMoves.setcMoveUse(false);
			nonHumanMoves.setkMoveUse(true);
			nonHumanMoves.setsMoveUse(false);
			nonHumanMoves.setpMoveUse(false);
		} else if(randomNum >= 60 && randomNum < 90) {
			System.out.println("********\nRandom Number (" + randomNum + ") translates to Sei Move " + nonHumanMoves.getSeiMove().getMoveName()+"\n********");
			nonHumanMoves.setcMoveUse(false);
			nonHumanMoves.setkMoveUse(false);
			nonHumanMoves.setsMoveUse(true);
			nonHumanMoves.setpMoveUse(false);
		} else {
			if(surpriseCount != 0) {
				determineCPUInput(nonHumanMoves,surpriseCount);
			} else {
				System.out.println("********\nRandom Number (" + randomNum + ") translates to Surprise Move " + nonHumanMoves.getSurpriseMove().getMoveName()+"\n********");
				nonHumanMoves.setcMoveUse(false);
				nonHumanMoves.setkMoveUse(false);
				nonHumanMoves.setsMoveUse(false);
				nonHumanMoves.setpMoveUse(true);
			}
		}
		
		return nonHumanMoves;
	}
	// Determine the pon move of each fighter
	public String determinePon(Moveset defenderMoves) {
		String pon = "";
		if(defenderMoves.getcMoveUse() == true) {
			pon = "chi";
		} else if(defenderMoves.getkMoveUse() == true) {
			pon = "ken";
		} else if(defenderMoves.getsMoveUse() == true) {
			pon = "sei";
		} else if(defenderMoves.getpMoveUse() == true) {
			pon = "surprise";
		}	
		return pon;	
	}
	// Determine which formula to use for each round
	public String determineFormula(String atkPon,String defPon) {
		String formula = "";
		if(atkPon.equals(defPon)) {
			formula = "aikodesho"; // It seems a tie! 相子でしょう
		} else if(atkPon.equals("chi") && defPon.equals("sei")) {
			formula = "yatta"; // I did it やった  Try to have when player is hit, use itai which means "ouch" 痛い
		} else if(atkPon.equals("ken") && defPon.equals("chi")) {
			formula = "yatta"; // I did it やった
		} else if(atkPon.equals("sei") && defPon.equals("ken")) {
			formula = "yatta"; // I did it やった
		} else if(atkPon.equals("surprise")) {
			formula = "kaihi"; // Evade 回避
		} else if(defPon.equals("surprise")) {
			formula = "hangeki"; // Counterattack 反撃
		} else {
			formula = "ojō"; // Miss お嬢
		}
		return formula;
	}
	// Determine the damage taken by the defender
	public float calculateDamage(Users atk, Users def, String formula, String atkPon) {
		float calcDamage = 0;
		
		if(formula.equals("aikodesho")) { // It's a draw! Normal formula used.
			if(atkPon.equals("ken")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getKen() ) ) - ( (def.getUserStats().getDefense() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getKen() ) );
			} else if (atkPon.equals("chi")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getChisei() ) ) - ( (def.getUserStats().getDefense() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getChisei() ) );
			} else if (atkPon.equals("sei")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getSeishin() ) ) - ( (def.getUserStats().getDefense() * 1f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getSeishin() ) );
			}
		} else if(formula.equals("kaihi")) {
			// Attacker executes an evade attack which bypasses defense.
			calcDamage = ( (atk.getUserStats().getAttack() * 1f) + ( (float) (Math.random() * 1) ) );
		} else if(formula.equals("hangeki")) {
			// Defender executes a counterattack which interrupts the attacker.
			calcDamage = ( (def.getUserStats().getAttack() * 1f) + ( (float) (Math.random() * 1) ) );
		} else if(formula.equals("ojō")) { // Attacker loses! Attacker attacks with reduced efficiency.
			if(atkPon.equals("ken")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getKen() ) ) - ( (def.getUserStats().getDefense() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) def.getUserStats().getSeishin() ) );
			} else if (atkPon.equals("chi")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getChisei() ) ) - ( (def.getUserStats().getDefense() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) def.getUserStats().getKen() ) );
			} else if (atkPon.equals("sei")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) atk.getUserStats().getSeishin() ) ) - ( (def.getUserStats().getDefense() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) def.getUserStats().getChisei() ) );
			}
		} else if(formula.equals("yatta")) { // Attacker wins! Attacker attacks with increased efficiency.
			if(atkPon.equals("ken")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) atk.getUserStats().getKen() ) ) - ( (def.getUserStats().getDefense() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getChisei() ) );
			} else if (atkPon.equals("chi")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) atk.getUserStats().getChisei() ) ) - ( (def.getUserStats().getDefense() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getSeishin() ) );
			} else if (atkPon.equals("sei")) {
				calcDamage = ( (atk.getUserStats().getAttack() * 1.25f) + ( (float) (Math.random() * 2) ) * ( (float) atk.getUserStats().getSeishin() ) ) - ( (def.getUserStats().getDefense() * 0.75f) + ( (float) (Math.random() * 1) ) * ( (float) def.getUserStats().getKen() ) );
			}
		}
		System.out.println("Damage Calculated This Round: " + calcDamage);
		return calcDamage;
	}
}
