import java.util.ArrayList;
import java.util.List;

public class day_17 {
    public static void main(String[] args) {
        String[] shirt = {"red","blue","green"};
          backtracking tack = new backtracking();
//        List<List<String>> result = new ArrayList<>();
//        tack.shirtCombination(shirt,0,new ArrayList<>(),result);
//        System.out.println(result);
        int[] arr = {2,3,6,7};
        List<List<Integer>> result = new ArrayList<>();
//        tack.subSetProblem(arr,0,new ArrayList<>(),result);
//        System.out.println(result);
       // tack.permuTation(arr,new boolean[arr.length],new ArrayList<>(),result);
      //  System.out.println(result);
       // tack.letterCombination("23");
       //tack.combinationSum(arr,7,0,0,new ArrayList<>(),result);
        tack.combination(4,2,1,new ArrayList<>(),result);
        System.out.println(result);

    }
}
class backtracking{
    public void shirtCombination(String[] shirt, int index,
                                 List<String> current, List<List<String>> result){
        if(current.size()==2){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i<shirt.length;i++){
            current.add(shirt[i]);
            shirtCombination(shirt,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
    public void subSetProblem(int[] arr, int index,List<Integer> current,List<List<Integer>> result){
            result.add(new ArrayList<>(current));
        for (int i = index; i<arr.length; i++){
            current.add(arr[i]);
            subSetProblem(arr,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
    public void permuTation(int[] arr,boolean[] used, List<Integer> current,List<List<Integer>> result){
        if (current.size()==arr.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i =0; i<arr.length; i++){
            if (used[i]) continue;
            current.add(arr[i]);
            used[i]=true;
            permuTation(arr,used,current,result);
            used[i]=false;
            current.remove(current.size()-1);
        }
    }
    public static void letterCom(String digit,int index,String current,List<String> result,String[] keyPad){
        if (index==digit.length()){
            result.add(current);
            return;
        }
        String letters = keyPad[digit.charAt(index)-'0'];
        for (char c:letters.toCharArray()){
            letterCom(digit,index+1,current+c,result,keyPad);
        }
    }
    public void letterCombination(String str){
        String [] keyPad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        letterCom(str,0,"",result,keyPad);
        System.out.println(result);
    }
    public void combinationSum(int[] arr,int target ,int sum,int start,
                               List<Integer> current, List<List<Integer>> result){
        if (sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        if (sum>target) return;
        for (int i =start; i<arr.length; i++){
            current.add(arr[i]);
            combinationSum(arr,target,sum+arr[i],i,current,result);
            current.remove(current.size()-1);
        }
    }
    public void combination(int n, int k,int index,List<Integer> current,List<List<Integer>> result){
        if (current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i<=n; i++){
            current.add(i);
            combination(n,k,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
}
