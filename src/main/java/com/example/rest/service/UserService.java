package com.example.rest.service;


import com.example.rest.model.User;
import com.example.rest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vardan on 02.08.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }


    public List<User> getUsersList() {

    List<User> users=  userRepository.findAll();
    return users;
    }

    public User getUserById(long id){
        User user = userRepository.findOne(id);
        return user;
    }

    public void removeUserById(long id){
        userRepository.delete(id);
    }
    public void updateUserById(long id,User user){
        user.setId(userRepository.findOne(id).getId());
        userRepository.save(user);
    }

}
