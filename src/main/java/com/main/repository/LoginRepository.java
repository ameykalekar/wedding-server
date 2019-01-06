package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.main.entity.Login;


public interface LoginRepository extends JpaRepository<Login, String> {

	
}
