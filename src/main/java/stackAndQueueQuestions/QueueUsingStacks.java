package stackAndQueueQuestions;


import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
// 232
public class QueueUsingStacks<T> {
    private Stack<T> main;
    private Stack<T> helper;

    QueueUsingStacks(){
        this.main = new Stack<>();
        this.helper = new Stack<>();
    }

    public void push(T data){
        main.push(data);
    }

    public T pop(){
        while(main.isEmpty()){
            helper.push(main.pop());

        }
        T popped = helper.pop();
        while(helper.isEmpty()){
            main.push(helper.pop());
        }
        return popped;
    }

    public T peek(){
        while(main.isEmpty()){
            helper.push(main.pop());
        }
        T peek = helper.peek();
        while(helper.isEmpty()){
            main.push(helper.pop());
        }
        return peek;
    }

    public boolean empty(){
        return main.empty();
    }

    public void print(){

    }

    public static void main(String[] args) {

    }
}
