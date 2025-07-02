package ArrayCracking;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        List<int[]> res = mergeOverlap(arr);

        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private static List<int[]> mergeOverlap(int[][] arr) {
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0] ));

        ans.add(new int[]{arr[0][0],arr[0][1]});
        for (int i = 1; i < arr.length; i++) {
            int[] last=ans.get(ans.size()-1);
            int[] curr=arr[i];

            if (curr[0]<=last[1]){
                last[1]=Math.max(curr[1],last[1] );
            }else{
                ans.add(new int[]{curr[0],curr[1]});
            }
        }
        return ans;
    }

//    private static List<int[]> mergeOverlap(int[][] arr) {
//        List<int[]> res = new ArrayList<>();
//        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
//
//        for (int i = 0; i < arr.length; i++) {
//            int st = arr[i][0];
//            int ed = arr[i][1];
//
//            if (!res.isEmpty() && res.get(res.size() - 1)[1] >= ed) {
//                continue;
//            }
//
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j][0] <= ed) {
//                    ed = Math.max(ed, arr[j][1]);
//                }
//            }
//
//            res.add(new int[]{st, ed});
//        }
//        return res;
//    }
}

