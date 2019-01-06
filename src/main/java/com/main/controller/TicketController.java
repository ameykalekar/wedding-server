package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.BarcodeCheckListTaskMapping;
import com.main.entity.CheckList;
import com.main.entity.Product;
import com.main.entity.ProductCheckListMapping;
import com.main.entity.Schedule;
import com.main.entity.Task;
import com.main.entity.Ticket;
import com.main.entity.TicketAudit;
import com.main.entity.TicketBarcodeMapping;
import com.main.repository.BarcodeCheckListTaskMappingRepository;
import com.main.repository.BarcodeProductMappingRepository;
import com.main.repository.CheckListRepository;
import com.main.repository.ProductCheckListMappingRepository;
import com.main.repository.ProductRepository;
import com.main.repository.ScheduleRepository;
import com.main.repository.TaskRepository;
import com.main.repository.TicketAuditRepository;
import com.main.repository.TicketBarcodeRepository;
import com.main.repository.TicketRepository;
import com.main.utility.Utility;
import com.main.vo.LoginVO;
import com.main.vo.ProductEstimateVO;
import com.main.vo.ProductInfo;
import com.main.vo.TicketInfo;

@RestController
@CrossOrigin(origins = { "*" })
public class TicketController {

	@Autowired
	Utility utility;

	@Autowired
	protected ProductRepository productRepository;

	@Autowired
	protected CheckListRepository checkListRepository;

	@Autowired
	protected TicketRepository ticketRepository;

	@Autowired
	protected TicketAuditRepository ticketAuditRepository;

	@Autowired
	protected TicketBarcodeRepository ticketBarcodeRepository;

	@Autowired
	protected BarcodeProductMappingRepository barcodeProductMappingRepository;

	@Autowired
	protected ProductCheckListMappingRepository productCheckListMappingRepository;

	@Autowired
	protected TaskRepository taskRepository;

	@Autowired
	protected BarcodeCheckListTaskMappingRepository barcodeCheckListTaskMappingRepository;
	
	@Autowired
	ScheduleRepository scheduleRepository;

	@RequestMapping("/api/OpenTickets")
	public List<Ticket> getAllTickets(HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		List<Ticket> tickets = new ArrayList<>();
		System.out.println(loginvo);
		if (utility.isClientAdminOrAdmin(loginvo)) {
			ticketRepository.findByCompanyid(loginvo.getCompanyId()).forEach(ticket -> tickets.add(ticket));
		} else if (utility.isCustomer(loginvo)) {

			System.out.println("Calling Customer");
			ticketRepository.findByCompanyidAndCreatedBy(loginvo.getCompanyId(), loginvo.getUsername())
					.forEach(ticket -> tickets.add(ticket));
		} else if (utility.isFieldRepresantative(loginvo)) {
			ticketRepository.findByCompanyidAndAssignedTo(loginvo.getCompanyId(), loginvo.getUsername())
					.forEach(ticket -> tickets.add(ticket));
		} else if (utility.isSuperAdmin(loginvo)) {
			ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
		}
		return tickets;
	}

	@PostMapping("/api/getAuditForTicket")
	public List<TicketAudit> getTicketAudit(@RequestParam String ticketId, @RequestParam String status) {
		status = status.toUpperCase();
		if (!ticketId.equals("") && !status.equals("")) {
			return ticketAuditRepository.findByTicketIdAndTicketStatus(Long.valueOf(ticketId), status);
		} else if (ticketId.equals("") && !status.equals("")) {
			return ticketAuditRepository.findByTicketStatus(status);
		} else if (!ticketId.equals("") && status.equals("")) {
			return ticketAuditRepository.findByTicketId(Long.valueOf(ticketId));
		} else {
			return ticketAuditRepository.findAll();
		}
	}

	@RequestMapping("/api/getTicket")
	public Ticket getTicket(@RequestParam String id) {
		return ticketRepository.findById(Long.valueOf(id)).get();
	}

