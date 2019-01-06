package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import com.main.entity.BarcodeCheckListTaskMapping;
import com.main.entity.BarcodePartMapping;
import com.main.entity.CheckList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarcodeCheckListTaskMappingRepository extends JpaRepository<BarcodeCheckListTaskMapping, Long> {

	@Modifying
	@Query(value = "update T_BARCODECHECKLISTTASK set taskstatus = :taskstatus where id = :id" ,nativeQuery = true)
	 public int setFixedTaskstatusFor(@Param("taskstatus") String taskstatus, @Param("id") Long id);
	
	
	public BarcodeCheckListTaskMapping findByBarcodeidAndCheckListIdAndTaskid(Long barcodeid,Long checklistid,Long taskid);
	
	
}
