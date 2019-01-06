package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.CheckList;
import com.main.entity.Part;
import com.main.entity.Task;
import com.main.repository.PartRepository;
import com.main.vo.LoginVO;



@RestController
@CrossOrigin(origins={"*"})
public class PartController {

	@Autowired	
PartRepository PartRepository;
	
	@Autowired
	HttpServletRequest httprequest;
	


	
	@RequestMapping("/api/allParts")
	public List<Part> get(){ 
LoginVO user=(LoginVO)httprequest.getSession().getAttribute(ApplicationConstants.USER_INFO);
		
		List<Part> parts = PartRepository.findAllByCompanyid(user.getCompanyId());
				
		return parts;
		
		
	}
	
	@RequestMapping("/api/getPartsByType")
	public List<Part> getPartsByType(@RequestParam("p") String PartType){ 
		
		return PartRepository.findByPartType(PartType).get();
	}
	
	@RequestMapping("/api/getPartBrandBycategoryAndSubCategory")
	public @ResponseBody List<String> getBycategoryAndSubCategory(@RequestParam("category") String category,@RequestParam("subcategory") String subcategory){ 
		
		Optional<List<Part>> temp = PartRepository.findBycategoryAndSubCategory(category, subcategory);
		if(temp.isPresent())
		{
		
			List<String> brand= new ArrayList<>();
			
			temp.get().forEach(p->{
				brand.add(p.getPartBrand());
			});

			
			return brand.stream().distinct().collect(Collectors.toList());
		}
		else {
			return null;
		}
	
	}
	
	
	@RequestMapping("/api/getByPartTypeAndCategoryAndSubCategoryAndPartBrand")
	public @ResponseBody List<Part> getByPartTypeAndCategoryAndSubCategoryAndPartBrand(@RequestParam("Partype") String Parttyppe,@RequestParam("brand") String brand,@RequestParam("category") String category,@RequestParam("subcategory") String subcategory){ 
		
		Optional<List<Part>> temp = PartRepository.findByPartTypeAndCategoryAndSubCategoryAndPartBrand(Parttyppe,category, subcategory,brand);
		if(temp.isPresent())
		{
			return temp.get();
		}
		else {
			return null;
		}
	
	}
	
	
	@RequestMapping("/api/getPartSubcategoryBycategory")
	public @ResponseBody List<String> getSubcategoryBycategory(@RequestParam("category") String category){ 
		
		Optional<List<Part>> temp = PartRepository.findBycategory(category);
		if(temp.isPresent())
		{
		
			List<String> scategory =new ArrayList<>();
			
			temp.get().forEach(p->{
				scategory.add(p.getSubCategory());
			});

			
			return scategory.stream().distinct().collect(Collectors.toList());
		}
		else {
			return null;
		}
	
	}
	
	@RequestMapping("/api/getPartCategoryPartsByType")
	public @ResponseBody List<String> getCategoryPartsByType(@RequestParam("p") String PartType){ 
		Optional<List<Part>> temp =PartRepository.findByPartType(PartType);
		if(temp.isPresent())
		{
		
			List<String> category= new ArrayList<>();
			
			temp.get().forEach(p->{
				category.add(p.getCategory());
			});

			
			return category.stream().distinct().collect(Collectors.toList());
		}
		else {
			return null;
		}
	
	}
	
	@PostMapping("/api/createPart")
	public ResponseEntity<Part> save(@RequestBody Part Part){ 
		
		System.out.println(Part.getPartName());
		Part.setActive("Y");
		
		Part t=PartRepository.save(Part);
		
		
		return new ResponseEntity<Part>(t, HttpStatus.OK);
		
	}
	



}
