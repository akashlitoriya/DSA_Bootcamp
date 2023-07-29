package oops.oops5.abstractDemo;

public class Daughter extends Parent{
    Daughter(int age){
        super(age);
    }

    void career(){
        System.out.println("I am going to be a Model");
    }
    void partner(){
        System.out.println("I am going to marry Bruce Wayne, coz he is everybodies Batman");
    }

    void normal(){
        System.out.println("Overrided the normal method of Parent in daughter");
    }
}
