package Goldman.Medium.LongestWord;

public class brute {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] ar = {"ale", "apple", "monkey", "plea"};

        int len = 0;
        String ans = "";

        for (String a : ar) {
            if (perm(s, a, s.length(), a.length())) {
                if (a.length() > len) {
                    len = a.length();
                    ans = a;
                } else if (a.length() == len && a.compareTo(ans) < 0) {
                    ans = a;
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean perm(String s, String a, int m, int n) {
        if (n == 0) {
            return true;
        }
        if (m == 0) {
            return false;
        }

        if (s.charAt(m - 1) == a.charAt(n - 1)) {
            return perm(s, a, m - 1, n - 1);
        }
        return perm(s, a, m - 1, n);
    }
}
