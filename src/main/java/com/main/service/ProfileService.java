package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.ProfileEntity;
import com.main.repository.ProfileRepository;
import com.main.vo.ProfileVo;


@Service
public class ProfileService {

	@Autowired
	ProfileRepository repository;
	
	public ProfileVo getProfile(String id){
		/*ProfileVo profileVo = new ProfileVo();
		
		profileVo.setFirstName("Suraj");
		profileVo.setLastName("Patil");
		profileVo.setPlaceOfBirth("pune");
		profileVo.setDateOfBirth("28/08/1987");
		profileVo.setAnnualIncome("8");*/
		ProfileEntity entity = repository.findById(Long.valueOf(id)).get();
		return new ProfileVo().getVo(entity);
	}
	
	public void insertProfile(ProfileVo profileVo){
		
		repository.save(profileVo.getEntity());
		
	}
}
