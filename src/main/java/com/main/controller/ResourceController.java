package com.main.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.Resource;
import com.main.entity.Schedule;
import com.main.entity.Ticket;
import com.main.repository.ResourceRepository;
import com.main.repository.ScheduleRepository;
import com.main.repository.TicketRepository;
import com.main.vo.LoginVO;
import com.main.vo.ScheduleVO;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class ResourceController {

	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	TicketRepository ticketRepository;

	@RequestMapping("/api/getResources")
	public List<Resource> getAllTickets() {
		List<Resource> resources = new ArrayList<>();
		resourceRepository.findAll().forEach(ticket -> resources.add(ticket));
		return resources;
	}


	private List<ScheduleVO> getScheduleVo(List<Schedule> scheduleList){
			List<ScheduleVO> schVoList= new ArrayList<>();
		for(Schedule schedule:scheduleList){
		LocalDateTime startTime = schedule.getStartDateTime()
									.toInstant()
      								.atZone(ZoneId.systemDefault())
      								.toLocalDateTime();
      								
		LocalDateTime endTime = schedule.getEndDateTime()
									.toInstant()
      								.atZone(ZoneId.systemDefault())
      								.toLocalDateTime();
      				
      	ScheduleVO scheduleVo = new ScheduleVO();
      	scheduleVo.setStartTime(startTime);
      	scheduleVo.setEndTime(endTime);	
      	scheduleVo.setTicketId(schedule.getTicketId());						
		schVoList.add(scheduleVo);   
		}   								      								
		return schVoList;
	}
	@RequestMapping("/api/getSchedule")
	public List<ScheduleVO> getScheduleForResource(@RequestParam String username) {
		List<Schedule> scheduleList= scheduleRepository.findByUsername(username);
		List<ScheduleVO> schVoList= getScheduleVo(scheduleList);
		return schVoList;
	}
	
	@RequestMapping("/api/getMySchedule")
	public List<ScheduleVO> getScheduleForResource(HttpServletRequest request){
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		Date date = DateUtils.addDays(new Date(), -1);
		List<Schedule> scheduleList = scheduleRepository.findByUsernameAndStartDateTimeGreaterThan(loginvo.getUsername(), date);
		List<ScheduleVO> schVoList= getScheduleVo(scheduleList);
		return schVoList;
	}
	
	@RequestMapping("/api/scheduleFR")
	public ResponseEntity<String> scheduleFR(@RequestParam String username,@RequestBody ScheduleVO schedule){
			
			Schedule scheduleentity = new Schedule();
			scheduleentity.setUsername(username);
			scheduleentity.setTicketId(schedule.getTicketId());
			
			Calendar startTime = new GregorianCalendar(Integer.parseInt(schedule.getDateYear()),Integer.parseInt(schedule.getDateMonth()),Integer.parseInt(schedule.getDateDay()),Integer.parseInt(schedule.getSchStartTime().substring(0,2)),0);
			Calendar endTime = new GregorianCalendar(Integer.parseInt(schedule.getDateYear()),Integer.parseInt(schedule.getDateMonth()),Integer.parseInt(schedule.getDateDay()),Integer.parseInt(schedule.getSchEndTime().substring(0,2)),0);
			
			scheduleentity.setStartDateTime(startTime.getTime());
			scheduleentity.setEndDateTime(endTime.getTime());	
			
			scheduleRepository.save(scheduleentity);
			Ticket ticket = ticketRepository.findById(Long.parseLong(schedule.getTicketId())).get();
			ticket.setStatus(ApplicationConstants.ASSIGNED);
			ticket.setAssignedTo(username);
			ticketRepository.save(ticket);			
			return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}
