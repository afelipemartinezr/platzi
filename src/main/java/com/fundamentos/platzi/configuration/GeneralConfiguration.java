package com.fundamentos.platzi.configuration;

import com.fundamentos.platzi.bean.MybeanWithProperties;
import com.fundamentos.platzi.bean.MybeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
public class GeneralConfiguration {
    @Value("${value.nombre}")
    private String nombre;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
     public MybeanWithProperties function(){
        return new MybeanWithPropertiesImplement(nombre,apellido);
    }

}
