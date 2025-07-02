package ArrayCracking.Trapping;

import java.util.Arrays;

public class Trap {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWater(arr));
        System.out.println(maxWater2(arr));
        System.out.println(ptimize(arr));

    }

    private static int ptimize(int[] arr) {
        int res=0;
        int l=1;
        int r=arr.length-2;

        int lm=arr[l-1];
        int rm=arr[r+1];

        while (l<=r){

            if (rm<=lm){
                res+=Math.max(0,rm-arr[r]);

                rm=Math.max(rm,arr[r]);
                r--;
            }else{
                res+=Math.max(0,lm-arr[l]);

                lm=Math.max(lm,arr[l]);
                l++;
            }
        }
        return res;

    }

    private static int maxWater2(int[] arr) {

        int res=0;
        int[] l=new int[arr.length];
        int[] r=new int[arr.length];
        l[0]=arr[0];

        for (int i = 1; i < arr.length; i++) {
            l[i]=Math.max(l[i-1],arr[i] );
        }

        System.out.println(Arrays.toString(l));

        r[arr.length-1]=arr[arr.length-1];

        for (int i = arr.length-2; i >=0 ; i--) {
            r[i]=Math.max(arr[i],r[i+1]);
        }

        System.out.println(Arrays.toString(r));

        for (int i = 1; i < arr.length - 1; i++) {
            int waterLevel = Math.min(l[i-1], r[i+1]); // Get the minimum of left max and right max
            if (waterLevel > arr[i]) { // Water is trapped only if water level is above current height
                res += waterLevel - arr[i];
            }
        }
        return res;


    }

    private static int maxWater(int[] arr) {
        int res=0;

        for (int i = 1; i < arr.length-1; i++) {

            int left= arr[i];

            for (int j = 0; j < i; j++) {

                left=Math.max(left,arr[j]);
            }
            int right=arr[i];

            for (int j = i+1; j < arr.length; j++) {

                right=Math.max(right,arr[j]);
            }


            res+=Math.min(left,right)-arr[i];


        }
        return res;
    }
}
