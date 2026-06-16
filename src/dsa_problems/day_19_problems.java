package dsa_problems;
import day_13.LL;
import day_13.node;
import java.util.ArrayList;
import java.util.List;


public class day_19_problems {
    public static void main(String[] args) {
        LL list1 = new LL();
        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(1);
//        node reverse = reverseList(list1.head);
//        while(reverse!=null){
//            System.out.print(reverse.data+" -> ");
//            reverse=reverse.next;
//        }
//        System.out.println("null");
//        node middle = middleList(list1.head);
//        System.out.println(middle.data);
       // System.out.println(palindromeList(list1.head));
        node removed = removeNthNode(list1.head,2);
        while (removed!=null){
            System.out.print(removed.data+" -> ");
            removed=removed.next;
        }
        System.out.println("null");


    }
    public static void paren(String current, int n , int close, int open, List<String> result){
        if (current.length()==2*n){
            result.add(current);
            return;
        }
        if (open<n){
            paren(current+"(",n,close,open+1,result);
        }
        if (close<open){
            paren(current+")",n,close+1,open,result);
        }
    }
    public static boolean listCycle(node head){
        node slow = head;
        node fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow) return true;
        }
        return false;
    }
    public static node margeList(node l1,node l2){
        node tempHead = new node(-1);
        node temp = tempHead;
        while (l1!=null&&l2!=null){
            if (l1.data<=l2.data){
                temp.next = l1;
                l1=l1.next;
            }else {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if (l1!=null){
            temp.next=l1;
        }if(l2!=null){
            temp.next=l2;
        }
        return tempHead.next;
    }
    // leetcode 19 remove nth node form last
    //leetcode 234 palindeom list
    public static node reverseList(node head){
        node curr = head;
        node prev = null;
        while(curr!=null){
            node tempnode = curr.next;
            curr.next=prev;
            prev=curr;
            curr=tempnode;
        }
        return prev;
    }
    public static node middleList(node head){
        node slow = head;
        node fast = head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static boolean palindromeList(node head){
        node slow = head;
        node fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        node curr = slow;
        node prev = null;
        while (curr!=null){
            node currnext = curr.next;
            curr.next=prev;
            prev=curr;
            curr=currnext;
        }
        node temp = head;
        while(prev!=null){
            if (temp.data!=prev.data){
                return false;
            }
            prev=prev.next;
            temp=temp.next;
        }
        return true;
    }
    public static node removeNthNode(node head,int n){
        node temphead = new node(0);
        temphead.next=head;
        node slow = temphead;
        node fast = temphead;
        for (int i = 0; i<=n; i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return temphead.next;
    }
}
