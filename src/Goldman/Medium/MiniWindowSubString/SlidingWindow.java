package Goldman.Medium.MiniWindowSubString;

import java.util.HashMap;

public class SlidingWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, required = targetFreq.size();
        int minLength = Integer.MAX_VALUE;
        int matched = 0, startIdx = 0;

        HashMap<Character, Integer> windowFreq = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (targetFreq.containsKey(c) && windowFreq.get(c).equals(targetFreq.get(c))) {
                matched++;
            }

            while (matched == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    matched--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLength);
    }
}
