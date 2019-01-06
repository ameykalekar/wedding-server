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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.BarcodeCheckListTaskMapping;
import com.main.entity.BarcodePartMapping;
import com.main.entity.BarcodeProductMapping;
import com.main.entity.CheckList;
import com.main.entity.Company;
import com.main.entity.Part;
import com.main.entity.PartProductMapping;
import com.main.entity.Product;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.Task;
import com.main.repository.BarcodeCheckListTaskMappingRepository;
import com.main.repository.BarcodePartMappingRepository;
import com.main.repository.BarcodeProductMappingRepository;
import com.main.repository.CheckListRepository;
import com.main.repository.PartProductMappingRepository;
import com.main.repository.PartRepository;
import com.main.repository.ProductCheckListMappingRepository;
import com.main.repository.ProductRepository;
import com.main.repository.TaskRepository;
import com.main.utility.Utility;
import com.main.vo.BarcodePart;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class BarcodeProductController {

	@Autowired
	BarcodeProductMappingRepository barcodeProductMappingRepository;

	@Autowired
	ProductRepository productRepository;

	@RequestMapping("/api/getProductByBarcodeID")
	public @ResponseBody Product getParts(@RequestParam("id") String barcodeid) {

		List<Long> temp1 = new ArrayList<>();
		temp1.add(new Long(barcodeid));

		BarcodeProductMapping temp = barcodeProductMappingRepository.getOne(barcodeid);

		System.out.println("Product id"+temp.getProductId().intValue());
		
	Product  product =productRepository.getOne(temp.getProductId().intValue());
	System.out.println("Product Name"+product.getProductName());;
	return product;

	}

	@PostMapping("/api/SaveBarcodeProduct")
	public ResponseEntity<BarcodeProductMapping> save(@RequestBody BarcodeProductMapping barcodepart) {

		BarcodeProductMapping t = barcodeProductMappingRepository.save(barcodepart);
		return new ResponseEntity<BarcodeProductMapping>(t, HttpStatus.OK);

	}

}
