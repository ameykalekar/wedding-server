package com.main.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.CheckList;
import com.main.entity.Login;
import com.main.entity.Part;
import com.main.entity.Part;
import com.main.entity.User;


public interface PartRepository extends JpaRepository<Part, Integer> {
	
	Optional<List<Part>> findByPartType(String PartType);
	Optional<List<Part>> findBycategory(String category);
	Optional<List<Part>> findBysubCategory(String subCategory);
	Optional<List<Part>> findByPartBrand(String PartBrand);
	Optional<List<Part>> findBycategoryAndSubCategory(String category,String SubCategory);
	Optional<List<Part>> findByPartTypeAndCategoryAndSubCategoryAndPartBrand(String PartType,String category,String SubCategory,String PartBrand);
	
	Optional<List<Part>> findByPartTypeAndCompanyid(String PartType,String companyid);
	Optional<List<Part>> findBycategoryAndCompanyid(String category,String companyid);
	Optional<List<Part>> findBysubCategoryAndCompanyid(String subCategory,String companyid);
	Optional<List<Part>> findByPartBrandAndCompanyid(String PartBrand,String companyid);
	Optional<List<Part>> findBycategoryAndSubCategoryAndCompanyid(String category,String SubCategory,String companyid);
	Optional<List<Part>> findByPartTypeAndCategoryAndSubCategoryAndPartBrandAndCompanyid(String PartType,String category,String SubCategory,String PartBrand,String companyid);
	List<Part> findAllByCompanyid(Long companyid);	
}
