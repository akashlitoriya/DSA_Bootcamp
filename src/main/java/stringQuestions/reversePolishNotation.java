package stringQuestions;

import java.util.Stack;

public class reversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int value = 0;
        int i = 0;
        while(i < tokens.length){
            char ch = '0';
            if(tokens[i].length() == 1){
                ch = tokens[i].charAt(0);
            }
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                evaluate(st, ch);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return st.pop();
    }
    private static void evaluate(Stack<Integer> st, char ch){
        int num2 = st.pop();
        int num1 = st.pop();
        if(ch == '+'){
            st.push(num1 + num2);
        }else if(ch == '-'){
            st.push(num1-num2);
        }else if(ch == '*'){
            st.push(num1 * num2);
        }else{
            st.push(num1 / num2);
        }
    }
    public static void main(String[] args) {
        String[] st = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(st));
    }
}
