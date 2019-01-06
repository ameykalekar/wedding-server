package com.main.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.main.entity.Login;
import com.main.entity.Product;
import com.main.entity.User;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<List<Product>> findByproductType(String productType);
	Optional<List<Product>> findBycategory(String category);
	Optional<List<Product>> findBysubCategory(String subCategory);
	Optional<List<Product>> findByproductBrand(String productBrand);
	Optional<List<Product>> findBycategoryAndSubCategory(String category,String SubCategory);
	Optional<List<Product>> findByProductTypeAndCategoryAndSubCategoryAndProductBrand(String productType,String category,String SubCategory,String productBrand);
	
	Optional<List<Product>> findByproductTypeAndCompanyid(String productType,String companyid);
	Optional<List<Product>> findBycategoryAndCompanyid(String category,String companyid);
	Optional<List<Product>> findBysubCategoryAndCompanyid(String subCategory,String companyid);
	Optional<List<Product>> findByproductBrandAndCompanyid(String productBrand,String companyid);
	Optional<List<Product>> findBycategoryAndSubCategoryAndCompanyid(String category,String SubCategory,String companyid);
	Optional<List<Product>> findByProductTypeAndCategoryAndSubCategoryAndProductBrandAndCompanyid(String productType,String category,String SubCategory,String productBrand,String companyid);
	


}
