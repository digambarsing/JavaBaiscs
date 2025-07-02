package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stockspan {
    public static void main(String[] args) {
        int[]ar={11, 4, 5, 90, 120, 80};

        System.out.println(Arrays.toString(stock(ar)));
        ArrayList<Integer>ans=stock2(ar);
        int i=0;

        while (i<ans.size()){
            System.out.println(ans.get(i));
            i++;
        }
    }

    private static ArrayList<Integer> stock2(int[] ar) {

        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<ar.length;i++){

            while (!s.isEmpty() && ar[i]>=ar[s.peek()]){
                s.pop();
            }
            ans.add(s.isEmpty() ? i + 1 : i - s.peek());


            s.push(i);
        }
        return ans;
    }

    private static int[] stock(int[] ar) {
        int[]ans=new int[ar.length];

        for (int i = ar.length-1; i >=0 ; i--) {
            int count=0;
            for (int j = i; j >=0 ; j--) {
                if (ar[i]>=ar[j] ){
                    count++;
                }else{
                    break;
                }

            }
            ans[i]=count;

        }
        return ans;
    }
}
