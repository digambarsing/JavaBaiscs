package String;

import java.util.*;
public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcaecbb";
        System.out.println(len(s));
        System.out.println("Length of Longest Substring Without Repeating Characters: " + lengthOfLongestSubstring(s)); // Output: 3
    }

    private static int len(String s) {
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            boolean[]vis=new boolean[26];
            for (int j = i; j < s.length(); j++) {
                if (vis[s.charAt(j)-'a']==true){
                   break;
                }else{
                    max=Math.max(max,j-i+1);
                    vis[s.charAt(j)-'a']=true;
                }
            }
        }
        return max;
    }

    private static int lengthOfLongestSubstring(String s) {

      int max=Integer.MIN_VALUE;
      String ans="";
      for(char ch:s.toCharArray()){
          if (ans.contains(s.valueOf(ch))){
              max=Math.max(max,ans.length());
              ans=ans.substring(ans.indexOf(ch)+1);
          }
          ans+=ch;
      }
      return Math.max(max,ans.length());
    }
}
