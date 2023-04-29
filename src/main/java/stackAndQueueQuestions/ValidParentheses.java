package stackAndQueueQuestions;

import java.util.Stack;
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char expClose = findclose(stack.peek());
                if(ch == expClose){
                    stack.pop();
                }else{
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty()?true:false;
    }
    public char findclose(char open){
        char close;
        if(open == '('){
            close = ')';
        }else if(open == '{'){
            close = '}';
        }else{
            close = ']';
        }
        return close;
    }
}
