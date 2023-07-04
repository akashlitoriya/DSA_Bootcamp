package oops.oops2.singletonClass;

public class Main {
    public static void main(String[] args) {
        //Singleton obj = new Singleton(); // This is not allowed

        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
    }
}
