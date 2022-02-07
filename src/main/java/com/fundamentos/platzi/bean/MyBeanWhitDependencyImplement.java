package com.fundamentos.platzi.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWhitDependencyImplement implements MyBeanWhitDependency{
    Log LOGGER = LogFactory.getLog(MyBeanWhitDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {

        LOGGER.info("Hemos ingresado al metodo PrinWithDependency");
        int number=5;
        LOGGER.error("Error");
        LOGGER.debug("Debug");
        System.out.println("Bean con dependencia SUMA:"+myOperation.sum(number));

    }
}
