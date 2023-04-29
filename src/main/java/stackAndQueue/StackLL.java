package stackAndQueue;
import java.util.LinkedList;
public class StackLL {
    private LinkedList<Integer> data;
    private int top;
    StackLL(){
        this.data = new LinkedList<>();
        this.top = -1;
    }

    public void push(int val){
        if(top == data.size()){
            System.out.println("Stack OverFlow");
            return;
        }
        data.add(val);
        top++;
    }

    public int pop(){
        if(top < 0){
            System.out.println("Stack UnderFlow");
            return -1;
        }
        int a = data.get(top);
        data.remove(top);
        top--;
        return a;
    }

    public boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;
    }

    public int peek(){
        if(top < 0){
            System.out.println("Stack is Empty");
            return -1;
        }
        return data.get(top);
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        int i = top;
        System.out.print("TOP --> ");
        while(i > -1){
            System.out.print(data.get(i) + " --> ");
            i--;
        }
        System.out.print(" END");
        System.out.println();

    }

    public static void main(String[] args) {
        StackLL stack = new StackLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        System.out.println(stack.peek());
        stack.pop();
        stack.print();
    }
}
