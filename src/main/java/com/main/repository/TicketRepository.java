package com.main.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

	
	
	Optional<Ticket> findById(Long id);  
	
	Ticket save(Ticket t);
	
	@Query("select count(*) from Ticket")
	public long countTickets();
	
	@Query("select assignedTo, count(*) from Ticket where  createdAt > (:startDate) and createdAt < (:endDate) group by assignedTo")
	public Object[][] ticketsAssignedPerUser(@Param("startDate") Date startDate ,  @Param("endDate") Date endDate);
	
	@Query("select assignedTo, count(*) from Ticket where  createdAt > (:startDate) and createdAt < (:endDate) and upper(status) in ('COMPLETED') group by assignedTo")
	public Object[][] ticketsClosedPerUser(@Param("startDate") Date startDate ,  @Param("endDate") Date endDate);
	
	@Query("select count(*) from Ticket where upper(status) not in ('SUBMITTED') and createdAt > (:startDate) and createdAt < (:endDate)")
	public long countOpenTickets(@Param("startDate") Date startDate ,  @Param("endDate") Date endDate);
	
	@Query("select count(*) from Ticket where upper(status) in ('IN-PROGRESS','ASSIGNED') and createdAt > (:startDate) and createdAt < (:endDate)")
	public long countInProgressTickets(@Param("startDate") Date startDate ,  @Param("endDate") Date endDate);
	
	@Query("select count(*) from Ticket where upper(status) in ('REJECTED') and createdAt > (:startDate) and createdAt < (:endDate)")
	public long countRejectedTickets(@Param("startDate") Date startDate ,  @Param("endDate") Date endDate);
	
	@Query("select count(*) from Ticket where upper(status) not in ('DONE','REJECTED')")
	public long countOpenTickets();
	
	@Query("select count(*) from Ticket where upper(status) in ('IN-PROGRESS','ASSIGNED')")
	public long countInProgressTickets();
	
	@Query("select p.productName,tp.partName,tp.price from TicketBarcodeMapping  tb "
			 + " join BarcodeProductMapping  tbp on tb.barcodeid = tbp.barcodeid " 
			 + " join BarcodePartMapping tbpp on tbp.barcodeid = tbpp.barcodeid join Part tp  on tp.id = tbpp.partId "
			 +"  join  Product p  on p.id = tbp.productId "
			 +"where tb.ticketId=:ticketid ")
	 public Object[] getPartsForTicket(@Param("ticketid") Long tickedId);
		
	 public Long countByCompanyid(Long companyid);
	 
	 
	 public Long countByCompanyidAndStatusIn(Long companyid,List<String> status);
	 public Long countByCompanyidAndStatus(Long companyid,String status);
	
	 
	 public Long countByCreatedByAndCompanyid(String createdBy,Long companyid);
	 public Long countByCreatedByAndCompanyidAndStatusIn(String createdBy,Long companyid,List<String> status);
	 public Long countByCreatedByAndCompanyidAndStatus(String createdBy,Long companyid,String status);
	
	 
	 
	 public Long countByAssignedToAndCompanyid(String createdBy,Long companyid);
	 public Long countByAssignedToAndCompanyidAndStatusIn(String createdBy,Long companyid,List<String> status);
	 public Long countByAssignedToAndCompanyidAndStatus(String createdBy,Long companyid,String status);
	 
	 public List<Ticket> findByCompanyidAndAssignedTo(Long companyid,String createdby); 
	 public List<Ticket> findByCompanyidAndCreatedBy(Long companyid,String createdby); 
	 public List<Ticket> findByCompanyidAndStatus(Long companyid,String status); 
	 public List<Ticket> findByCompanyidAndStatusAndCreatedBy(Long companyid,String status,String createdby); 
	 public List<Ticket> findByCompanyid(Long companyid);
}
