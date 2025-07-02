package ArrayCracking;

import java.util.Arrays;

public class MINJUMP {
    public static void main(String[] args) {
        int[] arr = {1,4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
        int ans=mi(arr,0);
        if (ans==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

        int[]dp=new int[arr.length];
        int n= arr.length;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;

        for (int i = n-2; i >=0 ; i--) {
            for (int j = i+1; j <=i+arr[i] && j<n ; j++) {
                if (dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[j]);
                }
            }

        }
        System.out.println(dp[0]);

    }

    private static int mi(int[] arr, int i) {
        if (i>= arr.length-1) return 0;
        int ans=Integer.MAX_VALUE;
        for (int j = i+1; j <=i+arr[i] ; j++) {
            int val=mi(arr,j);
            if (val!=Integer.MAX_VALUE){
                ans=Math.min(ans,val+1);
            }

        }
        return ans;
    }

    private static int minJumps(int[] arr) {
        int ms=0;
        int cs=0;
        int j=1;

        int n= arr.length;
        if (arr[0]==0) return -1;

        for (int i = 0; i < arr.length; i++) {
            ms=Math.max(ms,i+arr[i]);
            if (ms>=n-1) return j;

            if (i==cs){

                if(i==ms) return -1;
                else{
                    cs=ms;
                    j++;
                }
            }
        }
        return j;
    }
}
