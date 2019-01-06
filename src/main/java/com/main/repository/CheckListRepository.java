package com.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.CheckList;
import com.main.entity.Login;
import com.main.entity.Task;


public interface CheckListRepository extends JpaRepository<CheckList, Integer> {

	List<CheckList> findAllByCompanyId(String companyid);
	
}
