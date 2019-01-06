package com.main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Product;
import com.main.entity.User;
import com.main.repository.ProductTypeRepository;
import com.main.repository.TicketRepository;
import com.main.repository.UserRepository;
import com.main.vo.Efficiency;
import com.main.vo.ProductReportVo;
import com.main.vo.ReportData;
import com.main.vo.ReportSearchCriteria;

@RestController
public class ReportServiceController {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping("/api/reportservice")
	public ReportData getReportData(@RequestBody ReportSearchCriteria criteria) {
		System.out.println(criteria);
		List reportData = null;
		ReportData reportLstData = null;

		switch (criteria.getReportType()) {

		case "efficiency": {

			Efficiency eff = new Efficiency();
			try {
				Object[][] result = ticketRepository.ticketsAssignedPerUser(criteria.getStartDateObj(),
						criteria.getEndDateObj());
				for (int i = 0; i < result.length; i++) {
					eff.addFREfficiency((String) result[i][0], (Long) result[i][1]);
				}
				result = ticketRepository.ticketsClosedPerUser(criteria.getStartDateObj(), criteria.getEndDateObj());

				for (int i = 0; i < result.length; i++) {
					eff.setClosedTickets((String) result[i][0], (Long) result[i][1]);
				}

				eff.setOpenTickets(
						ticketRepository.countOpenTickets(criteria.getStartDateObj(), criteria.getEndDateObj()));

				eff.setTotalInProgress(
						ticketRepository.countInProgressTickets(criteria.getStartDateObj(), criteria.getEndDateObj()));

				eff.setTotalRejected(
						ticketRepository.countRejectedTickets(criteria.getStartDateObj(), criteria.getEndDateObj()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			reportLstData = new ReportData(Arrays.asList(eff));
		}
			break;
		case "products":
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root r = query.from(Product.class);
			Predicate predicate = builder.conjunction();
			predicate = getStartDateEndDatePredicate(criteria, builder, r, predicate);
			if (criteria.getCompanyid() != null && !criteria.getCompanyid().isEmpty() && r.get("companyid") != null) {
				predicate = builder.and(predicate, builder.like(r.get("companyid"), criteria.getCompanyid()));
			}
			if (criteria.getProductBrand() != null && !criteria.getProductBrand().isEmpty()
					&& r.get("productBrand") != null) {
				predicate = builder.and(predicate, builder.like(r.get("productBrand"), criteria.getProductBrand()));
			}

			query.where(predicate);
			List<Product> result = entityManager.createQuery(query).getResultList();

			List<ProductReportVo> vo = new ArrayList<ProductReportVo>();
			result.forEach(product -> {
				vo.add(new ProductReportVo(product));
			});
			reportLstData = new ReportData(vo);
			break;
		case "users":
			builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> userquery = builder.createQuery(User.class);
			r = userquery.from(User.class);
			predicate = builder.conjunction();

			predicate = getStartDateEndDatePredicate(criteria, builder, r, predicate);
			if (criteria.getCompanyid() != null && r.get("companyid") != null) {
				predicate = builder.and(predicate, builder.like(r.get("companyid"), criteria.getCompanyid()));
			}
			if (criteria.getUsername() != null && r.get("username") != null) {
				predicate = builder.and(predicate, builder.like(r.get("username"), criteria.getUsername()));
			}

			userquery.where(predicate);
			List<User> userresult = entityManager.createQuery(userquery).getResultList();

			reportLstData = new ReportData(userresult);
			break;

		}
		return reportLstData;

	}

	private Predicate getStartDateEndDatePredicate(ReportSearchCriteria criteria, CriteriaBuilder builder, Root r,
			Predicate predicate) {
		if (criteria.getStartDate() != null) {
			try {
				predicate = builder.and(predicate,
						builder.greaterThanOrEqualTo(r.get("createdAt"), criteria.getStartDateObj()));
			} catch (Exception e) {
			}
		}
		if (criteria.getEndDate() != null) {
			try {
				predicate = builder.and(predicate,
						builder.lessThanOrEqualTo(r.get("createdAt"), criteria.getEndDateObj()));
			} catch (Exception e) {
			}
		}
		return predicate;
	}

}
