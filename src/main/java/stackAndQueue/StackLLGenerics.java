package stackAndQueue;
import java.util.LinkedList;
public class StackLLGenerics <T>{
    private LinkedList<T> data;
    private int top;
    private int size;

    StackLLGenerics(LinkedList<T> data){
        this.data = data;
        this.top = -1;
        this.size = 0;
    }

    public void push(T data){
        if(top > this.data.size()){
            System.out.println("StackOverFlow");
            return ;

        }
        this.data.add(data);
        top++;
        size++;
    }

    public T pop(){
        if(top < 0){
            System.out.println("StackUnderFlow");
            return null;
        }
        T val = this.data.get(top);
        top--;
        size--;
        return val;
    }

    public T peek(){
        if(top < 0){
            System.out.println("Stack is Empty");
            return null;
        }
        return this.data.get(top);
    }

    public boolean isEmpty(){
        return (top < 0)? true: false;
    }
    public int getSize(){
        return this.size;
    }
    public void print(){
        int i = top;
        System.out.print("TOP --> ");
        while(i >= 0 ){
            System.out.print(data.get(i) + " --> ");
            i--;
        }
        System.out.print(" END");
        System.out.println();
    }

    public static void main(String[] args) {
        StackLLGenerics<Integer> stack = new StackLLGenerics<>(new LinkedList<Integer>());
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        StackLLGenerics<String> stackStr = new StackLLGenerics<>(new LinkedList<String>());
        stackStr.push("Hello");
        stackStr.push("World");
        stackStr.push("in");
        stackStr.push("Java");
        stackStr.print();

    }

}
