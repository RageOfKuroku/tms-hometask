import interfacesAndAbstractions.Coffee;
import service.MilkDecorator;
import service.SimpleCoffee;
import service.SugarDecorator;

public class Main {
    public static void main(String[] args) {
        // Создаем простой кофе
        Coffee coffee = new SimpleCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.cost());

        // Добавляем молоко к кофе с помощью декоратора
        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Description: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.cost());

        // Добавляем сахар к кофе с молоком с помощью декоратора
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Description: " + sugarMilkCoffee.getDescription());
        System.out.println("Cost: $" + sugarMilkCoffee.cost());
    }
}
