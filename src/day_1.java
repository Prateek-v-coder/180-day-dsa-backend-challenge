import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class day_1 {
    // 2-: instance variable
//    String name = "prateek verma";
//
//    // 3-: static variable
//    static int a = 30;
    public static void main(String[] args) {
//
//
//        // output in java
//        System.out.print("hello world\n");
//        System.out.print("hello world");
//        System.out.println("hello java");
//        System.out.printf("hello java");
//        System.out.println();
//
//
//        // input in java
        Scanner sc = new Scanner(System.in);
//        // for single words
//        System.out.println("enter your name");
//        String name = sc.next();
//        System.out.println(name);
//        sc.nextLine();
//        // for a line
//        System.out.println("write the line of words");
//        String line = sc.nextLine();
//        System.out.println(line);
//        // for int value
//        System.out.println("enter number");
//        int number = sc.nextInt();
//        System.out.println(number);
//        sc.nextLine();
//
//
//        // variable in java
//        int a = 10;
//        System.out.println("variable -"+a);
//
//        //types
//        // 1-: local variable
//        int a1 = 20;
//        System.out.println("local variable - "+a1);


        // data Types
        //primitive datatype
        // byte
//        byte a = 20;
//        System.out.println(a);
//
//        // short
//        short y = 180;
//        System.out.println(y);
//
//        // int
//        int a1 = 100;
//        System.out.println(a);
//
//        // long
//        long value = 100000L;
//        System.out.println(value);
//
//        //FLOAT
//        float f = 2.5f;
//        System.out.println(f);
//
//        //double
//        double d = 200.0004;
//        System.out.println(d);
//
//
//
//        // Non primitive datatype
//
//        //String
//        String str = "hello world";
//
//        // Arrays
//
//        int[] arr = new int[10];


        // arrays
      /*  int[] numbers = new int[6];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        numbers[5] = 6;
        System.out.println(numbers[4]);
//        for (int i = 0; i<numbers.length; i++){
//            System.out.println(numbers[i]);
//        }


        // LOOPS

        // for loop
        for (int i = 0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }

        //while loop
        int i = 0;
        while(i<numbers.length){
            System.out.println(numbers[i]);
            i++;
        }

        int n = 0;
        do{
            System.out.println(numbers[n]);
            n++;
        }while (n<numbers.length);



        // conditionals
        System.out.println("enter the number");
        int num = sc.nextInt();
        if (numbers[num]==3){
            System.out.println("i got");
        }else {
            System.out.println("i do not");
        }  */

        // problem 1 two sum
        int[] arr = {2, 7, 11, 15};
        for (int i = 0; i<arr.length; i++){
            for (int j = i+1; j<arr.length; j++){
                if (arr[i]+arr[j]==9){
                    System.out.println("{"+ i+","+j+"}");
                }
            }
        }

        // problem 2 find max element in an array
        int max = arr[0];
        for (int i =0; i<arr.length; i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);

        // problem 3 reverse an array
        for (int  i = 0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        for (int num: arr) {
            System.out.println(num);
        }

        // problem 4 count even number in array

        int evenCount = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i]%2==0){
                evenCount++;
            }
        }
        System.out.println(evenCount);

        // problem 5 search for a target element using linear search
        System.out.println("enter your target element");
        int target = sc.nextInt();
        for (int i = 0; i<arr.length; i++){
            if (arr[i]==target){
                System.out.println("got the element at index "+i);
            }
        }


   }
//    // reference variable
//    day_1 day = new day_1();

    }

