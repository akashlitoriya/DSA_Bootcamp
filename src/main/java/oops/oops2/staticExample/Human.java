package oops.oops2.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;

    static long population;

    Human(int age, String name, int salary, boolean married){
        this.age= age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // this.population += 1; //Never refer to static variable using 'this' keyword
        Human.population += 1;
    }

    static void message(){
        System.out.println("This is a static-message() inside Human");
        //System.out.println(this.age); //This is not allowed
    }
}
