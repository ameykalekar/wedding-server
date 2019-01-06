package com.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.CustomerClient;
import com.main.entity.ProductType;
import com.main.repository.CustomerClientRepository;
import com.main.vo.LoginVO;

@RestController
public class CustomerClientController {

	@Autowired 
	private CustomerClientRepository repo;
	
	@PostMapping("/api/getCustomerClients")
	public List<CustomerClient> getCustomers(HttpServletRequest request){
		
		LoginVO loginVo = (LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		long companyId = loginVo.getCompanyId();
		//customerClient.setCompanyId(companyId);
		List<Long> ids = new ArrayList<>(2);
		ids.add(companyId);
		return  repo.findByCompanyId(companyId);
		
	}

	@PostMapping("/api/SaveCustomerClient")
	public CustomerClient saveCustomerClient(@RequestBody CustomerClient customerClient,HttpServletRequest request){
		LoginVO loginVo = (LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		long companyId = loginVo.getCompanyId();
		customerClient.setCompanyId(companyId);
		System.out.println(customerClient);
		return repo.save(customerClient);
	}
	
	@PostMapping("/api/RemoveCustomerClient")
	public Result removeCustomerClient(@RequestBody CustomerClient customerClient,HttpServletRequest request){
		LoginVO loginVo = (LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		long companyId = loginVo.getCompanyId();
		customerClient.setCompanyId(companyId);
		repo.delete(customerClient);
		return new Result("success");
	}
	
	@PostMapping("/api/EditCustomerClient")
	public CustomerClient editProductType(HttpServletRequest request,@RequestBody CustomerClient customerClient){
		LoginVO loginVo = (LoginVO)request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		long companyId = loginVo.getCompanyId();
		customerClient.setCompanyId(companyId);
		System.out.println(customerClient);
		return repo.save(customerClient);
	}
	
}
