package oops.oops6.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomGenericArrayList <T>{
    private Object[] data;
    private static int default_size = 10;
    private int size = 0;
    public CustomGenericArrayList(){
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
        CustomGenericArrayList<Integer> list = new CustomGenericArrayList<>();
        list.add(45);
        list.add(3);
        list.add(4);
        System.out.println(list);

        CustomGenericArrayList<String> list1 = new CustomGenericArrayList<>();
        list1.add("Akash");
        list1.add("litoriya");
        list1.add("Kumar");
    }
}
