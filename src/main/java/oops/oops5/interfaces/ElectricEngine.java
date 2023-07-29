package oops.oops5.interfaces;

public class ElectricEngine implements Engine{
    public void start(){
        System.out.println("Electric Engine start");
    }
    public void stop(){
        System.out.println("Electric Engine stop");
    }
    public void accelerate(){
        System.out.println("Electric Engine Accelerate");
    }
}
