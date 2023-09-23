
import AbstractFactory.Interface.AbstractFactory;
import AbstractFactory.factory.ConcreteFactoryA;
import AbstractFactory.Interface.ProductA;
import AbstractFactory.Interface.ProductB;
import Iterator.service.Aggregate;
import Iterator.interfaceIterator.MyIterator;
import Observer.service.ConcreteObserver;
import Observer.service.ConcreteSubject;
import Observer.interfaceObserver.Observer;
import Observer.interfaceObserver.Subject;
import Singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        // Пример Singleton
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println("Is singleton1 the same instance as singleton2? " + (singleton1 == singleton2));

        // Пример Abstract Factory
        AbstractFactory factory1 = new ConcreteFactoryA();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();


        productA1.doSomethingA();
        productB1.doSomethingB();


        // Пример Observer
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("Hello, observers!");

        // Пример Iterator
        Aggregate<String> aggregate = new Aggregate<>();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        MyIterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
