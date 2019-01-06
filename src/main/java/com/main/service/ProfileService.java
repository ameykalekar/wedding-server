package com.main.service;

import org.springframework.stereotype.Service;

import com.main.vo.ProfileVo;


@Service
public class ProfileService {

	
	public ProfileVo getProfile(String id){
		ProfileVo profileVo = new ProfileVo();
		
		profileVo.setFirstName("Suraj");
		profileVo.setLastName("Patil");
		profileVo.setPlaceOfBirth("pune");
		profileVo.setDateOfBirth("28/08/1987");
		profileVo.setAnnualIncome("8");
		return profileVo;
	}
}
