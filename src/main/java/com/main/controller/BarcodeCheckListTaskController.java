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

import com.main.entity.BarcodeCheckListTaskMapping;
import com.main.entity.BarcodePartMapping;
import com.main.entity.CheckList;
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

@RestController
@CrossOrigin(origins={"http://localhost:4200"})
public class BarcodeCheckListTaskController {

	@Autowired
	Utility utility;
	
	@Autowired
	BarcodeCheckListTaskMappingRepository barcodeCheckListTaskMappingRepository;
	
	@Autowired
	BarcodePartMappingRepository barcodePartMappingRepository;
	
	@Autowired
	PartRepository partRepository;
	
	@Autowired
	TaskRepository taskrepository;
	
	@RequestMapping("/api/GetAllBarcodePart")
	public List<BarcodePartMapping> get(){ 
		return barcodePartMappingRepository.findAll();
	}
	
	@RequestMapping("/api/getAllChecklistAndTaksByBarcodeID")
	public List<BarcodeCheckListTaskMapping> getParts(@RequestParam("id") Long barcodeid){ 
		 
		List<Long> ids= new ArrayList<>();
		ids.add(barcodeid);
		 
		barcodeCheckListTaskMappingRepository.findAllById(ids);
		
		 
	
		return null;
	}
	
	@PostMapping("/api/SaveChecklistAndTaksByBarcodeID")
	public ResponseEntity <List<BarcodeCheckListTaskMapping>>  save(@RequestBody List<BarcodeCheckListTaskMapping> productCheckListMapping){ 
		
		
	List<BarcodeCheckListTaskMapping> t=barcodeCheckListTaskMappingRepository.saveAll(productCheckListMapping);
		new ResponseEntity<List<BarcodeCheckListTaskMapping>> (t, HttpStatus.OK);
		return null;
		
	}
}
