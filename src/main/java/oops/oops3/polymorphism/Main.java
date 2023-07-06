package oops.oops3.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape obj1 = new Shape();
        Square obj2 = new Square();
        Rectangle obj3 = new Rectangle();
        Circle obj4 = new Circle();
        Triangle obj5 = new Triangle();

        Shape obj6 = new Square();

        obj1.area();
        obj2.area();
        obj3.area();
        obj4.area();
        obj5.area();

        obj6.area();  //This will call area() in Square. WHY??
        //


    }
}
