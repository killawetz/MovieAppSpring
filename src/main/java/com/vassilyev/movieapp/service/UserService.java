package com.vassilyev.movieapp.service;

import com.vassilyev.movieapp.model.web.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
        boolean saveUser(User user);
}
