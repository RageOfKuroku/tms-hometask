package Iterator.service;

import Iterator.interfaceIterator.MyIterator;

import java.util.List;
import java.util.NoSuchElementException;

public class ConcreteIterator<T> implements MyIterator<T> {
    private List<T> items;
    private int position = 0;

    public ConcreteIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T item = items.get(position);
        position++;
        return item;
    }
}
