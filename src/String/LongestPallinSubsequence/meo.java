package String.LongestPallinSubsequence;

public class meo {
    public static void main(String[] args) {
        String s="bbbab";
        int[][]dp=new int[s.length()][s.length()];
        System.out.println(pall(s,0,s.length()-1,dp));

    }

    private static int pall(String s, int i, int j, int[][] dp) {
        if (i>j) return 0;
        if (i==j) return 1;
        if (dp[i][j]!=0){
            return dp[i][j];
        }
        if (s.charAt(i)==s.charAt(j)){
            return 2+pall(s,i+1,j-1,dp);
        }else{
            return dp[i][j]= Math.max(pall(s,i+1,j,dp),pall(s,i,j-1,dp));
        }
    }
}
