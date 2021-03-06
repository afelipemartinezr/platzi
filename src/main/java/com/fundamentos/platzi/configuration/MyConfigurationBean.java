package com.fundamentos.platzi.configuration;

import com.fundamentos.platzi.bean.*;
import com.fundamentos.platzi.bean.MyBeanImplement;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementTwo();
    }
    @Bean
    public MyOperation MyOperation(){
        return new MyOperationImplement();
    }
    @Bean
    public MyBeanWhitDependency MyOperationDependency(MyOperation myOperation){
        return new MyBeanWhitDependencyImplement(myOperation);
    }

}
