package Goldman.Medium.MiniWindowSubString;


public class Brute {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (containsAll(sub, t)) {
                    if (sub.length() < minLength) {
                        minLength = sub.length();
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

    private static boolean containsAll(String sub, String t) {
        int[] freq = new int[128];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        for (char c : sub.toCharArray()) {
            freq[c]--;
        }

        for (char c : t.toCharArray()) {
            if (freq[c] > 0) return false;
        }

        return true;
    }
}
