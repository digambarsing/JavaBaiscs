package String.LongestPallinSubsequence;

public class rec {
    public static void main(String[] args) {
        String s="bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

        public static int longestPalindromeSubseq(String s) {
            return helper(s, 0, s.length() - 1);
        }

        private static int helper(String s, int left, int right) {
            if (left > right) return 0;
            if (left == right) return 1;

            if (s.charAt(left) == s.charAt(right)) {
                return 2 + helper(s, left + 1, right - 1);
            } else {

                return Math.max(
                        helper(s, left + 1, right),
                        helper(s, left, right - 1)
                );
            }
        }


}
