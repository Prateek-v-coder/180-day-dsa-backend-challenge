package library_management_system;

public interface Borrowable {
    void borrow(String userId);
    void returnItem(String userId);
    boolean isAvailable();
}
abstract class LibraryItem{
    private String title;
    private String itemId;
    private int quantity;
    LibraryItem(String title,String itemId,int quantity){
        this.title=title;
        this.itemId=itemId;
        this.quantity=quantity;
    }
    abstract String getItemType();
    void displayInfo(){
        System.out.println(getItemType()+" : "+title);
    }
}
