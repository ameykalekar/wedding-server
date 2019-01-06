package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.main.entity.Part;
import com.main.entity.PartProductMapping;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.Task;
import com.main.repository.CheckListRepository;
import com.main.repository.PartProductMappingRepository;
import com.main.repository.PartRepository;
import com.main.repository.ProductCheckListMappingRepository;
import com.main.repository.TaskRepository;
import com.main.utility.Utility;

@RestController
@CrossOrigin(origins={"http://localhost:4200"})
public class PartProductMappingController {

	@Autowired
	Utility utility;
	
	@Autowired
	PartProductMappingRepository partProductMappingRepository;
	
	@Autowired
	PartRepository partRepository;
	
	@Autowired
	TaskRepository taskrepository;
	
	@RequestMapping("/api/GetAllPartProduct")
	public List<PartProductMapping> get(){ 
		return partProductMappingRepository.findAll();
	}
	
	@RequestMapping("/api/getAllPartsByProductId")
	public List<Part> getParts(@RequestParam("id") String productId){ 
		
		List<PartProductMapping> temp = partProductMappingRepository.findAllByProductId(productId);
		
		List<Integer> parts= new ArrayList<>();
		if (null!=temp&&!temp.isEmpty()) {
		
			System.out.println("Partproductmapping"+temp);
		temp.stream().filter(part->part.getActive().equalsIgnoreCase("Y")).collect(Collectors.toList()).forEach(new Consumer<PartProductMapping>()  {

			@Override
			public void accept(PartProductMapping t) {
			parts.add(new Integer(t.getPartId()));
				}
		
		
		});;
		

		List<Part> temppartlist = partRepository.findAllById(parts);
		
		if(!temppartlist.isEmpty())
	
		return temppartlist;
		 
		
		
		 
	}
		return null;
	}
	
	@PostMapping("/api/SavePartProductMapping")
	public ResponseEntity <List<PartProductMapping>>  save(@RequestBody List<PartProductMapping> productCheckListMapping){ 
		
		
		List<PartProductMapping> t=partProductMappingRepository.saveAll(productCheckListMapping);
		return new ResponseEntity<List<PartProductMapping>> (t, HttpStatus.OK);
		
	}
}
