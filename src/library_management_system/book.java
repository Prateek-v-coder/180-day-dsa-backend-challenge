package library_management_system;

public class book extends LibraryItem implements Borrowable {
    private String author;
    private boolean borrowed = false;

    public book(String title, String itemId, int quantity, String author) {
        super(title, itemId, quantity);
        this.author = author;
    }

    @Override
    public void borrow(String userId) {
        borrowed = true;
        System.out.println(userId + " is borrowed a book");
    }

    @Override
    public void returnItem(String userId) {
        borrowed = false;
        System.out.println(userId + " return the book");

    }

    @Override
    public boolean isAvailable() {
        return !borrowed;
    }

    @Override
    String getItemType() {
        return "book";
    }
}
