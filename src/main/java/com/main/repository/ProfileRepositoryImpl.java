package com.main.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.main.entity.ProfileEntity;
import com.main.vo.ProfileVo;

@Repository
public class ProfileRepositoryImpl implements ProfileRepositoryCustom {
	  EntityManager em;
	@Override
	public List<ProfileEntity> searchProfile(ProfileVo profileVo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<ProfileEntity> cq = cb.createQuery(ProfileEntity.class);
	 
	    Root<ProfileEntity> book = cq.from(ProfileEntity.class);
	    List<Predicate> predicates = new ArrayList<>();
	     
	    if (profileVo.getReligion() != null) {
	        predicates.add(cb.equal(book.get("religion"), profileVo.getReligion()));
	    }
	    if (profileVo.getCaste() != null) {
	        predicates.add(cb.equal(book.get("caste"), profileVo.getCaste()));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	 
	    return em.createQuery(cq).getResultList();
	}

}
