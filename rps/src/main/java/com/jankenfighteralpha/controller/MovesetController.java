package com.jankenfighteralpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jankenfighteralpha.entity.Moveset;
import com.jankenfighteralpha.entity.Users;
import com.jankenfighteralpha.repository.MoveRepository;

@CrossOrigin
@RestController
public class MovesetController {
	@Autowired
	MoveRepository moveRepository;
	
	@GetMapping(value="/moveset",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Moveset movesetById(int movesetId) {
		Moveset tempMoveset = moveRepository.findById(movesetId);
		return tempMoveset;
	}
	
	@PostMapping(value="/chooseMoveset",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void changeMoveset(@RequestBody Users user) {
//		Moveset tempMoveset = user.getMoveset();
//		moveRepository.chooseChi(tempMoveset.getChiMove());
//		moveRepository.chooseKen(tempMoveset.getKenMove());
//		moveRepository.chooseSei(tempMoveset.getSeiMove());
//		moveRepository.chooseSurprise(tempMoveset.getSurpriseMove());
	}
}
