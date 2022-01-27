package com.fundamentos.platzi.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementTwo implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("Hola Mundo Clase 2");
    }
}
