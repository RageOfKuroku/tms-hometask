package Iterator.service;

import Iterator.interfaceIterator.MyIterator;
import Iterator.service.ConcreteIterator;

import java.util.ArrayList;
import java.util.List;

public class Aggregate<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public MyIterator<T> createIterator() {
        return new ConcreteIterator<>(items);
    }
}
