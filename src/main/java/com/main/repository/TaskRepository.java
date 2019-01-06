package com.main.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.main.entity.Login;
import com.main.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Integer> {

	Optional<List<Task>> findByChecklistid(Integer checklistid);
}
