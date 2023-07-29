package oops.oops4.access;

public class Main {
    public static void main(String[] args) {
        A obj = new A(10, "Akash");
        //obj.num; //Not allowed as num is private

        System.out.println(obj.getNum());
        obj.setNum(12);
        System.out.println(obj.getNum());
    }
}
