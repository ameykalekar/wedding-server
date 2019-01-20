package com.main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.ProfileEntity;
import com.main.app.constants.ApplicationConstants;
import com.main.entity.Login;
import com.main.service.ProfileService;
import com.main.vo.PaymentRequest;
import com.main.vo.ProfileVo;

@RestController
public class ProfileController {


	@Autowired
	private ProfileService profileService;
	
	
	@RequestMapping("/api/viewprofile/{id}")
	public ResponseEntity<ProfileVo> getViewProfile(@PathVariable("id") String id,HttpServletRequest request){
		
		return new ResponseEntity<ProfileVo>(profileService.getProfile(id),HttpStatus.OK);
	}
	
	
	@RequestMapping("/api/profile/{id}")
	public ResponseEntity<ProfileVo> getProfile(@PathVariable("id") String id,HttpServletRequest request){
		
		Login login = getUserLoginFromSession(request);
		if(login!=null && login.getUserid().equals(id)){
		return new ResponseEntity<ProfileVo>(profileService.getProfile(id),HttpStatus.OK);
		}else{
			//TODO: TO pass view to show to other people.
			return new ResponseEntity<ProfileVo>(profileService.getProfile(id),HttpStatus.OK);	
		}
	}
	
	@GetMapping(value = "/api/profile/getProfileImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable("id") String id,HttpServletRequest request) throws IOException {
		File directory = new File(String.valueOf("C:\\Users\\amayk\\images\\"+id));
		
		if(directory.exists()){
			FileInputStream imageOutFile = new FileInputStream("C:\\Users\\amayk\\images\\"+id+"\\1.jpg");
			byte[] result = IOUtils.toByteArray(imageOutFile);
			imageOutFile.close();
			return result;
		}else{
			FileInputStream imageOutFile = new FileInputStream("C:\\Users\\amayk\\images\\default\\1.jpg");
			byte[] result = IOUtils.toByteArray(imageOutFile);
			imageOutFile.close();
			return result;
		}
			 
			
	}

	private Login getUserLoginFromSession(HttpServletRequest request) {
		Function<HttpSession, Optional<HttpSession>> optionalSession = (session) ->  session!=null ? Optional.of(session) : Optional.empty();
				
		 Login login = optionalSession.andThen((optSession) -> {
			if(optSession.get().getAttribute(ApplicationConstants.USER_INFO)!=null){
				return (Login)optSession.get().getAttribute(ApplicationConstants.USER_INFO);
			} else{
				return null;
			}
		 }).apply(request.getSession(false));
		return login;
	}
	
	@PostMapping("/api/profile")
	public ResponseEntity<ProfileVo> insertProfile(@RequestBody ProfileVo profileVo,HttpServletRequest request){
		Login login = getUserLoginFromSession(request);
		
		if(login!=null && login.getUserid().equals(profileVo.getId())){
		System.out.println(profileVo);
		profileService.insertProfile(profileVo);
		return new ResponseEntity<ProfileVo>(profileVo,HttpStatus.OK);
		}else{
			return new ResponseEntity<ProfileVo>(profileVo,HttpStatus.BAD_REQUEST);	
		}
	}

	@PostMapping("/api/search")
	public ResponseEntity<List<ProfileEntity>> searchProfile(@RequestBody ProfileVo profileVo){
		System.out.println(profileVo);
		List<ProfileEntity> profiles=profileService.searchProfile(profileVo);
		return new ResponseEntity<List<ProfileEntity>>(profiles,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/api/gethash")
	public @ResponseBody String getImage(@RequestBody PaymentRequest paymentRequest,HttpServletRequest request) throws IOException {
					 
			return null;
	}
	
	
}
