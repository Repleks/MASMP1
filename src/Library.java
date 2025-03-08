import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found, please check the title");
        }
    }

    public void printBooks() {
        for(Book book : books) {
            System.out.println("Title: " + book.getTitle() + " ID: " + book.getId());
        }
    }
}
