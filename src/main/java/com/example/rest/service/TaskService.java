package com.example.rest.service;

import com.example.rest.model.Task;
import com.example.rest.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vardan on 02.08.2017.
 */
@Service
public class TaskService {

    @Autowired
   private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }
    public List<Task> getTasks(){
        return  taskRepository.findAll();
    }

    public Task getTaskById(long id){
        Task task = taskRepository.findOne(id);
        return task;
    }

    public void removeTaskById(long id){
        taskRepository.delete(id);
    }

    public void updateTask(long id,Task task){
        task.setId(taskRepository.findOne(id).getId());
        taskRepository.save(task);
    }

   public List<Task> getTasksByUser(long id){
        return taskRepository.findAllByUserByUserId(userService.getUserById(id));
   }
}
