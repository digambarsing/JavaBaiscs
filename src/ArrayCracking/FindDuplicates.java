package ArrayCracking;

import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {2, 10, 10, 100, 2, 10, 11, 2, 11, 2};

//        List<Integer> duplicates = findDuplicates(arr);
        List<Integer> duplicates = findDuplicates2(arr);

        for (int x : duplicates) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> findDuplicates2(int[] arr) {
        Arrays.sort(arr);
        List<Integer> res=new ArrayList<>();

        int i=0;
        while (i< arr.length){
            int first=boundary(arr,arr[i]);
            int last=boud(arr,arr[i])-1;

            if(last>first){
                res.add(arr[i]);
            }
            i=last+1;

        }

        return res;

    }

    private static int boud(int[] arr, int res) {
        int i=0; int j=arr.length;

        while (i<j){
            int mid=(i+j)/2;

            if (arr[mid]<=res){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return i;
    }

    private static int boundary(int[] arr,int res) {

        int i=0; int j=arr.length;

        while (i<j){
            int mid=(i+j)/2;

            if (arr[mid]<res){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return i;
    }

    private static List<Integer> findDuplicates(int[] arr) {
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]==arr[j]){
                    if(!res.contains(arr[i]))
                         res.add(arr[i] );
                }
            }
        }
        return res;
    }
}
