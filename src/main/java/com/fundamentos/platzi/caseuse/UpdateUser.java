package com.fundamentos.platzi.caseuse;

import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, long id) {
        return userService.update(newUser,id);
    }
}
