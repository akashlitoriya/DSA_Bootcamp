package stackAndQueue;
import java.util.Stack;
public class StackCollection {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println(stack.peek());
        stack.push("(");
        stack.push("{");
        stack.push("}");
        stack.push(")");
        System.out.println(stack.toString());
        stack.pop();
        System.out.println("Peek : " + stack.peek());
        System.out.println(stack.empty());



    }
}
