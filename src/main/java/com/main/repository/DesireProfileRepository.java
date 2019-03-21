package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.DesiredProfile;

public interface DesireProfileRepository  extends JpaRepository<DesiredProfile,String> {

}
