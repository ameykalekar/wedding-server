package com.main.service;

import java.io.FileOutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
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
		
		try {
			if(profileVo.getPicture1()!=null){
			FileOutputStream imageOutFile = new FileOutputStream(
					"C:\\Users\\amayk\\images\\test.jpg");
			imageOutFile.write(Base64.decodeBase64(profileVo.getPicture1()));

			imageOutFile.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repository.save(profileVo.getEntity());
		
	}
}
