package dsa_problems;

import java.util.Arrays;
import java.util.HashMap;

public class dya_35 {
    public static void main(String[] args) {
        System.out.println(isPermutationString("ab","eidbaooo"));

    }
    public static boolean isPermutationString(String str1,String str2){
        if(str1.length()>str2.length()) return false;
       int[] freq1 = new int[26];
       int[] freq2 = new int[26];
       for (int i =0; i<str1.length(); i++){
           freq1[str1.charAt(i)-'a']++;
           freq2[str2.charAt(i)-'a']++;
       }
       int left = 0;
       for (int right = str1.length(); right<str2.length(); right++){
           if (Arrays.equals(freq1,freq2)){
               return true;
           }
           freq2[str2.charAt(left++)-'a']--;
           freq2[str2.charAt(right)-'a']++;
       }
       return false;
    }
}
