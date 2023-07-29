package oops.oops5.interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate();
        car.brake();
        car.start();

        Engine carEng = new Car();  // Explained in overriding
//        carEng.a;  // 'a' is present in car class

        Media carMed = new Car();
        carMed.start();


        //Nice Car
        NiceCar car1 = new NiceCar();
        car1.start();
        car1.startMusic();

        NiceCar car2 = new NiceCar(new ElectricEngine());
        car2.start();
        car2.startMusic();
    }
}
