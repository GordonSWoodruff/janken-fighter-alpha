package com.jankenfighteralpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jankenfighteralpha.entity.Avatar;
import com.jankenfighteralpha.entity.Moveset;
import com.jankenfighteralpha.entity.Users;
import com.jankenfighteralpha.repository.AvatarRepository;
import com.jankenfighteralpha.repository.MoveRepository;
import com.jankenfighteralpha.repository.UserRepository;
import com.jankenfighteralpha.repository.UserStatsRepository;

@Service
public class RegistrationService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserStatsRepository userStatsRepository;
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	MoveRepository moveRepository;
	@Autowired
	SendMail userSend;
	
	public void registerUser(Users user) {
		Avatar tempAvatar = new Avatar();
//		tempAvatar.setAccesory(avatarRepository.getById(999).getAccessory());
//		tempAvatar.setBackAccesory(avatarRepository.getById(999).getBackAccessory());
		tempAvatar.setArmsPart(avatarRepository.getById(999).getArmsPart());
		tempAvatar.setBackArmsPart(avatarRepository.getById(999).getBackArmsPart());
		tempAvatar.setHeadPart(avatarRepository.getById(999).getHeadPart());
		tempAvatar.setBackHeadPart(avatarRepository.getById(999).getBackHeadPart());
		tempAvatar.setLegsPart(avatarRepository.getById(999).getLegsPart());
		tempAvatar.setBackLegsPart(avatarRepository.getById(999).getBackLegsPart());
		tempAvatar.setTorsoPart(avatarRepository.getById(999).getTorsoPart());
		tempAvatar.setBackTorsoPart(avatarRepository.getById(999).getBackTorsoPart());
		tempAvatar.setWaistPart(avatarRepository.getById(999).getWaistPart());
		tempAvatar.setBackWaistPart(avatarRepository.getById(999).getBackWaistPart());
		user.setAvatar(tempAvatar);
		avatarRepository.save(tempAvatar);
		Moveset tempMoveset = new Moveset();
		tempMoveset.setChiMove(moveRepository.getById(999).getChiMove());
		tempMoveset.setKenMove(moveRepository.getById(999).getKenMove());
		tempMoveset.setSeiMove(moveRepository.getById(999).getSeiMove());
		tempMoveset.setSurpriseMove(moveRepository.getById(999).getSurpriseMove());
		user.setMoveset(tempMoveset);
		moveRepository.save(tempMoveset);
		userStatsRepository.save(user.getUserStats());
		user = userRepository.save(user);
		userSend.send(user.getEmail(), "Janken Fighter Registration Complete", "Congrats, " + user.getUserName() + "!"
				+ "\nYour account was successfully created! Prepare yourself for battles of epic proportions...");
	}
}
