package String.LongestpallSubstring;

// it is a concept of expand around center.

public class optimize {
    public static void main(String[] args) {
        String s="ababd";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            String odd=help(s,i,i);
            if (odd.length()>ans.length()){
                ans=odd;
            }
            String even=help(s,i,i+1);
            if (even.length()>ans.length()){
                ans=even;
            }
        }
        return ans;

    }

    private static String help(String s, int i, int j) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
