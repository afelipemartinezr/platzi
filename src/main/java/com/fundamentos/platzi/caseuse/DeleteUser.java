package com.fundamentos.platzi.caseuse;

import com.fundamentos.platzi.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void remove(Long id) {
        userService.delete(id);
    }
}
