package com.main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateUtils;
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

import com.main.app.constants.ApplicationConstants;
import com.main.entity.DesiredProfile;
import com.main.entity.PaymentResponse;
import com.main.entity.ProfileEntity;
import com.main.entity.ProfileVisibility;
import com.main.entity.User;
import com.main.repository.DesireProfileRepository;
import com.main.repository.ProfileVisibilityRepository;
import com.main.repository.UserRepository;
import com.main.service.NotificationService;
import com.main.service.PasswordHelper;
import com.main.service.PaymentService;
import com.main.service.ProfileService;
import com.main.service.SmsService;
import com.main.vo.DesiredProfileVo;
import com.main.vo.PaymentRequest;
import com.main.vo.ProfileVo;

@RestController
public class ProfileController {

	@Autowired
	PaymentService paymentService;
	@Autowired
	private ProfileService profileService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NotificationService notificationService;


	@Autowired
	private SmsService smsService;

	@Autowired
	PasswordHelper passwordhelper;

	@RequestMapping("/api/viewprofile/{id}")
	public ResponseEntity<ProfileVo> getViewProfile(@PathVariable("id") String id, HttpServletRequest request) {
		User login = getUserLoginFromSession(request);
		ProfileVo vo = null;
		if (login == null || login.getPaymentExpiryDte() == null
				|| login.getPaymentExpiryDte().compareTo(new Date()) < 0) {
			// show masked values
			vo = profileService.getProfile(id);
			vo.maskProfile();
		} else {
			// show full values
			vo = profileService.getProfile(id);
		}
		return new ResponseEntity<ProfileVo>(vo, HttpStatus.OK);
	}

