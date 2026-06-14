import java.io.*;
import java.util.*;

public class day_18 {
    public static void main(String[] args) throws Exception {
//        MyLinkedlist list = new MyLinkedlist();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.showList();
//       list.reverseList();
//        list.showList();
        day18_leetcode code = new day18_leetcode();
        List<String> result = new ArrayList<>();
        code.nParenthesis("",2,0,0,result);
        System.out.println(result);
    }
}
class day18_leetcode{
    public void subset2(int[] arr, int index,
                        List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));
        for (int i = index; i<arr.length; i++){
            if (i>index&&arr[i]==arr[i-1]) continue;
            current.add(arr[i]);
            subset2(arr,i+1,current,result);
            current.remove(current);
        }
    }
    public void nParenthesis(String combination,int n,int open,int close,List<String> result){
        if(combination.length()==2*n){
            result.add(combination);
            return;
        }
        if (open<n){
            nParenthesis(combination+"(",n,open+1,close,result);
        }
        if (close<open){
            nParenthesis(combination+")",n,open,close+1,result);
        }
    }
}
class FileHandling{
    public void createFile(){
        File file = new File("data.txt");
        try{
            if (file.createNewFile()){
                System.out.println("file created successfully! ");
            }else{
                System.out.println("file already exist");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void fileWriter() throws Exception{
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("sample.txt");
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(writer);
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("data copied successfully");


//            System.out.println("enter how many student details you want to write");
//            int n = sc.nextInt();
//            for (int i= 1; i<=n; i++){
//                System.out.println("enter student Id");
//                int id = sc.nextInt();
//                sc.nextLine();
//                System.out.println("enter student name");
//                String name = sc.nextLine();
//                System.out.println("enter student marks");
//                float marks = sc.nextFloat();
//                sc.nextLine();
//                bw.write(id+" " +name+" "+marks );
//                bw.newLine();
//            }
            bw.close();
            writer.close();
            System.out.println("successfully written to file");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void fileWreader(){
        try{
            File file = new File("sample.txt");
            FileReader reader = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while((line=br.readLine())!= null){
                System.out.println(line);
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
class MyLinkedlist{
    class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    private int size=0;
    private Node head;
    public void addFirst(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
            size++;
            return;
        }
        newnode.next=head;
        head=newnode;
        size++;
    }
    public void addLast(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
            size++;
            return;
        }
        if (head.next==null){
            head.next=newnode;
            size++;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        size++;
    }
    public void deleteFirst(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        head=head.next;
        size--;
    }
    public void deleteLast(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        if (head.next==null){
            head=null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }
    public boolean search(int data){
        if (head==null){
            return false;
        }
        Node temp = head;
        while(temp!=null){
            if (temp.data==data){
             return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public void showList(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int size(){
        return size;
    }
    public void reverseList(){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node currtemp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=currtemp;
        }
        head=prev;
    }

}
