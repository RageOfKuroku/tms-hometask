package service;

import interfacesAndAbstractions.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple interfacesAndAbstractions.Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
