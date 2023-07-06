package oops.oops3.polymorphism;

public class Number {
    int sum(int a, int b){
        return a + b;
    }
    /*
    int sum(String a, int b){
        return a + b;
    }

    int sum (int a, String b){
        return a + b;
    }

     */
    int sum(int a, int b, int c){
        return a + b + c;
    }

    int sum(double a, double b){
        return (int)(a + b);
    }

    public static void main(String[] args) {
        Number obj = new Number();
        obj.sum(1,2);
        obj.sum(1.0, 2);
        obj.sum(1,2,3);
    }
}
