package com.vassilyev.movieapp.repository.web;

import com.vassilyev.movieapp.model.web.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String name);
}
