package oops.oops5.abstractDemo;

public abstract class Parent {
    int age;
    Parent(int age){
        this.age = age;
    }
    abstract void career();
    abstract void partner();

    //Static method in Abstract Class
    static void iAmStatic(){
        System.out.println("I'm Static method in an Abstract class named Parent");
    }

    //Normal method in abstract class
    void normal(){
        System.out.println("This is a normal method in abstract class Parent");
    }
}
