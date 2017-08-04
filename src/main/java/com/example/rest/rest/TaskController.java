package com.example.rest.rest;

import com.example.rest.model.Task;
import com.example.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vardan on 02.08.2017.
 */
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/tasks")
    public ResponseEntity getTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping(value = "/task/add")
    public ResponseEntity addTask(@ModelAttribute Task task) {
        taskService.addTask(task);
        return ResponseEntity.ok("added");
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity getTaskById(@PathVariable long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }


    @DeleteMapping(value = "/task/delete/{id}")
    public ResponseEntity removeTaskById(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        } else {
            taskService.removeTaskById(id);
            return ResponseEntity.ok("removed");
        }
    }

    @PutMapping(value = "/task/update/{id}")
    public ResponseEntity updateTask(@PathVariable long id, @ModelAttribute Task task) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        } else {
            if (taskService.getTaskById(id) != null) {
                taskService.updateTask(id, task);
                return ResponseEntity.ok("updated");
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

    }

    @GetMapping(value = "/tasks/{userId}")
    public ResponseEntity getTasksByUser(@PathVariable long id){
       return ResponseEntity.ok(taskService.getTasksByUser(id));
    }




}
