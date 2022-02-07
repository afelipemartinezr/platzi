package com.fundamentos.platzi.configuration;

import com.fundamentos.platzi.caseuse.GetUser;
import com.fundamentos.platzi.caseuse.GetUserImplement;
import com.fundamentos.platzi.repository.UserRepository;
import com.fundamentos.platzi.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }
}
