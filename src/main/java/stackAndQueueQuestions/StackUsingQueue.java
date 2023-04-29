package stackAndQueueQuestions;
import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/implement-stack-using-queues/
public class StackUsingQueue {

    Queue<Integer> main;
    Queue<Integer> helper;
    public StackUsingQueue() {
        main = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public void push(int x) {
        while(!main.isEmpty()){
            helper.add(main.poll());
        }
        main.add(x);
        while(!helper.isEmpty()){
            main.add(helper.poll());
        }

    }

    public int pop() {
        return main.poll();
    }

    public int top() {
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }



}
