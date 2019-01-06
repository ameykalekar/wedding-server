package com.main.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.service.ProfileService;
import com.main.vo.ProfileVo;

@RestController
public class ProfileController {


	@Autowired
	private ProfileService profileService;
	
	
	
	@RequestMapping("/api/profile/{id}")
	public ResponseEntity<ProfileVo> getProfile(@PathVariable("id") String id){
		
		System.out.println("profile id ::" + id);
		
		return new ResponseEntity<ProfileVo>(profileService.getProfile(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/api/profile")
	public ResponseEntity<ProfileVo> insertProfile(@RequestBody ProfileVo profileVo){
		System.out.println(profileVo);
		profileService.insertProfile(profileVo);
		return new ResponseEntity<ProfileVo>(profileVo,HttpStatus.OK);
	}
	
	
}
