package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.CheckList;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.Task;
import com.main.repository.CheckListRepository;
import com.main.repository.ProductCheckListMappingRepository;
import com.main.repository.TaskRepository;

@RestController
@CrossOrigin(origins={"http://localhost:4200"})
public class ProductCheckListMappingController {

	@Autowired
	ProductCheckListMappingRepository productchecklistrepository;
	
	@Autowired
	CheckListRepository checklistrepository;
	
	@Autowired
	TaskRepository taskrepository;
	
	@RequestMapping("/api/GetAllProductChecklist")
	public List<ProductCheckListMapping> get(){ 
		return productchecklistrepository.findAll();
	}
	
	@RequestMapping("/api/getAllProductChecklistByProductId")
	public CheckList getChecklist(@RequestParam("id") String productId){ 
		
		ProductCheckListMapping temp = productchecklistrepository.getOneByProductId(productId);
		 if(temp!=null)
		 {
			Optional<CheckList> tempchecklist = checklistrepository.findById(new Integer(temp.getCheckListId()));
			
			if(tempchecklist.isPresent())
			{
				Optional<List<Task>> tasks= taskrepository.findByChecklistid(tempchecklist.get().getCheckListId());
				if(tasks.isPresent())
				{
					tempchecklist.get().setTasks(tasks.get());
				}
				return tempchecklist.get();
				
				
				
			}
			 
		 }
			 return null;
		 
	}
	
	
	@PostMapping("/api/SaveProductCheckListMapping")
	public ResponseEntity<ProductCheckListMapping> save(@RequestBody ProductCheckListMapping productCheckListMapping){ 
		
		productCheckListMapping.setActive("Y");
		ProductCheckListMapping t=productchecklistrepository.save(productCheckListMapping);
		return new ResponseEntity<ProductCheckListMapping>(t, HttpStatus.OK);
		
	}
}
