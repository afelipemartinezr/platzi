package com.fundamentos.platzi.caseuse;

import com.fundamentos.platzi.entity.User;
import com.fundamentos.platzi.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
