package MainTask1;

public class Circle extends Figure{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    public double square(){
        System.out.println("Круг - площадь");
        return Math.PI * Math.pow(radius,2);
    }
    public double perimeter(){
        System.out.println("Круг - периметр");
        return 2 * Math.PI * radius;
    }
}
