package com.vassilyev.movieapp;

import com.vassilyev.movieapp.model.web.User;
import com.vassilyev.movieapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;

@SpringBootTest
public class ReposServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void tryScreenshot() {
        User user = (User) userService.loadUserByUsername("123");
        String cur = bCryptPasswordEncoder.encode("roman");
        String cur1 = bCryptPasswordEncoder.encode(cur);
        String cur2 = bCryptPasswordEncoder.encode("roman");
        System.out.println(bCryptPasswordEncoder.matches("123", user.getPassword()));
        System.out.println();
    }
}
