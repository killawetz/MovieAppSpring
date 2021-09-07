package com.vassilyev.movieapp.service.impl;

import com.vassilyev.movieapp.model.web.User;
import com.vassilyev.movieapp.model.web.Utype;
import com.vassilyev.movieapp.repository.web.UserRepository;
import com.vassilyev.movieapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("ВЫ ЧТО В КИОСКЕ");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(bCryptPasswordEncoder.matches("qqq",user.getPassword()));
        return user;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public boolean saveUser(User user){
        User userFromDb = userRepository.findUserByUsername(user.getUsername());

        if(userFromDb != null) {
            return false;
        }

        user.setUtypes(Collections.singleton(new Utype(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

}
