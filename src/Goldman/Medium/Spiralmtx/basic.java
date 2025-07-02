package Goldman.Medium.Spiralmtx;

import java.util.ArrayList;

public class basic {
    public static void main(String[] args) {
        int[][] ar = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        ArrayList<Integer> ans = new ArrayList<>();
        spiral(ar, 3, 3, ans);
        System.out.println(ans);
    }

    private static void spiral(int[][] ar, int r, int c, ArrayList<Integer> ans) {
        int tr = 0;
        int lc = 0;
        int br = r - 1;
        int rc = c - 1;

        while (tr <= br && lc <= rc) {
            for (int i = lc; i <= rc; i++) {
                ans.add(ar[tr][i]);
            }
            tr++;

            for (int i = tr; i <= br; i++) {
                ans.add(ar[i][rc]);
            }
            rc--;

            if (tr <= br) {
                for (int i = rc; i >= lc; i--) {
                    ans.add(ar[br][i]);
                }
                br--;
            }

            if (lc <= rc) {
                for (int i = br; i >= tr; i--) {
                    ans.add(ar[i][lc]);
                }
                lc++;
            }
        }
    }
}
