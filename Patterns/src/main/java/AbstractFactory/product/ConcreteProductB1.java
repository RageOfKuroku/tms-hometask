package AbstractFactory.product;

import AbstractFactory.Interface.ProductB;

public class ConcreteProductB1 implements ProductB {
    @Override
    public void doSomethingB() {
        System.out.println("ConcreteProductB1 is doing something B.");
    }
}
