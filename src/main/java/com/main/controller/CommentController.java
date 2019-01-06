package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Comment;
import com.main.entity.Company;
import com.main.entity.Product;
import com.main.entity.User;
import com.main.repository.CommentRepository;
import com.main.repository.CompanyRepository;
import com.main.repository.UserRepository;

@RestController
@CrossOrigin(origins={"*"})
public class CommentController {

	@Autowired
	CommentRepository commentRepository;
	
	@RequestMapping("/api/GetAllComments")
	public List<Comment> get(@RequestParam("id") String id){ 
		return commentRepository.findByTicketidOrderByCreatedAt(id);
	}
	
	@PostMapping("/api/SaveComments")
	public ResponseEntity<List<Comment>> save(@RequestBody List<Comment> comments){ 
		
		List<Comment> tempcomments =commentRepository.saveAll(comments);
		if (!tempcomments.isEmpty()) {
			return new ResponseEntity<List<Comment>>(tempcomments, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<List<Comment>>(tempcomments, HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}
	
	@PostMapping("/api/SaveComment")
	public ResponseEntity<Comment> save(@RequestBody Comment comments){ 
		
		Comment tempcomments =commentRepository.save(comments);
		if (tempcomments.getCommentid()!=null) {
			return new ResponseEntity<Comment>(tempcomments, HttpStatus.OK);
		}else
		{
			return new ResponseEntity<Comment>(tempcomments, HttpStatus.EXPECTATION_FAILED);
		}
		
		
	}

	
	
}
