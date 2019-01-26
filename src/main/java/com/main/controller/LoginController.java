package com.main.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.Login;
import com.main.repository.LoginRepository;
import com.main.repository.UserRepository;
import com.main.service.PasswordHelper;
import com.main.service.RoleFunctionService;
import com.main.vo.ChangePasswordVo;
import com.main.vo.LoginVO;

@RestController
@CrossOrigin(origins={"*"})
public class LoginController {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	RoleFunctionService roleFunctionService;
	
	@Autowired
	PasswordHelper passwordHelper;
	
	@Autowired
	UserController usercontroller;
	
	
	@RequestMapping("/api/logout")
	public  ResponseEntity<String> logout(HttpServletRequest request){ 
		System.out.println("Logging out");
		request.getSession().invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	static class User {
		private String userid;
		private String password;
		
		public String getUserid() {
			return userid;
		}
		public void setUserid(String username) {
			this.userid = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/api/login")
	public ResponseEntity<LoginVO> validelogin (@RequestBody User user,HttpServletRequest request){ 
		
		Optional<com.main.entity.User> savedUser = userRepository.findById(user.getUserid());
		String hashedPassword = passwordHelper.hashPassword(user.getPassword());
		if(savedUser.isPresent() && hashedPassword.equals(savedUser.get().getPassword())){
			request.getSession().setAttribute(ApplicationConstants.USER_INFO, savedUser.get());
			return new ResponseEntity<>(HttpStatus.OK);	
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
	
	
	@PostMapping("/api/ChangePassword")
	public ResponseEntity<ChangePasswordVo> changePassword(HttpServletRequest request,@RequestBody ChangePasswordVo user)
	{
		System.out.println(user);
		LoginVO loginvosession = (LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		Login login = loginRepository.findById(loginvosession.getUsername()).get();
		String hashedPassword = passwordHelper.hashPassword(user.getNewpassword());
		login.setPassword(hashedPassword);
		loginRepository.save(login);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
