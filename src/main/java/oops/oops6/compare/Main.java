package oops.oops6.compare;

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
    }

}
