package oops.oops6.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human akash = new Human(19, "Akash Litoriya");
        Human sparsh = new Human(akash);

        Human twin = (Human)akash.clone();
        System.out.println(twin.name + " " + twin.age);
        System.out.println(Arrays.toString(twin.arr));

        twin.arr[0] = 100;
        System.out.println(Arrays.toString(akash.arr));
        System.out.println(Arrays.toString(twin.arr));
    }
}
