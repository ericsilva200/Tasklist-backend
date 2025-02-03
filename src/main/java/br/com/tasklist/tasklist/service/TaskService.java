package br.com.tasklist.tasklist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tasklist.tasklist.entity.Task;
import br.com.tasklist.tasklist.repository.TaskRepository;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public List<Task> create(Task task){
        try {
            taskRepository.save(task);
            return list();
        } catch (Exception e) {
            throw new Error("Erro ao criar tarefa: " + e);
        }
    }

    public List<Task> list(){
        return taskRepository.findAll();
    }

    public List<Task> findByUserId(Long id){
        return taskRepository.findByUserId(id);
    }

    public List<Task> update(Task task){
        try {
            taskRepository.save(task);
            return list();
        } catch (Exception e) {
            throw new Error("Erro ao alterar tarefa: " + e);
        }
    }

    public List<Task> delete(Long id){
        try {
            taskRepository.deleteById(id);
            return list();
        } catch (Exception e) {
            throw new Error("Erro ao deletar tarefa: " + e);
        }
    }
}
