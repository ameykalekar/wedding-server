package com.main.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.Login;
import com.main.entity.User;
import com.main.repository.UserRepository;
import com.main.service.Mail;
import com.main.service.NotificationService;
import com.main.service.PasswordHelper;
import com.main.vo.LoginVO;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class UserController {

	@Autowired
	PasswordHelper passwordhelper;

	@Autowired
	NotificationService notificationservice;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LoginController logincontroller;

	@RequestMapping("/api/GetAllUsers")
	public List<User> get() {
		return userRepository.findAll();
	}
	
	@RequestMapping("/api/GetUsersByCompanyId")
	public List<User> getUsersByCompanyId(HttpServletRequest request){
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		return userRepository.findByCompanyidAndType(loginvo.getCompanyId(), "FR");
	}
	
	@RequestMapping("/api/GetUser")
	public User getUser(String username) {
		return userRepository.findById(username).get();
	}


	public Boolean isUserPresent(String username)
	{
		
		
		if(userRepository.existsById(username))
		{
		return true;
		}else
		{
			return false;
		}
		
		

	}
	
	@PostMapping("/api/SaveUser")
	public ResponseEntity<User> save(@RequestBody User user) {
		
		
		if(isUserPresent(user.getUsername()))
		{
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}else
		{
	
		user.setActive("Y");
		User t = userRepository.save(user);

		String password = passwordhelper.randomAlphaNumeric(6);
		
		System.out.println("Geenerate Password" +password);

		Login login = new Login(user.getUsername(), passwordhelper.hashPassword(password), user.getType(),
				user.getCompanyid(), "Y");
		logincontroller.save(login);
		
		System.out.println("sending email");
		Mail mail = new Mail();
		mail.setMailFrom("fieldservedevpune@gmail.com");
		mail.setMailTo(user.getUsername());
		mail.setMailSubject("Subject - Welcome to FieldServe");
		mail.setTemplateName("login.vm");
		mail.setMailPassWord("Unlock@66");
		Map<String, Object> velocityContext = new HashedMap();
		
		
		  velocityContext.put("firstName", user.getFirstname());
		  velocityContext.put("lastName", user.getLastname());
		  velocityContext.put("username", user.getUsername());
		  velocityContext.put("password", password);
		  mail.setValues(velocityContext);
 //notificationservice.sendNotification(mail);
		password = null;
		return new ResponseEntity<User>(t, HttpStatus.OK);
		}
		

	}

}
