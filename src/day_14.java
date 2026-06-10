import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
public class day_14 {
    public static void main(String[] args) {
//        Stack_ stack = new Stack_();
//        stack.stack_uses();
//        Browser_history history = new Browser_history();
//        history.visitSite("www.google.com");
//        history.visitSite("www.youtube.com");
//        history.visitSite("www.spotify.com");
        //System.out.println(history.current());
     //   history.printHistory();
//        System.out.println(history.current());
//        System.out.println(history.back());
//        System.out.println(history.back());
//        System.out.println(history.back());
       // System.out.println(history.current());
//        System.out.println(history);
        Day_14_problems problems = new Day_14_problems();
      //  boolean isvalid  = problems.validParentheses("[]");
      //  System.out.println(isvalid);
       // System.out.println(problems.firstNonRepeating(new int[] {1,1}));
       // System.out.println(problems.isPalin("l"));
      //  System.out.println(problems.containDuplicate(new int [] {1,2,1}));
        System.out.println(problems.divide(0,0));
    }
}
class Stack_{
    Stack<Integer> stack = new Stack<>();
    public void stack_uses(){
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.search(20));
        System.out.println(stack.pop());
        System.out.println(stack.size());
        stack.clear();
        System.out.println(stack.isEmpty());
        System.out.println(stack);

    }
}
class Browser_history{
   private Stack<String> history;
    private String current;
    public Browser_history(){
        history = new Stack<>();
        current = null;
    }
    public void visitSite(String url){
        current=url;
        history.push(url);
    }
    public String back(){
        if (history.size()<=1){
            System.out.println("can't go back");
            return current;
        }
        history.pop();
        current = history.peek();
        return current;
    }
    public String current(){
        return current;
    }
    public void printHistory(){
        System.out.println(history);
    }
}
class Day_14_problems{
    public boolean validParentheses(String parentheses){
        Stack<Character> paren = new Stack<>();
        for (char i : parentheses.toCharArray()){
            if (i == '(' || i == '{' || i== '[') {
                paren.push(i);
            }else {
                if (paren.isEmpty()) return false;
                char top = paren.pop();
                if (i==')'&&top!='(') return false;
                if (i=='}'&&top!='{') return false;
                if (i==']'&&top!='[') return false;
            }
        }
        return paren.isEmpty();
    }
    public int firstNonRepeating(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i:arr){
            if (map.get(i)==1){
                return i;
            }
        }
        return -1;
    }
    public String reverString(String str){
        if (str.length()<=1) return str;
       return str.charAt(str.length()-1) + reverString(str.substring(0,str.length()-1));
    }
    public boolean isPalin(String str){
        String revers = reverString(str);
        return str.equals(revers);
    }
    public boolean containDuplicate(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int i: arr){
            if (!set.add(i)){
                return true;
            }
        }
        return false;
    }
    public int divide(int a , int b){
        if (b==0){
            throw new ArithmeticException("can not divide by 0");
        }
        return a/b;
    }
}
