import java.util.Arrays;

public class day_3 {
    public static void main(String[] args) {
        //creating the object of Car class
        Car c1 = new Car();
//        c1.color="red";
//        c1.speed=120;
//        c1.print_();
        Prefix_sum_Array prefix = new Prefix_sum_Array();
        int[] arr = {0,1,2,4,5,6,7,8,9,10};
       // System.out.println(Arrays.toString(prefix.prefixArray(arr)));
       // System.out.println(prefix.rengeSumQuery(prefix.prefixArray(arr),0,2));
       // System.out.println(prefix.findPivot(prefix.prefixArray(arr)));
       // System.out.println(prefix.returnPivot(arr));
//        Bank_account b = new Bank_account("prateek",1800.00);
//        b.showBalance();
//        int count = prefix.findSubArray(arr,5);
//        System.out.println(count);
        System.out.println(prefix.missingNumber(arr,10));
    }
}

// classes in java
// creating a new class
// the first charactor of class name should be upper case
class Car{
    String color;
    int speed;
    void print(){
        System.out.println("car is running at the speed of "+speed+"km/h");
    }
    //constructor in java
    // constructor is the special type of method that created by the class name without return type
    // Non parameterised constructor
    Car(){
//        color = "red";
//        speed = 180;
        this("green",140);
    }
    // parameterised constructor
    Car (String color,int speed){
        // this key word
        //use 1.
        this.color=color;
        this.speed= speed;
    }
    // uses of this key word
    // 1. access current object variable
    // 2. call current object method
    // 3. call another constructor of same class
    void print_color(){
        System.out.println(color);
    }
    void print_(){
        // use 2.
        this.print_color();
    }

}
//prefix sum array
class Prefix_sum_Array{
    public int[] prefixArray(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0]=arr[0];
        for (int i = 1; i<arr.length; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
       return prefix;
    }

    // Problem 1 — Range Sum Query
    public int rengeSumQuery(int[] prefixArray, int left,int right){
        if(left==0){
            return prefixArray[right];
        }

        return prefixArray[right]-prefixArray[left-1];
    }
//    public int findPivot(int[] prefixArray){
//        for (int i = 0; i<prefixArray.length; i++){
//            if (i==0){
//                if (0==prefixArray[prefixArray.length-1]-prefixArray[i]){
//                    return i;
//                }
//            }else {
//                if (prefixArray[i-1]==prefixArray[prefixArray.length-1]-prefixArray[i]){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
    // problem No. 2 find pivot index
    public int returnPivot(int[] arr){
        int totalSum = 0;
        for (int i:arr){
            totalSum+=i;
        }
        int leftSum = 0;
        for (int i =0; i<arr.length; i++){
            int rightSum = totalSum-leftSum-arr[i];
            if (rightSum==leftSum){
                return i;
            }
            leftSum+=arr[i];
        }
        return -1;

    }

    // problem No. 4 count subArrays sum equals k
    public int findSubArray(int[] arr, int k){
        int count = 0;
        for (int i = 0; i<arr.length; i++){
            int sum = 0;
            for (int j = i; j<arr.length; j++){
                sum+=arr[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int missingNumber(int[] arr,int n){
        int total_of_n_numbers = (n*(n+1))/2;
        int total = 0;
        for (int i =0; i<arr.length; i++){
            total +=arr[i];
        }
        return total_of_n_numbers-total;
    }

}
// problem No.3
// create a bank account class with methods deposit(),withdraw(),showBalance() and attributes accountHolder, balance
class Bank_account{
    String accountHolder;
    double balance;
    Bank_account(String accountHolder, double balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    public void deposit(double amount){
        balance+=amount;
    }
    public void withdraw(double amount){
        if (amount>balance){
            System.out.println("insufficient balance");
        }else {
            balance -= amount;
        }
    }
    public void showBalance(){
        System.out.println("balance "+balance);
    }
}
