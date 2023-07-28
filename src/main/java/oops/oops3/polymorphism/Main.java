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
        //As reference(Shape) will determine what all value it will access, but the object-type(Square) will determine
        //which method to call.
        //So here Shape determined that obj6 can access area(), but Square will determine whose area() to call,
        //If we don't have area() in the Shape class then it will give error


    }
}
