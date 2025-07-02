package String;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "egsek";
        System.out.println(areAnagrams(s1, s2));
        System.out.println(areAnagrams1(s1, s2));
        System.out.println(areAnagrams2(s1, s2));
    }

    private static boolean areAnagrams2(String s1, String s2) {

        HashMap<Character,Integer>map=new HashMap<>();

        for(char ch: s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch:s2.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);

        }

        for(var e:map.entrySet()){
            if (e.getValue()!=0) return false;
        }
        return true;
    }

    private static boolean areAnagrams1(String s1, String s2) {

        int[]freq=new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i <s2.length() ; i++) {
            freq[s2.charAt(i)-'a']--;
        }

        for(int c:freq){
            if (c!=0){
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams(String s1, String s2) {
        char[]ch1=s1.toCharArray();
        char[]ch2=s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        String s=new String(ch1);
        String q=new String(ch2);

        System.out.println(s.equals(q));
        
        return Arrays.equals(ch1,ch2);
    }
}
