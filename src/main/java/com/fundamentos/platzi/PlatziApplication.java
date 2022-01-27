package com.fundamentos.platzi;

import com.fundamentos.platzi.bean.MyBean;
import com.fundamentos.platzi.bean.MyBeanWhitDependency;
import com.fundamentos.platzi.bean.MybeanWithProperties;
import com.fundamentos.platzi.bean.MybeanWithPropertiesImplement;
import com.fundamentos.platzi.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatziApplication implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWhitDependency myBeanWhitDependency;
    private MybeanWithProperties mybeanWithProperties;

    public PlatziApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MybeanWithProperties mybeanWithProperties) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWhitDependency = myBeanWhitDependency;
        this.mybeanWithProperties = mybeanWithProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlatziApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         if("Andre".toUpperCase().equals("ANDRE")){

             System.out.println("IGUALES");

         }else{
             System.out.println("DIFERENTES");
         }

        componentDependency.saludar();
        myBean.print();
        myBeanWhitDependency.printWhitDependency();
        System.out.println(mybeanWithProperties.function());
    }
}