
package ArrayCracking;
import java.util.*;

public class remove_prefix {
    public static void main(String[] args) {
        int[] arr1 ={1, 2, 3, 4, 5};
       int [] arr2 = {1,4,3,2,4};
      int k= 3;
      print(arr1,arr2,k);
    }

    private static void print(int[] arr1, int[] arr2, int k) {
        HashSet<Integer>Set=new HashSet<>();
        for (int i = 0; i < k; i++) {
            Set.add(arr1[i]);
        }
        int c=0;

        for (int i = 0; i < arr2.length; i++) {
            if(Set.contains(arr2[i]) && c<k){
                continue;
            }
            System.out.print(arr2[i]+" ");
            c++;
        }
    }


}
