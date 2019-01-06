package com.main.utility;

import java.util.Objects;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.main.entity.AuditModel;
import com.main.entity.Login;
import com.main.entity.Part;
import com.main.entity.User;
import com.main.vo.LoginVO;
@Service
public class Utility{
	
	public Predicate<? super AuditModel> isActive=(user) ->{
		return user.getActive().equalsIgnoreCase("Y");
		
	}; 
	
	
	
	public Predicate<LoginVO> isAdmin =(user) ->{
		return user.getRole().equalsIgnoreCase("admin");
		
	};
	
	public Predicate<LoginVO> isCleintAdmin =(user) ->{
		return user.getRole().equalsIgnoreCase("cadmin");
		
	};
	
	public Predicate<LoginVO> isCust =(user) ->{
		return user.getRole().equalsIgnoreCase("cust");
		
	};
	
	public Predicate<LoginVO> isSuperAdmin =(user) ->{
		return user.getRole().equalsIgnoreCase("cadmin");
		
	};
	
	public Predicate<LoginVO> isFieldRepresantative =(user) ->{
		return user.getRole().equalsIgnoreCase("fr");
		
	};
	
	
	public Predicate<User> isActiveUser =(user) ->{
		return user.getActive().equalsIgnoreCase("fr");
		
	};
	
	

	public Predicate<LoginVO> nonNUll = Objects::nonNull;
	
	
	public Boolean isClientAdminOrAdmin(LoginVO user) {
		
		return this.nonNUll.and(this.isAdmin.or(this.isCleintAdmin)).test(user);
		
	}
	
public Boolean isClientAdmi(LoginVO user) {
		
		return this.nonNUll.and((this.isCleintAdmin)).test(user);
		
	}
	
	
public Boolean isCustomer(LoginVO user) {
		
		return this.nonNUll.and((this.isCust)).test(user);
		
	}


public Boolean isSuperAdmin(LoginVO user) {
	
	return this.nonNUll.and(this.isSuperAdmin).test(user);
	
}


public void chckinteger(Integer i ,Predicate<Integer> p)
{
	System.out.println(p.test(i));
}

public Boolean isFieldRepresantative(LoginVO user) {
	
	return this.nonNUll.and(this.isFieldRepresantative).test(user);
	
}



	
	



}
