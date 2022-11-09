package classesAndInterfaces.exercise1;

public class Square implements Shape {
    double length;

    public Square(double length, double width){
        this.length = length;
    }

    @Override
    public double area() {
        return length * length;
    }
}
