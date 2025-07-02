package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int[]ar={6,8,0,1,3};
        int[]res=new int[ar.length];
        Arrays.fill(res,-1);
        nge(ar,res);
    }

    private static void nge(int[] ar, int[] res) {
        Stack<Integer>st=new Stack<>();


        for (int i = ar.length-1; i >=0; i--) {

            while (!st.isEmpty() && st.peek()<=ar[i]){
                st.pop();
            }

            if (!st.isEmpty()){
                res[i]=st.peek();
            }
            st.push(ar[i]);

        }

        System.out.println(Arrays.toString(res));
    }
}
