package br.com.tasklist.tasklist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tasklist.tasklist.entity.Task;
import br.com.tasklist.tasklist.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody Task task){
        taskService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> findAllTasksByUserId(@PathVariable("id") Long id){
        List<Task> tasks = taskService.findByUserId(id);

        return tasks != null ? ResponseEntity.ok(tasks): ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        taskService.update(task);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
