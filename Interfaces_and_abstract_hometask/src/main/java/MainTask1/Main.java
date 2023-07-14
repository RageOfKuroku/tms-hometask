package MainTask1;

public class Main {
    public static void main(String[] args) {
        Figure figure1 = new Circle(15);
        Figure figure2 = new Rectangle(16,5);
        Figure figure3 = new Triangle(15,15,16,15);
        Figure figure4 = new Circle(20);
        Figure figure5 = new Rectangle(16,16);
        int sumOfPerimeters = 0;

        Figure[] figures = {figure1,figure2,figure3,figure4,figure5};
        System.out.println("Периметры: ");
        for (Figure figure: figures) {
            System.out.println(figure.perimeter() + "\n");
        }
        System.out.println("Площади");
        for (Figure figure: figures) {
            System.out.println(figure.square() + "\n");
        }
        for(int i = 0; i < figures.length; i++) {
            sumOfPerimeters += figures[i].perimeter1();
        }
        System.out.println("Сумма всех периметров равна: " + sumOfPerimeters);
    }


}
