package Stack;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterEele {
    public static void main(String[] args) {
        int[]ar={6,8,0,1,3};

        Stack<Integer>st=new Stack<>();
        int[]ans=new int[ar.length];
        ans[ans.length-1]=-1;



        for(int i= ar.length-1;i>=0;i--){



                    while (!st.isEmpty() && st.peek()<ar[i]){
                        st.pop();
                    }


            ans[i] = st.isEmpty() ? -1 : st.peek();



            st.push(ar[i]);
        }

        System.out.println(Arrays.toString(ans));
    }
}
