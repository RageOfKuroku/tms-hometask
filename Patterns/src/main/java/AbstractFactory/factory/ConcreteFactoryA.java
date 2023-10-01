package AbstractFactory.factory;

import AbstractFactory.Interface.AbstractFactory;
import AbstractFactory.Interface.ProductA;
import AbstractFactory.Interface.ProductB;
import AbstractFactory.product.ConcreteProductA1;
import AbstractFactory.product.ConcreteProductB1;

public class ConcreteFactoryA implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
