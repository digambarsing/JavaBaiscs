package Stack;

import java.util.Stack;

public class ItoPost {
    public static void main(String[] args) {
        String s="A*(B+C)/D";

        System.out.println(help(s));
    }

    private static String help(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);

            if (Character.isLetterOrDigit(ch)){
                sb.append(ch);
            } else if (ch=='(') {
                st.push(ch);
            } else if (ch==')') {
                while (!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }else {
                while (!st.isEmpty() && prec(ch)<=prec(st.peek())){
                    sb.append(st.pop());
                }
                st.push(ch);

            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private static int prec(char c) {
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }
}
