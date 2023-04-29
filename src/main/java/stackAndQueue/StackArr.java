package stackAndQueue;

public class StackArr<T> {
    private int top;
    private int size;
    private T data[];
    StackArr(T arr[]){
        this.data = arr;
        this.size = arr.length;
        top = -1;
    }
    public void push(T val){
        if(top < size - 1){
            top++;
            data[top] = val;
        }else{
            System.out.println("StackOverFlow");
        }
    }

    public T pop(){
        T a = null;
        if(top < 0){
            System.out.println("StackUnderFlow");
            return a;
        }else{
            a = data[top];
            top--;
        }
        return a;
    }

    public boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;
    }

    public T peek(){
        T a = null;
        if(top < 0){
            System.out.println("StackUnderFlow");
            return a;
        }
        return data[top];
    }

    public void print(){
        int i = top;
        System.out.print("TOP --> ");
        while(i >= 0){
            System.out.print(data[i] + " --> ");
            i--;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        StackArr<Integer> stack = new StackArr<>(new Integer[10]);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
        stack.push(5);
        System.out.println("Stack empty : " + stack.isEmpty());
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.print();
    }
    
}