	@RequestMapping("/api/getTicketInfo")
	public TicketInfo getTicketInfo(@RequestParam("ticketId") String id, HttpServletRequest request ) {
	
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		TicketInfo ticketInfo = new TicketInfo();
		List<TicketBarcodeMapping> ticketBarcodeMappings = new ArrayList<>();
		Ticket ticket = ticketRepository.getOne(new Long(id));
		if (ticket != null) {

			ticketInfo.setTicket(ticket);

			List<ProductInfo> productInfos = new ArrayList<>();

			ticketBarcodeMappings = ticketBarcodeRepository.findAllByTicketId(new Long(id));

			List<Long> products = new ArrayList<>();
			ticketBarcodeMappings.forEach(t -> System.out.println(t.getProductId()));
			ticketBarcodeMappings.forEach(t -> {
				ProductInfo productinfo = new ProductInfo();
				productinfo.setBarcodeId(t.getBarcodeid().toString());

				Product product = productRepository.getOne(barcodeProductMappingRepository
						.findById(t.getBarcodeid().toString()).get().getProductId().intValue());
				productinfo.setProduct(product);

				ProductCheckListMapping productCheckListMapping = productCheckListMappingRepository
						.getOneByProductId(product.getId().toString());
				if (productCheckListMapping != null) {
					CheckList checkList = new CheckList();
					checkList = checkListRepository.getOne(new Integer(productCheckListMapping.getCheckListId()));

					List<Task> temptasks = new ArrayList<>();

					System.out.println("Check List id" + checkList.getCheckListId());
					Optional<List<Task>> tasks = taskRepository
							.findByChecklistid(new Integer(checkList.getCheckListId()));

					if (tasks.isPresent()) {
						tasks.get().forEach(task -> {

							BarcodeCheckListTaskMapping barcodeCheckListTaskMapping = barcodeCheckListTaskMappingRepository
									.findByBarcodeidAndCheckListIdAndTaskid(t.getBarcodeid(),
											new Long(task.getChecklistId()), new Long(task.getId()));

							if (barcodeCheckListTaskMapping != null)
								if ("false".equalsIgnoreCase(barcodeCheckListTaskMapping.getTaskstatus())) {
									task.setStatus(null);

								} else {

									task.setStatus(barcodeCheckListTaskMapping.getTaskstatus());
								}
							temptasks.add(task);

						});

					}
					System.out.println(temptasks);
					checkList.setTasks(temptasks);
					System.out.println("checkList" + checkList);
					productinfo.setCheckList(checkList);

				}
				System.out.println("productinfo" + productinfo);
				productInfos.add(productinfo);
			});
			System.out.println("Exiting ");
			Schedule schedule = scheduleRepository.findOneByUsernameAndTicketId(loginvo.getUsername(), ticketInfo.getTicket().getId()+"");
			ticketInfo.setProductInfos(productInfos);
			ticketInfo.setFormattedEndScheduledTime(schedule.getFormatEndTime());
			ticketInfo.setFormattedStartScheduledTime(schedule.getFormatStartTime());
			System.out.println("ticketInfo" + ticketInfo);

			return ticketInfo;

		} else
			return null;

	}

	@RequestMapping("/api/AssignTicket")
	public Ticket AssignTicket(@RequestParam String userId, @RequestParam String ticketId, @RequestParam String type,
			HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		Optional<Ticket> ticket = ticketRepository.findById(Long.valueOf(ticketId));
		ticket.get().setStatus("ASSIGNED");
		ticket.get().setAssignedTo(userId);
		ticket.get().setType(type);
		ticket.get().setUpdatedBy(loginvo.getUsername());
		return ticketRepository.save(ticket.get());
	}

	@RequestMapping("/api/UnAssignTicket")
	public Ticket AssignTicket(@RequestParam String ticketId, HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		Optional<Ticket> ticket = ticketRepository.findById(Long.valueOf(ticketId));
		String assignedTo = ticket.get().getAssignedTo();
		ticket.get().setUpdatedBy(loginvo.getUsername());
		ticket.get().setAssignedTo("");
		ticket.get().setStatus("SUBMITTED");
		Ticket t = ticketRepository.save(ticket.get());
		
		Schedule schedule = scheduleRepository.findOneByUsernameAndTicketId(assignedTo, ticketId);
		
		System.out.println(schedule);
		scheduleRepository.delete(schedule);
		
		return  t;
	}

