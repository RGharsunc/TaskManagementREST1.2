package com.example.rest.rest;

import com.example.rest.model.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vardan on 02.08.2017.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/user/add")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("added");
    }

    @GetMapping(value = "/users")
    public ResponseEntity getUsersList() {
        return ResponseEntity.ok(userService.getUsersList());
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity removeUserById(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        } else {
            userService.removeUserById(id);
            return ResponseEntity.ok("deleted");
        }
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity updateUserById(@ModelAttribute User user, @PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        } else {
            if (userService.getUserById(id) != null) {
                userService.updateUserById(id, user);

                return ResponseEntity.ok("updated");
            }else {
                return ResponseEntity.badRequest().build();
            }
        }
    }


}


