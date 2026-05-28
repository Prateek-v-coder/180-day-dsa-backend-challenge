import java.util.Arrays;

public class day_2 {
    public static void main(String[] args) {
       /* greet();
        sum();
        int sum = sumNum();
        System.out.println(sum);
        System.out.println(sum1(10,30));
        int a = 10;
        int b = 20;
        swap(a,b); */
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
//        insertAtLast(arr,6,5);
//        System.out.println(Arrays.toString(arr));
//        insertAtFirst(arr,10,5);
//        System.out.println(Arrays.toString(arr));
//        insertAtPosition(arr,4,5,2);
//        System.out.println(Arrays.toString(arr));
//        deleteAtPosition(arr,5,0);
//        System.out.println(Arrays.toString(arr));
        //  _2DArray();
        //runningSum(arr);
//        System.out.println(isSorted(arr));
//        int [] arr1 = {3, 1, 0, -5, 7, -2};
//        System.out.println(countNegative(arr1));
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
//        reverARangeOfElement(arr1,2,4);
        revers(arr1);
        System.out.println(Arrays.toString(arr1));


    }

    // 1. methods in java
    // A method is a block of code that perform a specific task
    // example
    static void greet() {
        System.out.println("hello world");
    }

    static void sum() {
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
    }

    // part of a method
    // Name. greet, sum

    // return type
    // example
    static int sumNum() {
        int a = 10;
        int b = 2;
        int sum = a + b;
        return sum;
    }


    // methods with parameters

    static int sum1(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // method body
    // the actual code that writen inside the method

//    static void swap(){
//        int a = 10;
//        int b = 20;
//        int temp = a;
//        a= b;
//        b=temp;
//        System.out.println(a+","+b);
//    }

    // pass by value
    // in java there no pass by reference type on pass by value are there in java

    // example
    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + "," + b);
    }


    // Method Overloading
    // same name but different data types

    //example
    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    // Three way to overload a method
    //No.1 change the parameter of method
    static int add(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    //No.2 change datatype
    static int add(int a, float b) {
        return (int) (a + b);
    }

    //No.3 change order of datatypes
    static int add(float b, int a) {
        return (int) (a + b);
    }


    // Array traversal
    public static void arrayTraversal(int[] arr) {
        //tree way for traversal
        //No.1
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //No.2
        for (int num : arr) {
            System.out.println(num);
        }
        //No.3
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }
    }

    // Array insertion
    // insert at last
    public static void insertAtLast(int[] arr, int value, int n) {
        // n = nuber of element
        if (n == arr.length) {
            System.out.println("array is full we can't insert more element");
            return;
        }
        arr[n] = value;
    }


    //insert at first
    public static void insertAtFirst(int[] arr, int value, int n) {
        if (n == arr.length) {
            System.out.println("can't add more element");
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
    }

    // insert at position

    public static void insertAtPosition(int[] arr, int value, int n, int position) {
        if (n == arr.length) {
            System.out.println("can't add more element");
            return;
        }
        for (int i = n - 1; i >= position; i--) {
            arr[i + 1] = arr[i];
        }
        arr[position] = value;
    }


    // Array deletion
    // delete at position
    public static void deleteAtPosition(int[] arr, int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // 2D Array
    public static void _2DArray() {
        int[][] arr = new int[2][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    // Day 2 problems

    // problem No.1  Running Sum of Array
    public static void runningSum(int[] arr) {
        int[] runningSum = new int[arr.length];
        runningSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            runningSum[i] = runningSum[i - 1] + arr[i];
        }
        for (int num :
                runningSum) {
            System.out.print(num + " ");
        }
    }

    // problem No.2 second max element

    public static int second_maxElement(int[] arr) {
        int max = arr[0];
        int second_max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max) {
                if (arr[i]>second_max){
                    second_max=arr[i];
                }
            }
        }
        return second_max;
    }

    // problem No.3 Check if Array is Sorted
    public static boolean isSorted(int[] arr){
        for (int i = 0; i<arr.length-1; i++){
            if (arr[i]>arr[i+1]){
            return false;
            }
        }
        return true;
    }


    // problem No.4 Count Negative Numbers
    public static int countNegative(int[] arr){
        int negativeCount = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i]<0){
                negativeCount++;
            }
        }
        return negativeCount;
    }

    //problem No.5 Reverse a range of element in array

    public static void reverARangeOfElement(int[] arr , int str,int end){
       while (str<end){
           int temp = arr[str];
           arr[str] = arr[end];
           arr[end] = temp;
           str++;
           end--;
       }
    }
    public static void revers(int[] arr){
        int str = 0;
        int end = arr.length-1;
        while(str<end){
            int temp = arr[str];
            arr[str] = arr[end];
            arr[end] = temp;
            str++;
            end--;
        }
    }

}
