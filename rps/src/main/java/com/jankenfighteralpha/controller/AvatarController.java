package com.jankenfighteralpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jankenfighteralpha.entity.Avatar;
import com.jankenfighteralpha.entity.Users;
import com.jankenfighteralpha.repository.AvatarRepository;

@CrossOrigin
@RestController
public class AvatarController {
	@Autowired
	private AvatarRepository avatarRepository;

	@GetMapping(value="/avatar",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Avatar avatarById(int avatarId) {
		Avatar tempAvatar = avatarRepository.findById(avatarId);
		return tempAvatar;
	}
			
	@PostMapping(value="/chooseAvatar",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void changeAvatar(@RequestBody Users user) {
		Avatar tempAvatar = user.getAvatar();
		avatarRepository.chooseArms(tempAvatar.getArmsPart());
		avatarRepository.chooseHead(tempAvatar.getHeadPart());
		avatarRepository.chooseLegs(tempAvatar.getLegsPart());
		avatarRepository.chooseTorso(tempAvatar.getTorsoPart());
		avatarRepository.chooseWaist(tempAvatar.getWaistPart());
	}
}
