package oops.oops4.access;

public class A {
    private int num;
    String name;
    int[] arr;
    A(int num, String name){
        this.num = num;
        this.name = name;
        arr = new int[num];
    }
    public int getNum(){
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
}
