package com.jankenfighteralpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jankenfighteralpha.entity.Battle;
import com.jankenfighteralpha.entity.ChiMove;
import com.jankenfighteralpha.entity.KenMove;
import com.jankenfighteralpha.entity.Moveset;
import com.jankenfighteralpha.entity.Results;
import com.jankenfighteralpha.entity.Rounds;
import com.jankenfighteralpha.entity.SeiMove;
import com.jankenfighteralpha.entity.SurpriseMove;
import com.jankenfighteralpha.entity.Users;
import com.jankenfighteralpha.repository.BattleRepository;
import com.jankenfighteralpha.repository.ChiMoveRepository;
import com.jankenfighteralpha.repository.KenMoveRepository;
import com.jankenfighteralpha.repository.ResultRepository;
import com.jankenfighteralpha.repository.SeiMoveRepository;
import com.jankenfighteralpha.repository.SurpriseMoveRepository;
import com.jankenfighteralpha.repository.UserRepository;
import com.jankenfighteralpha.service.BattleCalculator;

@CrossOrigin
@RestController
public class BattleController {
	@Autowired
	private BattleCalculator battleCalculator;
	@Autowired
	private BattleRepository battleRepository;
	@Autowired
	private ChiMoveRepository chiMoveRepository;
	@Autowired
	private KenMoveRepository kenMoveRepository;
	@Autowired
	private SeiMoveRepository seiMoveRepository;
	@Autowired
	private SurpriseMoveRepository surpriseMoveRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ResultRepository resultRepository;

