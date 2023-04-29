package stackAndQueueQuestions;
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
import java.util.Stack;
public class MinAddForValidString {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = isValid(s);
        int count = 0;
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }


    public Stack isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    char expClose = findclose(stack.peek());
                    if(ch == expClose){
                        stack.pop();
                    }else{
                        stack.push(ch);
                    }
                }

            }
            i++;
        }
        return stack;
    }


    public char findclose(char open){
        char close;
        if(open == '('){
            close = ')';
        }else{
            close = '@';
        }
        return close;
    }
}
