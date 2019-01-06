package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.entity.Comment;
import com.main.entity.Company;

public interface CommentRepository extends JpaRepository<Comment,Long> {


	List<Comment> findByTicketidOrderByCreatedAt(String id);

}
