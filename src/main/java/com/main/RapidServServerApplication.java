package com.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.main.controller.TicketController;
import com.main.entity.CheckList;
import com.main.entity.Comment;
import com.main.entity.Login;
import com.main.entity.Product;
import com.main.entity.Task;
import com.main.entity.User;
import com.main.repository.CheckListRepository;
import com.main.repository.CommentRepository;
import com.main.repository.LoginRepository;
import com.main.repository.ProductRepository;
import com.main.repository.TaskRepository;
import com.main.repository.TicketRepository;
import com.main.repository.UserRepository;

@EnableAutoConfiguration
@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class RapidServServerApplication implements CommandLineRunner {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CheckListRepository checkListRepository;

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	TicketController ticketController;
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(RapidServServerApplication.class, args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public void run(String... args) throws Exception { Login login=
	 * new Login("Sagarthakare1@gmail.com", "123", "Customer", "123");
	 * loginRepository.save(login);
	 * 
	 * User user = new User("Sagarthakare1@gmail.com", "sagar", "thakare",
	 * "Pune", "9422915439", "Customer", "Y", "123"); userRepository.save(user);
	 * 
	 * Product product = new Product(1, "SMARTAC", "LG", "AC", "SPLIT", "ABC",
	 * "Y", "123", "New Product"); productRepository.save(product);
	 * 
	 * 
	 * CheckList checklist = new CheckList();
	 * 
	 * Task task1 = new Task("1", "Check Condenser"); Task task2 = new Task("2",
	 * "Check Remote Control"); List<Task> tasks = new ArrayList<>();
	 * 
	 * 
	 * checklist.setTasks(tasks); checklist.setActive("Y");
	 * checklist.setCheckListId("1"); checklist.setCheckListName(
	 * "LG AC Checklist"); checklist.setCompanyId("123");
	 * checklist.addTask(task1); checklist.addTask(task2);
	 * checkListRepository.save(checklist);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@Override
	public void run(String... args) throws Exception {/*

		Comment comment1 = new Comment(new Long(1), "Test1", "1", "1");
		Thread.sleep(50);
		Comment comment2 = new Comment(new Long(2), "Test2", "1", "1");
		Thread.sleep(50);
		Comment comment3 = new Comment(new Long(3), "Test3", "1", "1");
		Comment comment4 = new Comment(new Long(4), "Test4", "1", "2");
		Comment comment5 = new Comment(new Long(5), "Test5", "1", "3");
		Comment comment6 = new Comment(new Long(6), "Test6", "1", "1");
		Thread.sleep(50);
		Comment comment7 = new Comment(new Long(7), "Test7", "1", "1");

		Comment comment8 = new Comment(new Long(8), "Test8", "1", "1");

		System.out.println("Calling save");
		commentRepository.save(comment1);
		commentRepository.save(comment2);
		commentRepository.save(comment3);
		commentRepository.save(comment4);
		commentRepository.save(comment5);
		commentRepository.save(comment6);
		commentRepository.save(comment7);
		commentRepository.save(comment8);
		System.out.println("Calling size");
		System.out.println("Size of list" + commentRepository.findAll().size());

		System.out.println(commentRepository.findById((long) 1).toString());
		;
		commentRepository.findAll().forEach(action -> {
			System.out.println(action);
		});

		System.out.println("Calling function");
		commentRepository.findByTicketidOrderByCreatedAt("1").forEach(c -> {
			System.out.println(c.getDesc() + "--------" + c.getCreatedAt());
		});

		System.out.println("Total NUmber of Tikets by user"
				+ ticketRepository.countByCreatedByAndCompanyid("cust1", (long) 342432));
		List<String> status = new ArrayList<>();
		status.add("SUBMITTED");
		System.out.println("Total NUmber of Tikets by user"
				+ ticketRepository.countByCreatedByAndCompanyidAndStatusIn("cust1", (long) 342432, status));

		System.out.println("Total NUmber of Tikets by user"
				+ ticketRepository.findByCompanyidAndCreatedBy((long) 342432, "cust1"));
		System.out.println(ticketController.getTicketInfo("1"));
		
		System.out.println("Total NUmber of Tikets by user" + ticketRepository.findByCompanyidAndCreatedBy((long) 342432, "cust1"));
	
		System.out.println(ticketController.getTicketInfo("1"));
		
	*/}

}
