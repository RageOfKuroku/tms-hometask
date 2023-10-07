package AbstractFactory.product;

import AbstractFactory.Interface.ProductA;

public class ConcreteProductA1 implements ProductA {
    @Override
    public void doSomethingA() {
        System.out.println("ConcreteProductA1 is doing something A.");
    }
}
