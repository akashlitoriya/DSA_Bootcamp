package oops.oops6.compare;

public class Student implements Comparable<Student>{
    int roll_no;
    double marks;
    Student(int roll_no, double marks){
        this.roll_no = roll_no;
        this.marks = marks;
    }

    public int compareTo( Student o){
        return (int)(this.marks - o.marks);
    }

}
