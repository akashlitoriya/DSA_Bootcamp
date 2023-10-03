package oops.oops6.compare;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(9, 85);
        Student s2 = new Student(9,70);
//        this will give error so we will use Comparable interface
//        if(s1 < s2) {
//            System.out.println("s1 less than s2");
//        }

        //Using compareTo() of Comparable Interface
        if(s1.compareTo(s2) > 0){
            System.out.println("S1 is greater than S2");
        }else if(s1.compareTo(s2) == 0){
            System.out.println("S1 is equals to S2");
        }
        else{
            System.out.println("S2 is greater than S1");
        }

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(new Student(10,75));
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i).marks + " ,");
        }
    }

}
