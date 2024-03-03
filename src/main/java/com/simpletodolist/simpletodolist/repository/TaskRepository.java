package com.simpletodolist.simpletodolist.repository;

import com.simpletodolist.simpletodolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
