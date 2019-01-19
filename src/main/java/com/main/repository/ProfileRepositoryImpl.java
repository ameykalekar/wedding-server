package com.main.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.entity.ProfileEntity;
import com.main.vo.ProfileVo;

@Repository
public class ProfileRepositoryImpl implements ProfileRepositoryCustom {
	@Autowired  
	EntityManager em;
	@Override
	public List<ProfileEntity> searchProfile(ProfileVo profileVo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<ProfileEntity> cq = cb.createQuery(ProfileEntity.class);
	 
	    Root<ProfileEntity> book = cq.from(ProfileEntity.class);
	    List<Predicate> predicates = new ArrayList<>();
	     
	    if (StringUtils.isNotBlank(profileVo.getGender())  ) {
	        predicates.add(cb.equal(book.get("gender"), profileVo.getGender()));
	    }
	    if (StringUtils.isNotBlank(profileVo.getCaste())) {
	        predicates.add(cb.equal(book.get("caste"), profileVo.getCaste()));
	    }
	    if (StringUtils.isNotBlank(profileVo.getReligion())) {
	        predicates.add(cb.equal(book.get("religion"), profileVo.getReligion()));
	    }
	    
	    if (StringUtils.isNotBlank(profileVo.getAddress())) {
	        predicates.add(cb.like(book.get("address"), "%"+profileVo.getAddress()+"%"));
	    }
	    
	    if (StringUtils.isNotBlank(profileVo.getMarritalStatus())) {
	        predicates.add(cb.equal(book.get("maritastatus"), profileVo.getMarritalStatus()));
	    }
	    
	    if (StringUtils.isNotBlank(profileVo.getHighestDegree())) {
	        predicates.add(cb.equal(book.get("highestDegree"), profileVo.getMarritalStatus()));
	    }
	    
	    if (StringUtils.isNotBlank(profileVo.getAgeRange())) {
	        predicates.add(cb.between(book.get("age"), profileVo.getAgeRange().toString().split("-")[0], profileVo.getAgeRange().toString().split("-")[1]));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	    
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    	return em.createQuery(cq).setFirstResult(profileVo.getStart()).setMaxResults(profileVo.getMaxLimit()).getResultList();
	    
	}

}