	@RequestMapping("/api/profile/view/{id}")
	public ResponseEntity<ProfileVo> getProfile(@PathVariable("id") String id, HttpServletRequest request) {

		User login = getUserLoginFromSession(request);
		if (login != null && login.getUsername().equals(id)) {
			return new ResponseEntity<ProfileVo>(profileService.findByUsername(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<ProfileVo>(profileService.getProfile(id), HttpStatus.OK);
		}
	}
	
	
	@RequestMapping("/api/profile/{id}")
	public ResponseEntity<ProfileVo> getLoggedInProfile(@PathVariable("id") String id, HttpServletRequest request) {

		User login = getUserLoginFromSession(request);
		if (login != null && login.getUsername().equals(id)) {
			return new ResponseEntity<ProfileVo>(profileService.findByUsername(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<ProfileVo>(new ProfileVo(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/api/profile/getProfileImage/{id}/{pic}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable("id") String id,@PathVariable("pic") String picnumber, HttpServletRequest request) throws IOException {
		File directory = new File(String.valueOf("C:\\Users\\amayk\\images\\" + id));

		if (directory.exists()) {
			FileInputStream imageOutFile = new FileInputStream("C:\\Users\\amayk\\images\\" + id + "\\"+picnumber+".jpg");
			byte[] result = IOUtils.toByteArray(imageOutFile);
			imageOutFile.close();
			return result;
		} else {
			FileInputStream imageOutFile = new FileInputStream("C:\\Users\\amayk\\images\\default\\1.jpg");
			byte[] result = IOUtils.toByteArray(imageOutFile);
			imageOutFile.close();
			return result;
		}

	}

	private User getUserLoginFromSession(HttpServletRequest request) {
		Function<HttpSession, Optional<HttpSession>> optionalSession = (session) -> session != null
				? Optional.of(session) : Optional.empty();

		User login = optionalSession.andThen((optSession) -> {
			if (optSession.isPresent() && optSession.get().getAttribute(ApplicationConstants.USER_INFO) != null) {
				return (User) optSession.get().getAttribute(ApplicationConstants.USER_INFO);
			} else {
				return null;
			}
		}).apply(request.getSession(false));
		return login;
	}

	@PostMapping("/api/profile")
	public ResponseEntity<ProfileVo> insertProfile(@RequestBody ProfileVo profileVo, HttpServletRequest request) {
		User login = getUserLoginFromSession(request);
		
		if (login != null && login.getUsername().equals(String.valueOf(profileVo.getUserName()))) {
			System.out.println(profileVo);
			profileVo.setUserName(login.getUsername());
			profileService.insertProfile(profileVo);
			return new ResponseEntity<ProfileVo>(profileVo, HttpStatus.OK);
		} else {
			return new ResponseEntity<ProfileVo>(profileVo, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/api/simple/profile")
	public ResponseEntity<ProfileVo> insertSimpleProfile(@RequestBody ProfileVo profileVo) {
		
		ProfileVo vo = profileService.findByEmail(profileVo.getEmail());
		
		if(vo==null){
			if(profileVo.getEmail().isEmpty())
			{
				profileVo.setUserName(profileVo.getContactNumber());
			}else
			{
				profileVo.setUserName(profileVo.getEmail());
			}

			vo = profileService.insertProfile(profileVo);
			generateUser(profileVo.getUserName(), "user");

			return new ResponseEntity<ProfileVo>(profileVo, HttpStatus.OK);
		}else{
			ProfileVo vo1= null;
			return new ResponseEntity<ProfileVo>(vo1, HttpStatus.OK);
		}
	}
	
	
	private void generateUser(String userName,String type )
	{
		User user = new User();
		
		user.setUsername(userName);
		user.setActive(true + "");
		user.setType(type);

		String password = getRandomPassword();
		System.out.println(user.getUsername() + "@" + password);
		user.setPassword(passwordhelper.hashPassword(password));

		user.setPaymentExpiryDte(DateUtils.addDays(new Date(), -2));
		User savedUser = userRepository.save(user);

		// notificationService.sendNotification(notificationService.buildEmailContent(savedUser,
		// password));

	}
	
	@PostMapping("/api/paymentresponse")
	public ResponseEntity<PaymentResponse> insertPaymentResponse(@RequestBody PaymentResponse paymentResponse) {
		paymentService.insertPayment(paymentResponse);
		return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
	}

	private String getRandomPassword() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		return (generatedString);
	}

	@PostMapping("/api/search")
	public ResponseEntity<List<ProfileEntity>> searchProfile(@RequestBody ProfileVo profileVo) {
		System.out.println(profileVo);
		List<ProfileEntity> profiles = profileService.searchProfile(profileVo);
		return new ResponseEntity<List<ProfileEntity>>(profiles, HttpStatus.OK);
	}

	@PostMapping(value = "/api/gethash")
	public @ResponseBody ResponseEntity<PaymentRequest> getImage(@RequestBody PaymentRequest paymentRequest,
			HttpServletRequest request) throws IOException {

		PaymentRequest p = profileService.generateHash(paymentRequest);

		return new ResponseEntity<PaymentRequest>(p, HttpStatus.OK);

	}

	
	@Autowired 
	DesireProfileRepository desiredProfileRepo;
	
	@PostMapping(value="/api/updateDesired")
	public @ResponseBody ResponseEntity<DesiredProfileVo> updateDesiredProfile(@RequestBody DesiredProfileVo desiredProfile
			,HttpServletRequest request){
		
		User login = getUserLoginFromSession(request);
		
		DesiredProfile desiredProfileEntity = desiredProfile.getEntity();
		desiredProfileEntity.setId(login.getUsername());
		desiredProfileRepo.deleteById(login.getUsername());
		desiredProfileRepo.save(desiredProfileEntity);
		
		return new ResponseEntity<DesiredProfileVo>(desiredProfile, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/api/profile") 
	public @ResponseBody ResponseEntity<DesiredProfileVo> getDesiredProfile(HttpServletRequest request){
		User login = getUserLoginFromSession(request);	
		DesiredProfile profile = desiredProfileRepo.getOne(login.getUsername());
		if(profile==null){
			return new ResponseEntity<DesiredProfileVo>(new DesiredProfileVo(),HttpStatus.OK);
		}else{
			return new ResponseEntity<DesiredProfileVo>(DesiredProfileVo.getVo(profile),HttpStatus.OK);
		}
		
	}
	
	@Autowired
	private ProfileVisibilityRepository profileVisibilityRepo;
	@GetMapping(value="/api/visibility/update/{visibility}")
	public @ResponseBody ResponseEntity<HttpStatus> updateVisibility(@PathVariable("visibility") String visibility,HttpServletRequest request){
		User login = getUserLoginFromSession(request);
		
		Optional<ProfileVisibility> optVisibility  = profileVisibilityRepo.findOneByUser(login);

		if(optVisibility.isPresent()){
			optVisibility.get().setVisibleTo(visibility);
			profileVisibilityRepo.save(optVisibility.get());
		}else{
			ProfileVisibility pvisibility = new ProfileVisibility();
			pvisibility.setUser(userRepository.getOne(login.getUsername()));
			pvisibility.setVisibleTo(visibility);
			profileVisibilityRepo.save(pvisibility);	
		}  

		System.out.println(profileVisibilityRepo.findOneByUser(login));
		return new ResponseEntity<>(HttpStatus.OK);
	} 

	@GetMapping(value="/api/visibility/get")
	public @ResponseBody ResponseEntity<ProfileVisibility> getVisibility(String visibility,HttpServletRequest request){
		User login = getUserLoginFromSession(request);
		Optional<ProfileVisibility> optVisibility  = profileVisibilityRepo.findOneByUser(login);
		ProfileVisibility pvisibility = null;
		if(!optVisibility.isPresent()){
			pvisibility = new ProfileVisibility();
			pvisibility.setUser(userRepository.getOne(login.getUsername()));
			pvisibility.setVisibleTo("all");
			pvisibility = profileVisibilityRepo.save(pvisibility);
			pvisibility.setUser(null); 
		}else{
			pvisibility = optVisibility.get();
		}
		return new ResponseEntity<ProfileVisibility>(pvisibility,HttpStatus.OK);
	}
	
}
