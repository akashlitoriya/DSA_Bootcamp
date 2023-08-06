package oops.oops6.cloning;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;
    Human(int age, String name){
        this.age = age;
        this.name = name;
        this.arr = new int[]{1,2,3,4,5,6};
    }
    Human(Human obj){
        this.age = obj.age;
        this.name = obj.name;
    }
//    public Object clone() throws CloneNotSupportedException{
//        //This is shallow copy
//        return super.clone();
//    }

    public Object clone() throws CloneNotSupportedException{
        Human twin = (Human)super.clone(); //This is shallow Copy
        //From here we will do deep copy
        twin.arr = new int[twin.arr.length];
        for(int i = 0; i < twin.arr.length; i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
