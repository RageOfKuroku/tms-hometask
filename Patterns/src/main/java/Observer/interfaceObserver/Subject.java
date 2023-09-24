package Observer.interfaceObserver;

import Observer.interfaceObserver.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
