package br.com.tasklist.tasklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tasklist.tasklist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findByUserId(Long id);
    
}
