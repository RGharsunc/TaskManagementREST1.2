package com.example.rest.repo;

import com.example.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vardan on 02.08.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}

