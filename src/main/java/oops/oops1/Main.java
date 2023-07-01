package oops.oops1;

public class Main {

    public static void main(String[] args) {
        //Store marks of 5 students;
        int marks[] = new int[5];
        //Store students details
        Student akash = new Student();
        System.out.println(akash); //Garbage Value
        System.out.println(akash.rollno + " " + akash.name + " " + akash.marks);
        akash.rollno = 9;
        akash.name = "Akash";
        akash.marks = 8.5f;
        System.out.println(akash.rollno + " " + akash.name + " " + akash.marks);

        //Changing name;
        akash.greeting(); //This is a Akash
        akash.changeName("Akash Litoriya");
        akash.greeting(); //This is a Akash Litoriya

        //Constructor without this keyword Result
        Student kunal = new Student(1, "Kunal", 85.9f);
        System.out.println(kunal.rollno + " " + kunal.name + " " + kunal.marks);

        //Instantiating object by another object
        Student rahul = new Student(akash);
        System.out.println(rahul.rollno + " " + rahul.name + " " + rahul.marks);

        //Two reference variable pointing to same object
        Student one = new Student();
        Student two = one;
        two.name = "Litto";
        System.out.println(one.name); //Litto

    }
}
class Student{
    int rollno;
    String name;
    float marks;

    //Constructor
    Student(){
        //This is how we can call a constructor from another constructor
        //here :- Student(0, "default Name", 100f);
        this(0, "default Name", 100f);
    }
    //Student arpit = new Student(1, "Arpit", 90.5f);
    //here 'this' keyword will be replaced by 'arpit'
    Student(int rollno, String name, float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }
    Student(Student obj){
        this.rollno = obj.rollno;
        this.name = obj.name;
        this.marks = obj.marks;
    }

    void greeting(){
        System.out.println("This is a " + name);

    }
    void changeName(String newName){
        name = newName;
    }
}
