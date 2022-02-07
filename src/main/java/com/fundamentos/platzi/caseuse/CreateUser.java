package com.fundamentos.platzi.caseuse;

import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
       return userService.save(newUser);
    }
}
