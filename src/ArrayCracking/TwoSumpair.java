package ArrayCracking;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSumpair {
    public static void main(String[] args) {

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");

        if (twoSum2(arr, target))
            System.out.println("true2");
        else
            System.out.println("false2");

        if (twoSum3(arr, target))
            System.out.println("true3");
        else
            System.out.println("false3");


        // last one is using hashset to solve it;
        // in this we learn about complement=target-arr[i]
    }

    private static boolean twoSum3(int[] arr, int target) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            int comp=target-arr[i];
            if (set.contains(comp)){
                return true;
            }

            set.add(arr[i]);

        }
        return false;


    }

    private static boolean twoSum2(int[] arr, int target) {
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;

        while (i<j){
            if (arr[i]+arr[j]==target){
                return true;
            } else if (arr[i]+arr[j]<target) {
                i++;
            }else{
                j--;
            }
        }
        return false;
   }


    private static boolean twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i]+arr[j]==target) return true;
            }
        }
        return false;
    }
}
