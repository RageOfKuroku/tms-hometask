package MainTask1;

public class Rectangle extends Figure{
    double side1;
    double side2;
    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    public double square(){
        System.out.println("Прямоугольник - площадь");
        return side1 * side2;
    }
    public double perimeter(){
        System.out.println("Прямоугольник - периметр");
        return (side1+side2)*2;
    }
    public double perimeter1(){
        return (side1+side2)*2;
    }
}
