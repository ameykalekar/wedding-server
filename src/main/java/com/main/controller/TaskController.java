package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.CheckList;
import com.main.entity.Login;
import com.main.entity.Resource;
import com.main.entity.Task;
import com.main.repository.LoginRepository;
import com.main.repository.ResourceRepository;
import com.main.repository.TaskRepository;

@RestController
@CrossOrigin(origins={"*"})
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	
	@RequestMapping("/api/allTasks")
	public List<Task> get(){ 
		
		return taskRepository.findAll();
	}
	
	@RequestMapping("/api/getByChecklistid")
	public List<Task> getByChecklistid (@RequestParam("id") Integer id){ 
		
		Optional<List<Task>> temp=taskRepository.findByChecklistid(id);
		if(temp.isPresent())
		{
			return temp.get();
		}
		return null;
	}
	
	
	@PostMapping("/api/createTasks")
	public ResponseEntity<Task>save(@RequestBody List<Task> tasks) {
		
		tasks.forEach(task -> System.out.println("SAving TAsk"+ task.getChecklistId()));

		List<Task> t = taskRepository.saveAll(tasks);

		return new ResponseEntity(t, HttpStatus.OK);

	}
	
}
