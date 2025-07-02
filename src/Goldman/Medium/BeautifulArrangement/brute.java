package Goldman.Medium.BeautifulArrangement;

import java.util.ArrayList;
import java.util.Collections;

public class brute {
    public static void main(String[] args) {
        int n=2;

        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        for (int i = 1; i <=n; i++) {
            ans.add(i);
        }

        count(ans,res,0);
        int count=0;

        for(ArrayList<Integer>perm:res){
            int[] permArray = perm.stream().mapToInt(i -> i).toArray();
            if (isBeautiful(permArray, n)) {
                count++;
            }
        }

        System.out.println(count);
        }

    private static boolean isBeautiful(int[] permArray, int n) {
        for (int i = 1; i <=n ; i++) {
            if (permArray[i-1]%i!=0 && i%permArray[i-1]!=0){
                return false;
            }
        }
        return true;
    }


    private static void count(ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res, int start) {
        if (start==ans.size()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = start; i <ans.size(); i++) {
            Collections.swap(ans,i,start);
            count(ans,res,start+1);
            Collections.swap(ans,i,start);

        }
    }
}
