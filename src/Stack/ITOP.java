package Stack;

import java.util.Stack;

public class ITOP {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        Stack<Character> st=new Stack<>();
        StringBuilder ans=new StringBuilder();

        for(char ch:exp.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                ans.append(ch);
            } else if (ch=='(') {
                st.push(ch);
            } else if (ch==')') {
                while (!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                while (!st.isEmpty() && prec(ch)<=prec(st.peek())){
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.toString();
    }

    private static int prec(char ch) {
        if (ch=='^') return 3;
        else if (ch=='/' || ch=='*') {
            return 2;

        } else if (ch=='-' || ch=='+') {
            return 1;
        }else{
            return -1;
        }
    }
}
