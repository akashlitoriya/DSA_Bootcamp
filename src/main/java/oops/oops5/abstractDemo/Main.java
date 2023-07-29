package oops.oops5.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(22);
        son.career();  //Son's Career()
        son.partner(); //Son's Partner()

        Daughter dau = new Daughter(21);
        dau.career(); //Dau's Career()
        dau.partner(); //Dau's Partner()

//        Parent parent = new Parent(); This is not allowed for abstract classes

        //Calling Static method in Parent
        Parent.iAmStatic();

        //Calling Parent's Normal method
        son.normal();
        dau.normal();
    }
}
