import java.util.Arrays;

public class day_4 {
    public static void main(String[] args) {
//        Student s = new Student();
//        s.setAge(10);
//        System.out.println(s.getAge());
//        s.setAge(-10);
//        s.setName("prateek");
//        System.out.println(s.getName());
//        s.setMarks(85.52f);
//        System.out.println(s.getMarks());
//        s.setMarks(1001.0f);
        TwoPointer pointer = new TwoPointer();
        int[] arr = {1, 3, 2, 5, 8, 4};
        int[] values = pointer.returnPayerSum(arr,6);
       // System.out.println(Arrays.toString(values));
//        String str = "A man a plan a canal Panama";
//        boolean b = pointer.palindrome(str);
//        System.out.println(b);
//        System.out.println(pointer.removeDuplicate(arr));
//        System.out.println(Arrays.toString(arr));
      //  System.out.println(Arrays.toString(pointer.moveZero(arr)));
        //System.out.println(Arrays.toString(pointer.sort_sqrtArr(arr)));
        System.out.println(pointer.containerWithMostWater(arr));


    }
}
// Encapsulation
class Student{
    private String name;
    private int age;
    private float marks;
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        if (age<0){
            System.out.println("invalid age");
            return;
        }
        this.age=age;
    }
    public void setMarks(float marks){
        if (marks<0 || marks>100){
            System.out.println("invalid marks");
            return;
        }
        this.marks=marks;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public float getMarks(){
        return marks;
    }
}

class TwoPointer{
    public int [] returnPayerSum(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if (sum==target){
                return new int[]{left,right};
            } else if (sum<target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }

    //Problem 1 — Valid Palindrome
    public boolean palindrome(String str){
        int left = 0;
        int right = str.length()-1;
        while (left<right){
            while (left<right&&!Character.isLetterOrDigit(str.charAt(left))){
                left++;
            }while (left<right&&!Character.isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if (Character.toLowerCase(str.charAt(left))!=Character.toLowerCase(str.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Problem 2 — Remove Duplicates from Sorted Array
    public int removeDuplicate(int[] arr){
        int slow = 0;
        for (int fast = 1; fast<arr.length; fast++){
            if (arr[slow]!=arr[fast]){
                slow++;
                arr[slow]=arr[fast];
            }
        }
        return slow+1;
    }

    //Problem 3 — Move Zeroes to end

    public int[] moveZero(int[] arr){
        int slow = 0;
        for (int fast = 1; fast<arr.length; fast++){
            if (arr[fast]!=0){
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow++;
            }
        }
        return arr;
    }

    // Problem 4 — Squares of Sorted Array
    public int[] sort_sqrtArr(int[] arr) {
        int[] squareArray = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int index = arr.length-1;
        while (left <= right) {
            int sqrt_left = arr[left] * arr[left];
            int sqrt_right = arr[right] * arr[right];
            if (sqrt_left > sqrt_right) {
                squareArray[index] = sqrt_left;
                left++;
            }else {
                squareArray[index] = sqrt_right;
                right--;
            }
            index--;
        }
            return squareArray;
        }

        // Problem 5 — Container With Most Water
    public int containerWithMostWater(int[] arr){
        int maxWater = 0;
        int leftContainer = 0;
        int rightContainer = arr.length-1;
        while(leftContainer<rightContainer) {
            int width = rightContainer - leftContainer;
            int height = Math.min(arr[leftContainer], arr[rightContainer]);
            int area = width * height;
            maxWater = Math.max(maxWater, area);
            if (arr[leftContainer] < arr[rightContainer]) {
                leftContainer++;
            } else {
                rightContainer--;
            }
        }

        return maxWater;
    }

}
