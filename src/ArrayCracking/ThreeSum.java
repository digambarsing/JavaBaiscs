package ArrayCracking;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8};
        int target = 13;
        if (hasTripletSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println("-------------->");
        if (hasTripletSum2(arr, target))
            System.out.println("true2");
        else
            System.out.println("false2");
    }

    private static boolean hasTripletSum2(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        for (int i = 0; i < n-2; i++) {
            int l=i+1;
            int r=n-1;
            int c=target-arr[i];

            while (l<r){
                if (arr[l]+arr[r]==c){
                    return true;
                } else if (arr[l]+arr[r]<c) {
                    l++;
                }else{
                    r--;
                }
            }

        }
        return false;
    }

    private static boolean hasTripletSum(int[] arr, int target) {
        int n=arr.length;

        for (int i = 0; i < n-2; i++) {
            HashSet<Integer>set=new HashSet<>();
            for (int j = i+1; j < n; j++) {
                int c=target-arr[i]-arr[j];

                if (set.contains(c)){
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }
}
