package classesAndInterfaces.exercise1;

public class Circle implements Shape{
    double radius;

    public Circle(double radius){
            this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }
}
