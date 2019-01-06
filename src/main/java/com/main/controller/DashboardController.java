package com.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.enums.*;
import com.main.app.constants.ApplicationConstants;
import com.main.entity.User;
import com.main.repository.CustomerRepository;
import com.main.repository.TicketRepository;
import com.main.repository.UserRepository;
import com.main.utility.Utility;
import com.main.vo.AppStatus;
import com.main.vo.LoginVO;

@RestController
public class DashboardController {

	@Autowired
	Utility utility;

	@Autowired
	protected TicketRepository ticketRepository;

	@Autowired
	protected UserRepository usRepository;

	@Autowired
	protected UserRepository userRepository;

	@Autowired 
	HttpServletRequest httprequest;

	@RequestMapping("/api/status")
	public AppStatus getStatus() {
		AppStatus status = new AppStatus();
		
		LoginVO user=(LoginVO)httprequest.getSession().getAttribute(ApplicationConstants.USER_INFO);
		 
		 long openTickets ;
					long totalTickets; 
					long inProgressTickets ;
					long countCustomers ;
					long countUsers ;
		if (utility.nonNUll.and(utility.isAdmin.or(utility.isCleintAdmin)).test(user)) {
			 openTickets = ticketRepository.countByCompanyidAndStatus(user.getCompanyId(), TicketStatus.SUBMITTED.toString());
			 totalTickets = ticketRepository.countByCompanyid(user.getCompanyId());
			 inProgressTickets = ticketRepository.countByCompanyidAndStatus(user.getCompanyId(), TicketStatus.INPROGRESS.toString());
			 countCustomers = userRepository.countByCompanyidAndType(user.getCompanyId(),"cust");
			 countUsers = userRepository.countByCompanyid(user.getCompanyId());
		
			
		} else if(utility.nonNUll.and(utility.isCust).test(user)){
			 openTickets =ticketRepository.countByCreatedByAndCompanyidAndStatus(user.getUsername(),user.getCompanyId(), TicketStatus.SUBMITTED.toString());
			 totalTickets = ticketRepository.countByCreatedByAndCompanyid(user.getUsername(),user.getCompanyId());
			 inProgressTickets = ticketRepository.countByCreatedByAndCompanyidAndStatus(user.getUsername(),user.getCompanyId(), TicketStatus.INPROGRESS.toString());
			 countCustomers = userRepository.countByCompanyidAndType(user.getCompanyId(),"cust");
			 countUsers = userRepository.countByCompanyid(user.getCompanyId());
		
		

		}else if(utility.nonNUll.and(utility.isFieldRepresantative).test(user)){
			 openTickets =ticketRepository.countByAssignedToAndCompanyidAndStatus(user.getUsername(),user.getCompanyId(), TicketStatus.SUBMITTED.toString());
			 totalTickets = ticketRepository.countByAssignedToAndCompanyid(user.getUsername(),user.getCompanyId());
			 inProgressTickets = ticketRepository.countByAssignedToAndCompanyidAndStatus(user.getUsername(),user.getCompanyId(), TicketStatus.INPROGRESS.toString());
			 countCustomers = userRepository.countByCompanyidAndType(user.getCompanyId(),"cust");
			 countUsers = userRepository.countByCompanyid(user.getCompanyId());
			
			

		}else
		{
			 openTickets = ticketRepository.countOpenTickets();
			 totalTickets = ticketRepository.countTickets();
			 inProgressTickets = ticketRepository.countInProgressTickets();
			 countCustomers = userRepository.countByType("cust");
			 countUsers = userRepository.countOfUsers();

		
			
		}
		status.setOpenTickets(openTickets);
		status.setTotalTickets(totalTickets);
		status.setCustomerCount(countCustomers);
		status.setTicketsInProgress(inProgressTickets);
		status.setTotalUserCount(countUsers);
		return status;
	}

}