	@PostMapping("/api/saveTicketInfo")
	public ResponseEntity<TicketInfo> saveTicketInfo(@RequestBody TicketInfo ticketinfo, HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		try {
			ticketinfo.getProductInfos().forEach(action -> {

				List<TicketBarcodeMapping> test = ticketBarcodeRepository
						.findAllByTicketIdAndBarcodeid(ticketinfo.getTicket().getId(), new Long(action.getBarcodeId()));
				if (test.isEmpty()) {
					TicketBarcodeMapping ticketBarcodeMapping = new TicketBarcodeMapping(ticketinfo.getTicket().getId(),
							new Long(action.getBarcodeId()), loginvo.getUsername());
					;
					;

					ticketBarcodeRepository.save(ticketBarcodeMapping);
					action.getCheckList().getTasks().forEach(tasks -> {

						BarcodeCheckListTaskMapping barcodeCheckListTaskMapping = new BarcodeCheckListTaskMapping();
						barcodeCheckListTaskMapping.setBarcodeid(new Long(action.getBarcodeId()));
						barcodeCheckListTaskMapping.setCheckListId(new Long(tasks.getChecklistId()));
						barcodeCheckListTaskMapping.setTaskid(new Long(tasks.getId()));
						barcodeCheckListTaskMapping.setTaskstatus(tasks.getStatus());

						barcodeCheckListTaskMappingRepository.save(barcodeCheckListTaskMapping);
					});
				} else {

					action.getCheckList().getTasks().forEach(tasks -> {

						BarcodeCheckListTaskMapping barcodeCheckListTaskMapping = barcodeCheckListTaskMappingRepository
								.findByBarcodeidAndCheckListIdAndTaskid(new Long(action.getBarcodeId()),
										new Long(tasks.getChecklistid()), new Long(tasks.getId()));
						if (tasks.getStatus() != null)
							barcodeCheckListTaskMappingRepository.setFixedTaskstatusFor(tasks.getStatus(),
									barcodeCheckListTaskMapping.getId());
						else
							barcodeCheckListTaskMappingRepository.setFixedTaskstatusFor("false",
									barcodeCheckListTaskMapping.getId());

					});

				}

			});

			return new ResponseEntity<TicketInfo>(ticketinfo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<TicketInfo>(ticketinfo, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@PostMapping("/api/createticket")
	public ResponseEntity<Ticket> save(@RequestBody Ticket ticket, HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		ticket.setStatus("SUBMITTED");
		ticket.setUpdatedBy(loginvo.getUsername());
		ticket.setCompanyid(loginvo.getCompanyId());
		Ticket t = ticketRepository.save(ticket);
		return new ResponseEntity<Ticket>(t, HttpStatus.OK);

	}

	@PostMapping("/api/savebarcode")
	public ResponseEntity<TicketBarcodeMapping> save(@RequestBody TicketBarcodeMapping ticket,
			HttpServletRequest request) {
		LoginVO loginvo = (LoginVO) request.getSession().getAttribute(ApplicationConstants.USER_INFO);
		ticket.setUpdateby(loginvo.getUsername());
		TicketBarcodeMapping t = ticketBarcodeRepository.save(ticket);
		return new ResponseEntity<TicketBarcodeMapping>(t, HttpStatus.OK);
	}
	
	@PostMapping("/api/getEstimateDetails")
	public ResponseEntity<Map<String,List<ProductEstimateVO>> > getEstimateDetails(@RequestBody String ticketId){
		Object[] ary = ticketRepository.getPartsForTicket(Long.valueOf(ticketId));
		
		
		List<ProductEstimateVO> list = new ArrayList<>();
		for(int i =0;i<ary.length;i++){
				Object[] row = (Object[])ary[i];
				System.out.println(row[0] );
				list.add(new ProductEstimateVO(String.valueOf(row[0]), String.valueOf(row[1]), String.valueOf(row[2]))); 
		}
		
		Map<String,List<ProductEstimateVO>> result =  list.stream().collect(Collectors.groupingBy(ProductEstimateVO :: getProductname));
		
		return new ResponseEntity<Map<String,List<ProductEstimateVO>>>(result,HttpStatus.OK);
	
	}
}
