package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity,Long> {

}
