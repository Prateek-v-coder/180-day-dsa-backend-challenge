package dsa_topics;

public class day_19 {
    public static void main(String[] args) {
//        DoublyLinkedList list = new DoublyLinkedList();
//        list.addFirst(10);
//        list.addLast(20);
//        list.addLast(30);
//        list.addLast(40);
//        list.addFirst(5);
//        list.printForward();
//        list.printBackward();
//        System.out.println(list.search(5));
        CircularLinkedList list = new CircularLinkedList();
        list .addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
//        list.printList();



    }
}
class DoublyLinkedList{
    class Node{
        private int data;
        private Node next;
        private Node prev;
        Node(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }
    private int size = 0;
    private Node head;
    private Node tail;
    public void addFirst(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
            tail=newnode;
            size++;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        size++;
    }
    public void addLast(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
            tail=newnode;
            size++;
            return;
        }
        tail.next=newnode;
        newnode.prev=tail;
        tail=newnode;
        size++;
    }
    public void deleteFirst(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        if (head.next==null){
            head=null;
            tail=null;
            size--;
            return;
        }
        head=head.next;
        head.prev=null;
        size--;
    }
    public void deleteLast(){
        if (tail==null){
            System.out.println("list is empty");
            return;
        }
        if (tail.prev==null){
            tail=null;
            head=null;
            size--;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size--;
    }
    public boolean search(int data){
        if (head==null){
            return false;
        }
        if (tail.data==data){
            return true;
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
    public void printForward(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void printBackward(){
        if (tail==null){
            System.out.println("list is empty");
            return;
        }
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.prev;
        }
        System.out.println("null");
    }
    public int size(){
        return size;
    }
}
class CircularLinkedList{
    class Node{
         int data;
         Node next;
        Node(int data){
            this.data=data;
            next=null;

        }
    }
     Node head;
     Node tail;
    private int size=0;
    public void addFirst(int data){
        Node newnode = new Node(data);
        if (head==null){
            head=newnode;
           tail=newnode;
           tail.next=head;
           size++;
            return;
        }
        newnode.next=head;
        head=newnode;
        tail.next=head;
        size++;
    }
    public void printList(){
        if (head==null){
            System.out.println("list is empty");
            return;
        }
        Node temp = head;
       do{
           System.out.print(temp.data+"->");
           temp=temp.next;
       }while (temp!=head);
        System.out.println("head");
    }
    public boolean cycleDetect(Node head){
        if (head==null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

            if (slow.data==fast.data){
                return true;
            }
        }
        return false;
    }

}