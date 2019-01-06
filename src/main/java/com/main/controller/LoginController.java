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
	
	@PostMapping("/api/login")
	public ResponseEntity<Login> save(@RequestBody Login login){ 
		
		System.out.println(login.getUsername());
		loginRepository.save(login);
		
		Optional<Login> loginOptional= loginRepository.findById(login.getUsername());
		System.out.println("Returning argument"+loginOptional.get());
		if(loginOptional.isPresent())
		{
		
		
		return new ResponseEntity<Login>(loginOptional.get(), HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping("/api/loginAll")
	public List<Login> get(){ 
		return loginRepository.findAll();
	}
	
	@RequestMapping("/api/logout")
	public String logout(HttpServletRequest request){ 
		System.out.println("Logging out");
		request.getSession().invalidate();
		return "success";
	}
	
	
	
	@RequestMapping("/api/validelogin")
	public ResponseEntity<LoginVO> validelogin (@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request){ 
		
		System.out.println("session id is " +  request.getSession().getId());
		String hashedPassword = passwordHelper.hashPassword(password);
		Optional<Login> login= loginRepository.findById(username);
		if (login.isPresent() && hashedPassword.equals(login.get().getPassword())) {
			LoginVO loginvo = new LoginVO();
			loginvo.setUsername(login.get().getUsername());
			loginvo.setRole(login.get().getRole());
			loginvo.setFunctions(roleFunctionService.getFunctionsForRole(login.get().getRole()));
			loginvo.setCompanyId(login.get().getCompanyId());
			loginvo.setUserinfo( (usercontroller.getUser(loginvo.getUsername())));
			request.getSession().setAttribute(ApplicationConstants.USER_INFO, loginvo);
			
			return new ResponseEntity<>(loginvo, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<>(HttpStatus.OK);
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
