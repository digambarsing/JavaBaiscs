package Goldman.Medium.BeautifulArrangement;

public class optimize {
   static int res=0;
    public static void main(String[] args) {
        int n=2;

        backtrack(1,n,new int[n+1]);
        System.out.println(res);
    }

    private static void backtrack(int pos, int n, int[] usedValueArr) {

        if (pos>n){
            res++;
            return;

        }
        for (int i = 1; i <= n; i++) {
            if (usedValueArr[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                usedValueArr[i] = 1;
                backtrack(pos+1, n, usedValueArr);
                usedValueArr[i] = 0;
            }
        }
    }
}
