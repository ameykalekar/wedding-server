package com.main.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Long >{
public List<Schedule> findByUsername(String username);

public List<Schedule> findByUsernameAndStartDateTimeGreaterThan(String username,Date startDateTime);

public Schedule findOneByUsernameAndTicketId(String username,String ticketId);

}
