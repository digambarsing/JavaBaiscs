package String;
import java.util.*;
public class Longestpallindrome {
    public static void main(String[] args) {
        String s="ddccccab";
        System.out.println(longestPalindrome(s));
    }
    public static  int longestPalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int len=0;
        boolean isOdd=false;
        for(int k:map.values()){
            if(k%2==0){
                len+=k;
            }else{
                len+=k-1;
                isOdd=true;
            }
        }
        if(isOdd){
            len+=1;
        }
        return len;
    }
}
