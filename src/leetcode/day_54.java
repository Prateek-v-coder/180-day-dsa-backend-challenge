package leetcode;

public class day_54 {
        int count = 0;
        public void expand(String s, int left , int right){
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        public int countSubstrings(String s) {

            for(int i=0; i<s.length(); i++){
                expand(s,i,i);
                expand(s,i,i+1);
            }
            return count;
        }// beats 98 %

}
