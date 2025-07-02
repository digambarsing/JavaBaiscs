package String.LongestpallSubstring;

public class brute {
    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(longestPalindrome(s));

    }

        public static String longestPalindrome(String s) {
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    String str = s.substring(i, j + 1);
                    if (isPall(str)) {
                        if (str.length() > ans.length()) {
                            ans = str;
                        }
                    }
                }
            }
            return ans;
        }

        public static boolean isPall(String str) {
            int i = 0;
            int j = str.length() - 1;
            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

}

