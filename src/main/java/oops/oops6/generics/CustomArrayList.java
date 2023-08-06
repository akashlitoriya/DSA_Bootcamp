package oops.oops6.generics;

public class CustomArrayList {
    private int[] data;
    private static int default_size = 10;
    private int size = 0;
    public CustomArrayList(){
        this.data = new int[default_size];
    }
    public void add(int num){
        if(this.isfull()){
            resize();
        }
        data[size++] = num;
    }
    private boolean isfull(){
        return size == data.length;
    }
    private void resize(){
        int[] copy = new int[data.length * 2];
        for(int i = 0; i < data.length; i++){
            copy[i] = data[i];
        }
        this.data = copy;
    }
    public int remove(){
        int removed = data[--size];
        return removed;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void set(int index, int val){
        data[index] = val;
    }


    public static void main(String[] args) {

    }
}
