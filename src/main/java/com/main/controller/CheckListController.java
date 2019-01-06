package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.constants.ApplicationConstants;
import com.main.entity.CheckList;
import com.main.entity.Task;
import com.main.repository.CheckListRepository;
import com.main.repository.TaskRepository;
import com.main.vo.LoginVO;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class CheckListController {

	@Autowired
	CheckListRepository checkListRepository;
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	HttpServletRequest httprequest;

	@RequestMapping("/api/allCheckList")
	public List<CheckList> get() {
		
		LoginVO user=(LoginVO)httprequest.getSession().getAttribute(ApplicationConstants.USER_INFO);
		
		List<CheckList> checklist = checkListRepository.findAllByCompanyId(user.getCompanyId().toString());
				checklist.stream().forEach(item->{
			 Optional<List<Task>> tasks= taskRepository.findByChecklistid( item.getCheckListId());
				if(tasks.isPresent())
				{
					item.setTasks(tasks.get());
				}
		 } );
		
		return checklist;
		
		 
	}

	@RequestMapping("/api/allCheckListwithitem")
	public List<Task> getitems() {

		return taskRepository.findAll();
	}

	@RequestMapping("/api/getCheckList")
	public CheckList get(@PathVariable String id) {

		Optional<CheckList> checklist = checkListRepository.findById(new Integer(id));
		if (checklist.isPresent()) {
			return checklist.get();
		} else {
			return null;
		}
	}

	@PostMapping("/api/createCheckList")
	public ResponseEntity<CheckList> save(@RequestBody CheckList checklist) {

		System.out.println(checklist.getCheckListName());
		checklist.setActive("Y");
		CheckList t = checkListRepository.save(checklist);
		return new ResponseEntity<CheckList>(t, HttpStatus.OK);

	}

}
