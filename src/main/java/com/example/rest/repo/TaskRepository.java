package com.example.rest.repo;

import com.example.rest.model.Task;
import com.example.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vardan on 02.08.2017.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserByUserId(User user);
}
