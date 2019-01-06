package com.main.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.main.entity.Resource;
import com.main.entity.Schedule;

public interface ResourceRepository extends Repository<Resource,Long> {

	Iterable<Resource> findAll();

	
	
}
