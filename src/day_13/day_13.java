package day_13;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class day_13{
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.printList();
        list.insertAtIndex(5,0);
        list.printList();
        System.out.println(list.getSize());
//        System.out.println(list.search(30));
//        System.out.println(list.searchIndex(10));
//        Ticket_Management_System system = new Ticket_Management_System();
//        system.addPerson("prateek");
//        system.addPerson("vikash");
//        system.addPerson("sunny");
//        system.servPerson();
//        system.showNextPerson();
        problems p = new problems();
//       // System.out.println( p.majorityElement(new int[]{2,2,1,1,1,1,1,1,11,2,2}));
//       // System.out.println(p.digitSum(0));
//        //System.out.println(p.reverse("name"));
//        System.out.println(p.containDuplicate(new int[]{1,2,3}));
    }
}

class Ticket_Management_System{
    Queue<String> personQueue = new LinkedList<>();
    public void addPerson(String person){
       boolean added= personQueue.offer(person);
       if (added){
           System.out.println("person add successfully.......");
       }else {
           System.out.println("person not added....");
       }
    }
    public void servPerson(){
        if (personQueue.isEmpty()){
            System.out.println("No one available for serving");
            return;
        }
       String person = personQueue.poll();
        System.out.println(person+" served successfully");
    }
    public void showNextPerson(){
        if (personQueue.isEmpty()){
            System.out.println("no one available" );
            return;
        }
        System.out.println(personQueue.peek()+" available");
    }
}
class problems{
    public int majorityElement(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (HashMap.Entry<Integer,Integer> entry :map.entrySet()){
            if (entry.getValue()>arr.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }
    public int digitSum(int n){
        if (n==0){
            return 0;
        }
        return (n%10) + digitSum(n/10);
    }
  public String reversString(String str){
        StringBuilder reverString = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--){
            reverString.append(str.charAt(i));
        }
        return reverString.toString();
    }
    public String reverse(String str){
        if (str.length()<=1){
            return str;
        }
        return reverse(str.substring(1))+str.charAt(0);
    }
    public int containDuplicate(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for (int i :arr){
            boolean contain = set.add(i);
            if (!contain){
                return i;
            }
        }
        return -1;
    }
}
