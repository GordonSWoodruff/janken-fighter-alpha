package com.jankenfighteralpha.service;

import java.io.IOException;
import java.io.InvalidObjectException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jankenfighteralpha.entity.BattleList;
import com.jankenfighteralpha.entity.Rounds;

@Service
public class ObjectToJson {
	
	public String writeJSON(Rounds tempRound) {
		Rounds rdConvert = new Rounds();
		ObjectMapper Obj = new ObjectMapper();
		try {
			String jsonStr = Obj.writeValueAsString(rdConvert);
			System.out.println(jsonStr);
			return jsonStr;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String writeJSON(String battleList) {
		BattleList battleConvert = new BattleList();
		ObjectMapper Obj = new ObjectMapper();
		try {
			String jsonStr = Obj.writeValueAsString(battleConvert);
			System.out.println(jsonStr);
			return jsonStr;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
