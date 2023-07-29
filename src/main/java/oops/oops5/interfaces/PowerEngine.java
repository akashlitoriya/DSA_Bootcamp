package oops.oops5.interfaces;

public class PowerEngine implements Engine{
    public void start(){
        System.out.println("Power Engine start");
    }
    public void stop(){
        System.out.println("Power Engine stop");
    }
    public void accelerate(){
        System.out.println("Power Engine accelerate");
    }
}
