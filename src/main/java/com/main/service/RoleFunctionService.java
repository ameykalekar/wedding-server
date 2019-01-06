package com.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.RoleFunction;
import com.main.repository.RoleFunctionRepository;

@Service
public class RoleFunctionService {

	@Autowired
	public RoleFunctionRepository roleFunctionRepo;

	private HashMap<String, String> functionUrlMap = new HashMap<>();

	private Map<String, Set<RoleFunction>> roleFunctionMap = new HashMap<>();

	public RoleFunctionService() {
	}

	private void init() {
		if (roleFunctionMap.isEmpty()) {
			List<RoleFunction> rolefunction = roleFunctionRepo.findAll();
			roleFunctionMap = rolefunction.stream()
					.collect(Collectors.groupingBy(RoleFunction::getRole, Collectors.toSet()));
		}

		if (functionUrlMap.isEmpty()) {

			// checklist
			functionUrlMap.put("allCheckList".toLowerCase(), "viewchecklist".toLowerCase());
			functionUrlMap.put("allCheckListwithitem".toLowerCase(), "viewchecklist".toLowerCase());
			functionUrlMap.put("getCheckList".toLowerCase(), "viewchecklist".toLowerCase());
			functionUrlMap.put("createCheckList".toLowerCase(), "createchecklist".toLowerCase());

			// company creation
			functionUrlMap.put("GetAllCompanies".toLowerCase(), "viewcompany".toLowerCase());
			functionUrlMap.put("SaveCompany".toLowerCase(), "createcompany".toLowerCase());

			// view customer
			functionUrlMap.put("getCustomers".toLowerCase(), "viewcustomer".toLowerCase());

			functionUrlMap.put("status".toLowerCase(), "dashboard".toLowerCase());

			// notification
			functionUrlMap.put("viewnotification".toLowerCase(), "viewnotification".toLowerCase());
			functionUrlMap.put("updatenotification".toLowerCase(), "updatenotification".toLowerCase());

			// productchecklist
			functionUrlMap.put("GetAllProductChecklist".toLowerCase(), "viewproductchecklist".toLowerCase());
			functionUrlMap.put("getAllProductChecklistByProductId".toLowerCase(), "viewproductchecklist".toLowerCase());
			functionUrlMap.put("SaveProductCheckListMapping".toLowerCase(), "createproductchecklist".toLowerCase());

			// product
			functionUrlMap.put("allproducts".toLowerCase(), "viewproduct");
			functionUrlMap.put("getProductsByType".toLowerCase(), "viewproduct");
			functionUrlMap.put("getBrandBycategoryAndSubCategory".toLowerCase(), "viewproduct");
			functionUrlMap.put("getByProductTypeAndCategoryAndSubCategoryAndProductBrand".toLowerCase(), "viewproduct");
			functionUrlMap.put("getSubcategoryBycategory".toLowerCase(), "viewproduct");
			functionUrlMap.put("getCategoryProductsByType".toLowerCase(), "viewproduct");
			functionUrlMap.put("createproduct".toLowerCase(), "createproduct");
			functionUrlMap.put("ProductTypes".toLowerCase(), "viewproduct");
			functionUrlMap.put("SaveProductType".toLowerCase(), "createproduct");
			functionUrlMap.put("RemoveProductType".toLowerCase(), "removeproduct");
			functionUrlMap.put("EditProductType".toLowerCase(), "editproduct");

			// users
			functionUrlMap.put("getResources".toLowerCase(), "viewusers");
			functionUrlMap.put("GetAllUsers".toLowerCase(), "viewusers");
			functionUrlMap.put("SaveUser".toLowerCase(), "createusers");
			functionUrlMap.put("GetUser".toLowerCase(), "viewusers");
			
			
			// task
			functionUrlMap.put("allTasks".toLowerCase(), "viewtask");
			functionUrlMap.put("getByChecklistid".toLowerCase(), "viewtask");
			functionUrlMap.put("createTasks".toLowerCase(), "createtask");
			functionUrlMap.put("createTasks".toLowerCase(), "createtasks");
			// tickets
			functionUrlMap.put("OpenTickets".toLowerCase(), "viewtickets");
			functionUrlMap.put("getTicket".toLowerCase(), "viewtickets");
			functionUrlMap.put("AssignTicket".toLowerCase(), "assignticket");
			functionUrlMap.put("UnAssignTicket".toLowerCase(), "unassignticket");
			functionUrlMap.put("createticket".toLowerCase(), "createticket");
			functionUrlMap.put("getAuditForTicket".toLowerCase(), "ticketaudit");
			functionUrlMap.put("getallcomments".toLowerCase(), "viewtickets");
			functionUrlMap.put("savecomments".toLowerCase(), "viewtickets");
			functionUrlMap.put("savecomment".toLowerCase(), "viewtickets");
			
			functionUrlMap.put("getProductByBarcodeID".toLowerCase(), "editticket");
			functionUrlMap.put("savebarcode".toLowerCase(), "editticket");
			functionUrlMap.put("getTicketInfo".toLowerCase(), "editticket");
			functionUrlMap.put("saveTicketInfo".toLowerCase(), "editticket");
			//part
			
			functionUrlMap.put("createPart".toLowerCase(), "createpart");
			functionUrlMap.put("allParts".toLowerCase(), "createpart");
			functionUrlMap.put("getAllPartsByProductId".toLowerCase(), "createpart");
			functionUrlMap.put("SavePartProductMapping".toLowerCase(), "createpart");
			
			functionUrlMap.put("getUsersByCompanyId".toLowerCase(),"viewtickets");
			
			
			//view schedule
			functionUrlMap.put("getSchedule".toLowerCase(), "viewschedule");
			functionUrlMap.put("scheduleFR".toLowerCase(), "assignticket");			
			functionUrlMap.put("getMySchedule".toLowerCase(),"myschedule");
			
			//customer-clients
			functionUrlMap.put("getCustomerClients".toLowerCase(), "viewcustomerclient");
			functionUrlMap.put("SaveCustomerClient".toLowerCase(), "createcustomerclient");
			functionUrlMap.put("RemoveCustomerClient".toLowerCase(), "removecustomerclient");
			functionUrlMap.put("EditCustomerClient".toLowerCase(), "editcustomerclient");
			
			//reports 
			functionUrlMap.put("reportservice".toLowerCase(),"viewreports");
			functionUrlMap.put("downloadreport".toLowerCase(),"downloadreport");
			
			
			//Estimate
			functionUrlMap.put("getAllPartsByBarcodeID".toLowerCase(), "estimate");
			functionUrlMap.put("getEstimateDetails".toLowerCase(), "estimate");
				
			functionUrlMap.put("SaveBarcodePart".toLowerCase(), "estimate");
			
			//change password
			functionUrlMap.put("changepassword".toLowerCase(), "changepassword");
			
			
			
		}

	}

	public boolean isAuthorized(String role, String url) {
		init();
		if (roleFunctionMap.get(role.toLowerCase()) != null && functionUrlMap.get(url.toLowerCase()) != null) {
			if (roleFunctionMap.get(role.toLowerCase()).contains(new RoleFunction(role.toLowerCase(), functionUrlMap.get(url.toLowerCase())))) {
				return true;
			} else {
				System.out.println(role + " & " +  url);
				return false;
			}
		} else {
			System.out.println(role + " & " +  url);
			return false;
		}

	}

	public List<String> getFunctionsForRole(String role) {
		init();
		List<String> functions = roleFunctionMap.get(role.toLowerCase()).stream().map(x -> x.getFunction())
				.collect(Collectors.toList());
		return functions;
	}

}
