package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

import com.main.entity.BarcodeCheckListTaskMapping;
import com.main.entity.BarcodePartMapping;
import com.main.entity.CheckList;
import com.main.entity.Company;
import com.main.entity.Part;
import com.main.entity.PartProductMapping;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.Task;
import com.main.repository.BarcodeCheckListTaskMappingRepository;
import com.main.repository.BarcodePartMappingRepository;
import com.main.repository.CheckListRepository;
import com.main.repository.PartProductMappingRepository;
import com.main.repository.PartRepository;
import com.main.repository.ProductCheckListMappingRepository;
import com.main.repository.TaskRepository;
import com.main.utility.Utility;
import com.main.vo.BarcodePart;

@RestController
@CrossOrigin(origins={"http://localhost:4200"})
public class BarcodePartMappingController {



	@Autowired
	Utility utility;
	
	@Autowired
BarcodePartMappingRepository barcodepartrepository;
	
	@Autowired
	PartRepository partRepository;
	
	@Autowired
	TaskRepository taskrepository;
	
	
	@Autowired
	CheckListRepository checklistrepositor;
	
	@RequestMapping("/api/GetAllBarcodeparts")
	public List<BarcodePart> get(){ 
	
		List<BarcodePartMapping> barcodeCheckListTaskMappings = barcodepartrepository.findAll();
		List<Task> tasks = new ArrayList();
		
	
		
		Map<Long, List<BarcodePartMapping>> barcodepartmap = barcodeCheckListTaskMappings.stream().collect(Collectors.groupingBy(BarcodePartMapping::getBarcodeid,Collectors.toList()));
	List<BarcodePart> barcodeParts = new ArrayList<>();
		
		barcodepartmap.forEach((k,v)->{
			
			BarcodePart	barcodePart = new BarcodePart();
			List<Part> parts = new ArrayList<>();
			v.forEach(action->{
				parts.add(partRepository.getOne(action.getPartId().intValue()));
			});
			barcodeParts.add(barcodePart);
		});
		
 	
 		
 	
		return barcodeParts;
		
	}
	
	@RequestMapping("/api/getAllPartsByBarcodeID")
	public List<Part> getParts(@RequestParam("id") String barcodeid){ 
		
		List<Long> temp1 = new ArrayList<>();
		temp1.add(new Long(barcodeid));
		
		List<BarcodePartMapping> temp = barcodepartrepository.findByBarcodeid(new Long(barcodeid));
		
		
		
		List<Long> parts= new ArrayList<>();
		if (null!=temp&&!temp.isEmpty()) {
		
		parts= temp.stream().map(BarcodePartMapping::getPartId).collect(Collectors.toList());

		List<Part> temppartlist = partRepository.findAllById(parts.stream().map(Long::intValue).collect(Collectors.toList()));
		
		if(!temppartlist.isEmpty())
	
		return temppartlist;
		 
		
		
		 
	}
		return null;
	}
	
	
	@PostMapping("/api/SaveBarcodePart")
	public ResponseEntity<List<BarcodePartMapping>> save(@RequestBody List<BarcodePartMapping> barcodeparts){ 
		List<BarcodePartMapping> barcodePartMappings = new ArrayList<>();
		barcodeparts.forEach(barcodepart -> {
			BarcodePartMapping t=barcodepartrepository.save(barcodepart);
			barcodePartMappings.add(t);
		});
		
		return new ResponseEntity<List<BarcodePartMapping>>(barcodePartMappings, HttpStatus.OK);
		
	}
	
}
