package Stack;

import java.util.Stack;

public class PostFix {
    public static void main(String[] args) {
        String exp = "231*+9-";

        // Function call
        System.out.println("postfix evaluation: "
                + evaluatePostfix(exp));
    }

    private static int evaluatePostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
//                st.push(Integer.parseInt(String.valueOf(ch)));

                st.push(ch - '0');
            } else {
                int b = st.pop();
                int a = st.pop();
                switch (ch) {

                    case '+':
                        st.push(a + b);
                        break;
                    case '-':
                        st.push(a - b);
                        break;
                    case '*':
                        st.push(a * b);
                        break;
                }


            }
        }
        return st.pop();
    }
}

