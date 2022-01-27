package com.fundamentos.platzi.bean;

public class MyBeanWhitDependencyImplement implements MyBeanWhitDependency{

    private MyOperation myOperation;

    public MyBeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {
        int number=5;
        System.out.println("Bean con dependencia SUMA:"+myOperation.sum(number));
    }
}
