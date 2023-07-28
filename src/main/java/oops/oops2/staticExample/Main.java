package oops.oops2.staticExample;

public class Main {
    public static void main(String[] args) {
        /*
        Here there is no need to import the Human class as they both lies in the same package
         */
        Human akash = new Human(22,"Akash", 100000, false);

        Human kunal = new Human(32, "Kunal", 100000, false);
        System.out.println(Human.population);
        System.out.println(Human.population);

//         greeting(); // This is not allowed as non-static things can't be used without creating object
    }
    //Does not depend on object
    static void fun(){
        //greeting();

        //explicitly referencing non-static method
        Main obj = new Main();
        obj.greeting();
    }
    void fun2(){
        greeting();
    }
    //Dependent on object
    void greeting(){
        System.out.println("Hello World");
    }
}
