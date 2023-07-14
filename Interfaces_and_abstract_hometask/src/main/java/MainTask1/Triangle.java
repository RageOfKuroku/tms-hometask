package MainTask1;

public class Triangle extends Figure{
    double side1;
    double side2;
    double side3;
    double heigth;

    public Triangle(double side1, double side2, double side3, double heigth) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.heigth = heigth;
    }
    public double square(){
        System.out.println("Треугольник - площадь");
        return 0.5 * side3 * heigth;
    }
    public double perimeter(){
        System.out.println("Треугольник - периметр");
        return side1 + side2 + side3;
    }
    public double perimeter1(){
        return side1 + side2 + side3;
    }
}
