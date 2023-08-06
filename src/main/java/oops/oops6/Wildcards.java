package oops.oops6;

import java.util.Arrays;

public class Wildcards <T extends Number>{
    private Object[] data;
    private static int default_size = 10;
    private int size = 0;
    public Wildcards(){
        this.data = new Object[default_size];
    }

    public void add(T num){
        if(this.isfull()){
            resize();
        }
        data[size++] = num;
    }
    private boolean isfull(){
        return size == data.length;
    }
    private void resize(){
        Object[] copy = new Object[data.length * 2];
        for(int i = 0; i < data.length; i++){
            copy[i] = data[i];
        }
        this.data = copy;
    }
    public T remove(){
        T removed = (T)data[--size];
        return removed;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void set(int index, T val){
        data[index] = val;
    }

    @Override
    public String toString() {
        return "CustomGenericArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Wildcards<Integer> l1 = new Wildcards<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);

        System.out.println(l1);

       // Wildcards<String> l2 = new Wildcards<String>();  //Get compilation error Type Argument is not within bounds of type-Variable


    }
}