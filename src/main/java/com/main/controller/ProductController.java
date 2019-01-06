package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

import com.main.entity.Product;
import com.main.entity.ProductType;
import com.main.repository.ProductRepository;
import com.main.repository.ProductTypeRepository;


@RestController
@CrossOrigin(origins={"*"})
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTypeRepository productTypeRepository;
	
	
	@RequestMapping("/api/allproducts")
	public List<Product> get(){ 
		
		return productRepository.findAll();
	}
	
	@RequestMapping("/api/getProductsByType")
	public List<Product> getProductsByType(@RequestParam("p") String productType){ 
		
		return productRepository.findByproductType(productType).get();
	}
	
	@RequestMapping("/api/getBrandBycategoryAndSubCategory")
	public @ResponseBody List<String> getBycategoryAndSubCategory(@RequestParam("category") String category,@RequestParam("subcategory") String subcategory){ 
		
		Optional<List<Product>> temp = productRepository.findBycategoryAndSubCategory(category, subcategory);
		if(temp.isPresent())
		{
		
			List<String> brand= new ArrayList<>();
			
			temp.get().forEach(p->{
				brand.add(p.getProductBrand());
			});

			
			return brand.stream().distinct().collect(Collectors.toList());
		}
		else {
			return null;
		}
	
	}
	
	
	@RequestMapping("/api/getByProductTypeAndCategoryAndSubCategoryAndProductBrand")
	public @ResponseBody List<Product> getByProductTypeAndCategoryAndSubCategoryAndProductBrand(@RequestParam("productype") String producttyppe,@RequestParam("brand") String brand,@RequestParam("category") String category,@RequestParam("subcategory") String subcategory){ 
		
		Optional<List<Product>> temp = productRepository.findByProductTypeAndCategoryAndSubCategoryAndProductBrand(producttyppe,category, subcategory,brand);
		if(temp.isPresent())
		{
			return temp.get();
		}
		else {
			return null;
		}
	
	}
	
	
	@RequestMapping("/api/getSubcategoryBycategory")
	public @ResponseBody List<String> getSubcategoryBycategory(@RequestParam("category") String category){ 
		
		Optional<List<Product>> temp = productRepository.findBycategory(category);
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
	
	@RequestMapping("/api/getCategoryProductsByType")
	public @ResponseBody List<String> getCategoryProductsByType(@RequestParam("p") String productType){ 
		Optional<List<Product>> temp =productRepository.findByproductType(productType);
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
	
	@PostMapping("/api/createproduct")
	public ResponseEntity<Product> save(@RequestBody Product product){ 
		
		System.out.println(product.getProductName());
		product.setActive("Y");
		
		Product t=productRepository.save(product);
		
		
		return new ResponseEntity<Product>(t, HttpStatus.OK);
		
	}
	
	@RequestMapping("/api/ProductTypes")
	public List<ProductType> getTypes(){
		return productTypeRepository.findAll();
	}
	
	@PostMapping("/api/SaveProductType")
	public ProductType saveProductType(@RequestBody ProductType productType){
		return productTypeRepository.save(productType);
	}
	
	@PostMapping("/api/RemoveProductType")
	public Result removeProductType(@RequestBody ProductType productType){
		productTypeRepository.delete(productType);
		return new Result("success");
	}
	
	@PostMapping("/api/EditProductType")
	public ProductType editProductType(@RequestBody ProductType productType){
		return productTypeRepository.save(productType);
	}


}
