package projects;
public class TicketBookingSystem {
    public static void main(String[] args) {
       String[] users = {"prateek","ratensh","vikash","vishal","nikhil","sunny"};
       Thread[] threads = new Thread[users.length];
       for (int i =0; i<users.length; i++){
           final String username = users[i];
           threads[i] = new Thread(()->bookTicket(username));
       }
       for (Thread i :threads){
           i.start();
       }
       for (Thread i: threads){
           try {
               i.join();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
        System.out.println("\nfinalAvailable tickets: "+availableTicket);
    }
    private static int availableTicket = 10;
    public static boolean isAvailable(){
        return availableTicket > 0;
    }
    public static synchronized void bookTicket(String userName){
        if (isAvailable()){
            availableTicket--;
            System.out.println("ticket is booked: "+userName);
        }else {
            System.out.println(userName+" ticket is not available....");
        }
    }
}
