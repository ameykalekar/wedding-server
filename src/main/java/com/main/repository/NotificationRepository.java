package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

	Notification findOneByusername(String userName);
}
