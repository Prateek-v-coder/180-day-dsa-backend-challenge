public class day_6 {
    public static void main(String[] args) {
        // Runtime Polymorphism
//        Animal_ a;
//        a = new Dog_();
//        a.eat();
//        a.sleep();
//        a.sound();
//        System.out.println(a instanceof Dog_);
//        a = new Cat_();
//        a.eat();
//        a.sleep();
//        a.sound();
//        System.out.println(a instanceof Cat_);
       String_test test = new String_test();
//        test.String_methods("hello world");
      //  System.out.println( test.isAnagram("cat","car"));
      //  System.out.println(test.reversWord("hello i am prateek"));
      //  System.out.println(test.firstNonRepeatingChar("leetcodel"));
       // System.out.println(test.countVowels("hello world"));
        String[] str = {"flower","flow","flight"};
        System.out.println(test.longestCommonPrefix(str));


    }
}
class Animal_{
    public void eat(){
        System.out.println("eating food.....");
    }
    public void sleep(){
        System.out.println("sleeping......");
    }
    public void sound(){
        System.out.println("make sound...");
    }
}
class Dog_ extends Animal_{
    @Override
    public void eat(){
        System.out.println("dog eating food.....");
    }
    @Override
    public void sleep(){
        System.out.println("dog sleep.....");
    }
    @Override
    public void sound(){
        System.out.println("bark......");
    }
}
class Cat_ extends Animal_{
    @Override
    public void eat(){
        System.out.println("cat eating food.....");
    }
    @Override
    public void sleep(){
        System.out.println("cat sleep.....");
    }
    @Override
    public void sound(){
        System.out.println("meow......");
    }
}

class String_test{
    public void String_methods(String str){
        System.out.println(str.length());
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());
        System.out.println(str.substring(0,5));
        System.out.println(str.contains("world"));
        str.replace("world","java");
        System.out.println(str);
        System.out.println(str.split(str));
        System.out.println(str.indexOf("o"));
        System.out.println(str.equals("hello world"));
        System.out.println(str.toCharArray());

    }

    // Problem 1 — Valid Anagram
    public boolean isAnagram(String str1,String str2){
        int[] count = new int[26];
        if (str1.length()!=str2.length()){
            return false;
        }
        for (int i =0; i <str1.length(); i++){
         count[str1.charAt(i)-'a']++;
         count[str2.charAt(i)-'a']--;
        }

       for (int i =0; i<count.length; i++){
           if (count[i]!=0) return false;
       }
           return true;
    }

    //  Problem 2 — Reverse Words in String

    public StringBuilder reversWord(String str){
       String[] s = str.split(" ");
       StringBuilder result = new StringBuilder();
        for (int i = s.length-1; i>=0;i--){
            result.append(s[i]);
            if (i!=0){
                result.append(" ");
            }
        }
        return result;
    }

    // Problem 3 — First Non-Repeating Character
    public int firstNonRepeatingChar(String str){
        int [] count = new int[26];
        for (int i =0; i<str.length(); i++){
            count[str.charAt(i)-'a']++;
        }
       for (int i =0; i<str.length(); i++){
           if (count[str.charAt(i)-'a']==1){
               return i;

           }
        }
        return -1;
    }

    // Problem 4 — Count Vowels in String
    public int countVowels(String str){
       String s =  str.toLowerCase();
        int count = 0;
        for (int i =0; i<s.length(); i++){
            char currChar = s.charAt(i);
            if (currChar=='a'||currChar=='e'||currChar=='i'||currChar=='o'||currChar=='u'){
                count++;
            }
        }
        return count;
    }

    // Problem 5 — Longest Common Prefix
    public String longestCommonPrefix(String[] str){
       String prefix = str[0];
       for (int i = 1; i<str.length; i++){
           while (!str[i].startsWith(prefix)){
               prefix = prefix.substring(0, prefix.length()-1);
               if (prefix.isEmpty()){
                   return "";
               }
           }
       }
       return prefix;

    }

}