	@GetMapping(value="/battle",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle startBattle(@RequestParam int humanPlayer,@RequestParam int opponent) {
		Battle newBattle = new Battle();
		newBattle.setAttacker(humanPlayer);
		newBattle.setAttackerHP(userRepository.findById(humanPlayer).getUserStats().getHit());
		newBattle.setAttackerSurpriseCount(0);
		newBattle.setDefender(opponent);
		newBattle.setDefenderHP(userRepository.findById(opponent).getUserStats().getHit());
		newBattle.setDefenderSurpriseCount(0);
		newBattle.setResult(null);
		newBattle = battleRepository.save(newBattle);
//		String atkList = new String(initiator.getBattleList());
//		atkList = atkList + String.valueOf(newBattle.getBattleId());
//		System.out.println(atkList);
//		battleList = objectToJSON.writeJSON(battleList);
//		initiator.setBattleList(battleList);
//		String defList = new String(defender.getBattleList());
//		defList = defList + String.valueOf(newBattle.getBattleId());
//		System.out.println(defList);
//		defender.setBattleList(battleList);
//		battleList = objectToJSON.writeJSON(battleList);
		Results newResult = new Results();
		newResult.setResultId(newBattle.getBattleId());
		newResult.setRoundCount(1);
		newResult = resultRepository.save(newResult);
		newBattle.setResult(newResult);
		
		return battleRepository.save(newBattle);
	}

	@PostMapping(value="/chooseChi",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle useChiMove(@RequestBody Battle battleInfo) {
		String type = "chi";
		Moveset moveset = userRepository.getById(battleInfo.getAttacker()).getMoveset();
		int playerChoice = moveset.getChiMove().getcMoveId();
		battleInfo = round(battleInfo,type,playerChoice);
		System.out.println("********\nCHI CHOICE: "+ battleInfo.toString() +  "\n********"); // NUMBER OF ROUNDS INCORRECT?
		System.out.println("Battle #: " + battleInfo.getBattleId() + " CHI - Attacker HP: " + battleInfo.getAttackerHP());
		System.out.println("Battle #: " + battleInfo.getBattleId() + " CHI - Defender HP: " + battleInfo.getDefenderHP());
		
		return battleInfo;
	}
	
	@PostMapping(value="/chooseKen",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle useKenMove(@RequestBody Battle battleInfo) {
		String type = "ken";
		Moveset moveset = userRepository.getById(battleInfo.getAttacker()).getMoveset();
		int playerChoice = moveset.getKenMove().getkMoveId();
		battleInfo = round(battleInfo,type,playerChoice);
		System.out.println("********\nKEN CHOICE: "+ battleInfo.toString() +  "\n********"); // NUMBER OF ROUNDS INCORRECT?
		System.out.println("Battle #: " + battleInfo.getBattleId() + " KEN - Attacker HP: " + battleInfo.getAttackerHP());
		System.out.println("Battle #: " + battleInfo.getBattleId() + " KEN - Defender HP: " + battleInfo.getDefenderHP());
		
		return battleInfo;
	}
	
	@PostMapping(value="/chooseSei",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle useSeiMove(@RequestBody Battle battleInfo) {
		String type = "sei";
		Moveset moveset = userRepository.getById(battleInfo.getAttacker()).getMoveset();
		int playerChoice = moveset.getSeiMove().getsMoveId();
		battleInfo = round(battleInfo,type,playerChoice);
		System.out.println("********\nSEI CHOICE: "+ battleInfo.toString() +  "\n********"); // NUMBER OF ROUNDS INCORRECT?
		System.out.println("Battle #: " + battleInfo.getBattleId() + " SEI - Attacker HP: " + battleInfo.getAttackerHP());
		System.out.println("Battle #: " + battleInfo.getBattleId() + " SEI - Defender HP: " + battleInfo.getDefenderHP());
		
		return battleInfo;
	}
	
	@PostMapping(value="/chooseSurprise",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle useSurpriseMove(@RequestBody Battle battleInfo) {
		String type = "surprise";
		Moveset moveset = userRepository.getById(battleInfo.getAttacker()).getMoveset();
		int playerChoice = moveset.getSurpriseMove().getpMoveId();
		battleInfo = round(battleInfo,type,playerChoice);
		System.out.println("********\nSURPRISE CHOICE: "+ battleInfo.toString() +  "\n********"); // NUMBER OF ROUNDS INCORRECT?
		System.out.println("Battle #: " + battleInfo.getBattleId() + " SURPRISE - Attacker HP: " + battleInfo.getAttackerHP());
		System.out.println("Battle #: " + battleInfo.getBattleId() + " SURPRISE - Defender HP: " + battleInfo.getDefenderHP());
		
		return battleInfo;
	}
	
	@GetMapping(value="/round",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Battle round(Battle battle, String type, int playerChoice) {
		Rounds newRound = new Rounds();
		Results currentResult = resultRepository.findById(battle.getBattleId());
		newRound.setRoundId(currentResult.getRoundCount());
		float damage = 0f;
		int target = 0;
		int initiator = 0;
		// This path is for all odd numbered rounds
		if(newRound.getRoundId() % 2 != 0) {
			Users oddAttacker = userRepository.getById(battle.getAttacker());
			Users oddDefender = userRepository.getById(battle.getDefender());
			newRound.setAttacker(oddAttacker.getUserName());
			newRound.setAttackerAtk(oddAttacker.getUserStats().getAttack());
			// This is the player's Chi choice path
			if(type.equals("chi")) {
				System.out.println("*******\nChi path and Move: " + playerChoice);
				ChiMove tempChi = chiMoveRepository.getById(playerChoice);
				newRound.setAttackerMove(tempChi.getMoveName());
				newRound.setAttackerPon("chi");
			// This is the player's Ken choice path
			} else if(type.equals("ken")) {
				System.out.println("********\nKen path and Move: " + playerChoice); 
				KenMove tempKen = kenMoveRepository.getById(playerChoice);
				tempKen.setkMoveId(playerChoice);
				newRound.setAttackerMove(tempKen.getMoveName());
				newRound.setAttackerPon("ken");
			// This is the player's Sei choice path
			} else if(type.equals("sei")) {
				System.out.println("********\nSei path and Move: " + playerChoice);
				SeiMove tempSei = seiMoveRepository.getById(playerChoice);
				tempSei.setsMoveId(playerChoice);
				newRound.setAttackerMove(tempSei.getMoveName());
				newRound.setAttackerPon("sei"); 
			// This is the player's Surprise choice path
			} else if(type.equals("surprise")) {
				System.out.println("********\nSurprise path and Move: " + playerChoice);
				SurpriseMove tempSurprise = surpriseMoveRepository.getById(playerChoice);
				tempSurprise.setpMoveId(playerChoice);
				battle.setAttackerSurpriseCount(10);
				newRound.setAttackerMove(tempSurprise.getMoveName());
				System.out.println(newRound.getAttackerMove().toString() + " is disabled for 9 rounds!");
				newRound.setAttackerPon("surprise"); 
			}
			// Determine the computer's choice path
			newRound.setDefender(oddDefender.getUserName());
			newRound.setDefenderDef(oddDefender.getUserStats().getDefense());
			// Sets the Moveset flags for the computer
			Moveset defenderMoves = (battleCalculator.determineCPUInput(oddDefender.getMoveset(),battle.getDefenderSurpriseCount()));
			// Determines the Pon for the computer
			newRound.setDefenderPon(battleCalculator.determinePon(defenderMoves)); 
			// Uses the computer's Pon 
			if(newRound.getDefenderPon().equals("chi")) {
				System.out.println(oddDefender.getUserName() + " uses Chi!");
				newRound.setDefenderMove(defenderMoves.getChiMove().getMoveName());
				newRound.setDefenderMoveType("chi");
				System.out.println("Defender uses " + newRound.getDefenderMove().toString() + "!");
			} else if(newRound.getDefenderPon().equals("ken")) {
				System.out.println(oddDefender.getUserName() + " uses Ken!");
				newRound.setDefenderMove(defenderMoves.getKenMove().getMoveName());
				newRound.setDefenderMoveType("ken");
				System.out.println("Defender uses " + newRound.getDefenderMove().toString() + "!");
			} else if(newRound.getDefenderPon().equals("sei")) {
				System.out.println(oddDefender.getUserName() + " uses Sei!");
				newRound.setDefenderMove(defenderMoves.getSeiMove().getMoveName());
				newRound.setDefenderMoveType("sei");
				System.out.println("Defender uses " + newRound.getDefenderMove().toString() + "!");
			} else if(newRound.getDefenderPon().equals("surprise")) {
				System.out.println(oddDefender.getUserName() + " uses Surprise!");
				newRound.setDefenderMove(defenderMoves.getSurpriseMove().getMoveName());
				newRound.setDefenderMoveType("surprise");
				System.out.println("Defender uses " + newRound.getDefenderMove().toString() + "!");
				battle.setDefenderSurpriseCount(10);
				System.out.println(newRound.getDefenderMove().toString() + " is disabled for 9 rounds!");
			}
		// This path is for all even numbered rounds.
		} else {
			Users evenAttacker = userRepository.getById(battle.getDefender());
			Users evenDefender = userRepository.getById(battle.getAttacker());
			newRound.setAttacker(evenAttacker.getUserName());
			newRound.setAttackerAtk(evenAttacker.getUserStats().getAttack());
			// Sets the Moveset flags for the computer
			Moveset attackerMoves = (battleCalculator.determineCPUInput(evenAttacker.getMoveset(),battle.getDefenderSurpriseCount()));
			// Determines the Pon for the computer
			newRound.setAttackerPon(battleCalculator.determinePon(attackerMoves));
			// Uses the computer's Pon 
			if(newRound.getAttackerPon().equals("chi")) {
				System.out.println(evenAttacker.getUserName() + " uses Chi!");
				newRound.setAttackerMove(attackerMoves.getChiMove().getMoveName());
				newRound.setAttackerMoveType("chi");
				System.out.println("Attacker uses " + newRound.getAttackerMove().toString() + "!");
			} else if(newRound.getAttackerPon().equals("ken")) {
				System.out.println(evenAttacker.getUserName() + " uses Ken!");
				newRound.setAttackerMove(attackerMoves.getKenMove().getMoveName());
				newRound.setAttackerMoveType("ken");
				System.out.println("Attacker uses " + newRound.getAttackerMove().toString() + "!");
			} else if(newRound.getAttackerPon().equals("sei")) {
				System.out.println(evenAttacker.getUserName() + " uses Sei!");
				newRound.setAttackerMove(attackerMoves.getSeiMove().getMoveName());
				newRound.setAttackerMoveType("sei");
				System.out.println("Attacker uses " + newRound.getAttackerMove().toString() + "!");
			} else if(newRound.getAttackerPon().equals("surprise")) {
				System.out.println(evenAttacker.getUserName() + " uses Surprise!");
				newRound.setAttackerMove(attackerMoves.getSurpriseMove().getMoveName());
				newRound.setAttackerMoveType("surprise");
				System.out.println("Attacker uses " + newRound.getAttackerMove().toString() + "!");
				battle.setDefenderSurpriseCount(10);
				System.out.println(newRound.getAttackerMove().toString() + " is disabled for 9 rounds!");	
			}
			newRound.setDefender(evenDefender.getUserName());
			newRound.setDefenderDef(evenDefender.getUserStats().getDefense());
			// This is the player's Chi choice path
			if(type.equals("chi")) {
				ChiMove tempChi = new ChiMove();
				System.out.println("********\nChi path and Move: " + playerChoice);
				tempChi.setcMoveId(playerChoice);
				newRound.setDefenderMove(tempChi.getMoveName());
				newRound.setDefenderPon("chi");
			// This is the player's Ken choice path
			} else if(type.equals("ken")) {
				KenMove tempKen = new KenMove();
				System.out.println("********\nKen path and Move: " + playerChoice); 
				tempKen.setkMoveId(playerChoice);
				newRound.setDefenderMove(tempKen.getMoveName());
				newRound.setDefenderPon("ken");
			// This is the player's Sei choice path
			} else if(type.equals("sei")) {
				SeiMove tempSei = new SeiMove();
				System.out.println("********\nSei path and Move: " + playerChoice); 
				tempSei.setsMoveId(playerChoice);
				newRound.setDefenderMove(tempSei.getMoveName());
				newRound.setDefenderPon("sei");
			// This is the player's Surprise choice path
			} else if(type.equals("surprise")) {
				System.out.println("********\nSurprise path and Move: " + playerChoice);
				SurpriseMove tempSurprise = surpriseMoveRepository.getById(playerChoice);
				tempSurprise.setpMoveId(playerChoice);
				battle.setAttackerSurpriseCount(10);
				newRound.setDefenderMove(tempSurprise.getMoveName());
				System.out.println(newRound.getDefenderMove().toString() + " is disabled for 9 rounds!");
				newRound.setDefenderPon("surprise"); 
			}
		}
		// Determine battle formula
		String formula = battleCalculator.determineFormula(newRound.getAttackerPon(),newRound.getDefenderPon());
		// Determine damage for odd numbered rounds (minimum damage is hard coded)
		if(currentResult.getRoundCount() % 2 != 0) {
			damage = battleCalculator.calculateDamage(userRepository.getById(battle.getAttacker()),userRepository.getById(battle.getDefender()),formula,newRound.getAttackerPon());
			System.out.println("Attacker (" + newRound.getAttacker() + ") Pon: " + newRound.getAttackerPon() + " vs Defender (" + newRound.getDefender() + ") Pon: " + newRound.getDefenderPon());
			System.out.println("FORMULA: " + formula);
			currentResult.setFormula(formula);
			if(formula.equals("hangeki") && damage < 0.1f) {
				damage = 0.5f;
			} else if(formula.equals("yatta") && damage < 0.1f) {
				damage = 0.2f;
			} else if(formula.equals("aikodesho") && damage < 0.1f) {
				damage = 0.1f;
			} else if(formula.equals("ojō") && damage < 0.1f) {
				damage = 0f;
			} else if(formula.equals("kaihi") && damage < 0.1f) {
				damage = 0.1f;
			}
			// If the formula comes back as hangeki, damage is done to the human player instead of the computer.
			if(formula.equals("hangeki")) {
				target = battle.getAttacker();
				battle.setAttackerHP(battle.getAttackerHP() - damage);
			// All of the other formulas deal damage to the computer player
			} else {
				target = battle.getDefender();
				battle.setDefenderHP(battle.getDefenderHP() - damage);
			} 
		// Determine damage for even numbered rounds (minimum damage is hard coded)
		} else { 
			damage = battleCalculator.calculateDamage(userRepository.getById(battle.getDefender()),userRepository.getById(battle.getAttacker()),formula,newRound.getAttackerPon());
			System.out.println("Attacker (" + newRound.getAttacker() + ") Pon: " + newRound.getAttackerPon() + " vs Defender (" + newRound.getDefender() + ") Pon: " + newRound.getDefenderPon());
			System.out.println("FORMULA: " + formula);
			currentResult.setFormula(formula);
			if(formula.equals("hangeki") && damage < 0.1f) {
				damage = 0.5f;
			} else if(formula.equals("yatta") && damage < 0.1f) {
				damage = 0.2f;
			} else if(formula.equals("aikodesho") && damage < 0.1f) {
				damage = 0.1f;
			} else if(formula.equals("ojō") && damage < 0.1f) {
				damage = 0f;
			} else if(formula.equals("kaihi") && damage < 0.1f) {
				damage = 0.1f;
			}
			// If the formula comes back as hangeki, damage is done to the computer player instead of the human.
			if(formula.equals("hangeki")) {
				target = battle.getDefender();
				initiator = battle.getAttacker();
				battle.setDefenderHP(battle.getDefenderHP() - damage);
			// All of the other formulas deal damage to the human player
			} else {
				target = battle.getAttacker();
				initiator = battle.getDefender();
				battle.setAttackerHP(battle.getAttackerHP() - damage);
			}
		}
		// Displays HP before returning battle object (delete this once battles are working correctly)
		System.out.println("--Attacker HP is now: " + battle.getAttackerHP());
		System.out.println("--Defender HP is now: " + battle.getDefenderHP());
		
		// If both player and computer are still above 0 HP, this branch runs
		if(battle.getDefenderHP() > 0f && battle.getAttackerHP() > 0f) {
			// Shows how much damage was done during the round
			newRound.setDmgCalculated(damage);
			// Sets the round count as one higher than the previous so the next round commences
			currentResult.setRoundCount((currentResult.getRoundCount() + 1));
		// If either player or computer equal 0 or are below 0, then this is the final running branch setting winner and ending the battle
		} else if (battle.getDefenderHP() <= 0f || battle.getAttackerHP() <= 0f) {
			// Shows how much damage was done during the round
			newRound.setDmgCalculated(damage);
			System.out.println("Damage: " + newRound.getDmgCalculated());
			// Sets the loser
			newRound.setFirstToZero(userRepository.findById(target).getUserName());
			System.out.println("First to Zero: " + newRound.getFirstToZero());
			// Sets the winner
			currentResult.setWinner(userRepository.findById(initiator).getUserName());
			currentResult.setFormula("SHŪRYŌ"); // 終了
		}
		if(battle.getDefenderSurpriseCount() != 0) {
			int count = battle.getDefenderSurpriseCount();
			count--;
			battle.setDefenderSurpriseCount(count);
		}
		if(battle.getAttackerSurpriseCount() != 0) {
			int count = battle.getAttackerSurpriseCount();
			count--;
			battle.setAttackerSurpriseCount(count);
		}
		resultRepository.save(currentResult);
		battle.setResult(currentResult);
		
		return battleRepository.save(battle);
	}
}