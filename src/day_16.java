import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;

public class day_16 {
    public static void main(String[] args) {
//        printNTo1(5);
//        System.out.println();
//        print1ToN(5);
      //  System.out.println(countSum(12345));
        //System.out.println(countZero(10000,0));
       // System.out.println(reverseString("name"));
       // System.out.println(checkPalindrome("racecar"));
       // System.out.println(countZero(1111));
        int []arr = new int[]{1,2,3,4};
       // System.out.println(binarySearch(arr,1,0,arr.length-1));
      //  System.out.println(powerOfTwo(6));
      //  System.out.println(arrSum(arr,0));
//        System.out.println(fibo(5));
//        System.out.println(fiboCheck(5));
      //  System.out.println(Arrays.toString(new ArrayList[]{fiboNo(50)}));
        char [] str = {'h','e','l','l','o'};
        reverseString(str);
        System.out.println(Arrays.toString(str));

    }
    public static void printNTo1(int n){
        if (n==1){
            System.out.print(1);
            return;
        }
        System.out.print(n+" ");
        printNTo1(n-1);


    }
    public static void print1ToN(int n){
        if (n==1){
            System.out.print(n+" ");
            return;
        }
        print1ToN(n-1);
        System.out.print(n+" ");
    }
    public static int countSum(int n){
        if (n==0){
            return 0;
        }
        return (n%10)+countSum(n/10);
    }
    public static int helperCount(int n, int count){
        if (n==0){
            return count;
        }

        int modulo = n%10;
        if (modulo==0){
            count++;
        }
        return helperCount(n/10,count);
    }
    public static int countZero(int n){
        if (n==0){
            return 1;
        }
        return helperCount(n,0);
    }
    public static String reverseString(String str){
        if (str.length()==1||str.length()==0){
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    public static boolean checkPalindrome(String str){
        String reverse = reverseString(str);
        return str.equals(reverse);
    }
    public static int binarySearch(int[] arr, int target,int left,int right){
        if (left>right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if (arr[mid]==target){
            return mid;
        } else if (arr[mid]<target) {
            return binarySearch(arr,target,mid+1,right);
        }else {
            return binarySearch(arr,target,left,mid-1);
        }
    }
    public static boolean powerOfTwo(int n){
        if (n==1){
            return true;
        }
        if (n<=0||n%2!=0){
            return false;
        }
       return powerOfTwo(n/2);
    }
    public static int arrSum(int [] arr,int i){
        if (i==arr.length){
            return 0;
        }
        return arr[i] + arrSum(arr,i+1);
    }
    public static ArrayList<Integer> fiboNo(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int a = 0;
        int b = 1;
        int c;
        list.add(a);
        list.add(b);
        for (int i = 1; i<=n; i++){
            c=a+b;
            list.add(c);
            a=b;
            b=c;
        }
        return list;
    }
    public static int fibo(int n){
        ArrayList<Integer> list = fiboNo(n);
        return list.get(n);
    }
    public static int fiboCheck(int n ){
        if (n==0||n==1){
            return n;
        }
        return fiboCheck(n-2)+fiboCheck(n-1);
    }
    public static void revers(char[] str){
        int left = 0; int right = str.length-1;
        while(left<=right){
            char temp = str[left];
            str[left]=str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
    public static void reverseString(char[] str){
        revers(str);
    }
}
