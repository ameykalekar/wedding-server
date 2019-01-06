package com.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.Notification;
import com.main.repository.NotificationRepository;
import com.main.vo.LoginVO;
import com.main.vo.NotificationVO;

@RestController
@CrossOrigin(origins={"http://localhost:4200"})
public class NotificationController {
	
	
	@Autowired
	private NotificationRepository notificationRepo;
	
	

	@PostMapping("/api/viewnotification")
	public NotificationVO viewNotification(HttpServletRequest request){
		String username = ((LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO)).getUsername();
		Notification notification = notificationRepo.findOneByusername(username);
		NotificationVO vo = new NotificationVO();
		System.out.println(notification);
		if(notification!=null){
			vo.setStatuschange(notification.isStatusChange()+"");
			vo.setTicketassignment(notification.isTicketAssignment()+"");
			vo.setTicketcreation(notification.isTicketCreation()+"");
		}
		return vo;
	}
	
	
	@PostMapping("/api/updatenotification")
	public NotificationVO update(@RequestBody NotificationVO notificationvo,HttpServletRequest request){
		
		String username = ((LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO)).getUsername();
		
		Notification currentNotification = notificationRepo.findOneByusername(username);
		
		if(currentNotification!=null){
			System.out.println(notificationvo);
			currentNotification.setStatusChange(Boolean.valueOf(notificationvo.getStatuschange()));
			currentNotification.setTicketCreation(Boolean.valueOf(notificationvo.getTicketcreation()));
			currentNotification.setTicketAssignment(Boolean.valueOf(notificationvo.getTicketassignment()));
		}else{
			currentNotification = new Notification();
			currentNotification.setStatusChange(Boolean.valueOf(notificationvo.getStatuschange()));
			currentNotification.setTicketCreation(Boolean.valueOf(notificationvo.getTicketcreation()));
			currentNotification.setTicketAssignment(Boolean.valueOf(notificationvo.getTicketassignment()));
			currentNotification.setUsername(username);
		}
		System.out.println(currentNotification);
		notificationRepo.save(currentNotification);
		
		return notificationvo;
	}

}
