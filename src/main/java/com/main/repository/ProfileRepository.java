package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Long>,ProfileRepositoryCustom {

	public Optional<ProfileEntity> findByemail(String email);
	
}
