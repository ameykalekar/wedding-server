package com.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.ProfileVisibility;
import com.main.entity.User;

public interface ProfileVisibilityRepository extends JpaRepository<ProfileVisibility, Long>{

	Optional<ProfileVisibility> findOneByUser(User user);
}
