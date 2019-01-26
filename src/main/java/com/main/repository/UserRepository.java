package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.User;

public interface UserRepository extends JpaRepository<User,String> {

	@Query("select count(*) from User")
	public long countOfUsers();
	
}
