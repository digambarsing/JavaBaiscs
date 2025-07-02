package ArrayCracking;

import java.util.Arrays;

public class ProductSelf {
    public static void main(String[] args) {
        int[]ar={1,2,3,4};
//        int prod=1;
//        for (int i = 0; i < ar.length; i++) {
//            prod*=ar[i];
//        }
//        for (int i = 0; i < ar.length; i++) {
//            ar[i]=prod/ar[i];
//        }
//        System.out.println(Arrays.toString(ar));
   print(ar);

//        int[]ans=new int[ar.length];
//        int k=0;
//
//
//        for (int i = 0; i < ar.length; i++) {
//            int prod=1;
//            for (int j = 0; j < ar.length; j++) {
//                if (i!=j){
//                    prod*=ar[j];
//                }
//            }
//            ans[k++]=prod;
//        }System.out.println(Arrays.toString(ans));
    }

    private static void print(int[] ar) {
        int n=ar.length;
        int []l=new int[n];
        int []r=new int[n];
        int []a=new int[n];

        l[0]=1;
        r[n-1]=1;

        for (int i = 1; i < n; i++) {
            l[i]=l[i-1]*ar[i-1];
        }
        System.out.println(Arrays.toString(l));
        for (int i = n-2; i >=0 ; i--) {
            r[i]=r[i+1]*ar[i+1];
        }
        System.out.println(Arrays.toString(r));


        for (int i = 0; i < n; i++) {
            a[i]=l[i]*r[i];
        }
        System.out.println(Arrays.toString(a));

    }
}
