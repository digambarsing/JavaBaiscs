package Stack;

import java.util.Stack;

public class Mini {
     // minimum number of brackets required to balanced string.

    public static void main(String[] args) {
        String s="()())))(()";

        System.out.println(count(s));
    }

    private static int count(String s) {

        Stack<Character> st=new Stack<>();
        int closedunmatch=0;

        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (ch=='('){
                st.push(ch);
            }else{
                if (st.isEmpty()) closedunmatch++;
                else{
                    st.pop();
                }
            }

        }
        return closedunmatch+st.size();

    }
}
