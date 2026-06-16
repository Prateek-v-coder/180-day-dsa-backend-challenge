package development_topics;
import java.util.ArrayDeque;
import java.util.Deque;
public class Deque_day20 {
    public static void main(String[] args) {
        dqUses();
    }
  public static void dqUses(){
      Deque<Integer> dq = new ArrayDeque<>();
      dq.offerFirst(10);
      dq.offerLast(20);
      dq.offerLast(30);
      dq.offerLast(40);
      System.out.println(dq);
      dq.pollFirst();
      dq.pollLast();
      System.out.println(dq);
      System.out.println(dq.peekFirst());
      System.out.println(dq.peekLast());
  }
}
