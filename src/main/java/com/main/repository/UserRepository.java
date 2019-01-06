package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.User;

public interface UserRepository extends JpaRepository<User,String> {

	@Query("select count(*) from User")
	public long countOfUsers();
	
	public List<User> findByCompanyidAndType(Long companyId,String type);

	public long countByType(String type);
	
	public long countByCompanyid(Long companyid);
	
	public long countByCompanyidAndType(Long companyid,String type);


}
