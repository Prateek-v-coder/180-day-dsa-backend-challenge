import java.util.HashMap;
import java.util.HashSet;

public class day_12 {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.addFirst(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.printList();
//        list.deleteFirst();
//        list.printList();
//        list.deleteLast();
//        list.printList();
//        list.deleteLast();
//        list.printList();
//        System.out.println(list.getSize());
//        student s1 = new student();
//        student s2 = new student();
//        s1.setName("prateek");
//        student.setCollege("abc college");
//        s2.setName("vikash");
//        System.out.println(s1.getName()+" "+ s1.getCollege());
//        System.out.println(s2.getName()+" "+ s2.getCollege());
//        node first = new node(10);
//        node second = new node(20);
//        node third = new node(30);
//        first.next=second;
//        second.next=third;
//        System.out.println(first.data);
//        System.out.println(first.next.data);
//        System.out.println(first.next.next.data);
//        System.out.println(first.next.next.next);
//        node head;
//        head = first;
//        System.out.println(head.data);
//        System.out.println(head.next.next.next);
        problems p = new problems();
       // System.out.println(p.getSquare(19));
        System.out.println(p.happyNumber(19));

    }
}
class student{
    private String name;
    private static String college;
    public static void setCollege(String college){
        student.college =college;
    }
    public String getCollege(){
        return college;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
//class LL{
//    private int size=0;
//   private node head;
//   private node tail;
//    public void addFirst(int value){
//        node newnode = new node(value);
//        newnode.next=head;
//        head = newnode;
//        size++;
//    }
//    public void addLast(int value){
//        node newnode = new node(value);
//        size++;
//        if (head==null){
//            head=newnode;
//            return;
//        }
//        node currNode = head;
//        while(currNode.next!=null){
//            currNode=currNode.next;
//        }
//        currNode.next=newnode;
//    }
//    public void deleteFirst(){
//        if (head==null){
//            System.out.println("list is empty");
//            return;
//        }
//        size--;
//        head=head.next;
//    }
//    public void deleteLast(){
//        if (head==null){
//            System.out.println("list is empty");
//            return;
//        }
//        size--;
//        if (head.next==null){
//            head=null;
//            return;
//        }
//        node currNode = head;
//        while(currNode.next.next!=null){
//            currNode=currNode.next;
//        }
//        currNode.next=null;
//    }
//    public void printList(){
//        if (head==null){
//            System.out.println("list is empty");
//            return;
//        }
//        node currNode = head;
//        while(currNode!=null){
//            System.out.print(currNode.value+"->");
//            currNode=currNode.next;
//        }
//        System.out.println("null");
//    }
//    public int getSize(){
//        return size;
//    }
//}
class node{
    int data;
    node next;
    node(int data){
        this.data=data;
        next= null;
    }
}
class problems{
    // revision problems
    public int singleNum(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (HashMap.Entry<Integer,Integer> entry :map.entrySet()){
           if (entry.getValue()==1){
               return entry.getKey();
           }
        }
        return -1;
    }
    public int getSquare(int n){
        int sum =0;
        while(n!=0){
            int num = n%10;
            sum +=num*num;
            n=n/10;
        }
        return sum;
    }
    public boolean happyNumber(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            if (!set.add(n)){
                return false;
            }
            n=getSquare(n);
        }
       return true;
    }
}
