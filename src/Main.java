import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(118, Calendar.MARCH, 1);
        Date date2 = new Date(120, Calendar.OCTOBER, 1);

        Book book1 = new Book("The Great Gatsby", date, "F. Scott Fitzgerald");
        Book book2 = new Book("Moby Dick", date2,"");

        book1.addBookIssue(1,1000);
        book1.addBookIssue(2, 2000);
        book1.showIssues();

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.printBooks();

        Person person1 = new Person("Tom");
        person1.readBack();

        Reader reader1 = new Reader("Ted", "Ted123");
        Reader reader2 = new Reader("Red", "Der321");
        reader1.readBack("plate");
        reader1.startReadingFor(10);
        System.out.println(Reader.getAverageReadingTime());
        reader2.startReadingFor(50);
        System.out.println(Reader.getAverageReadingTime());


        BookIssue bI = new BookIssue(book1, 3, 5000);
        bI.read();
    }
}
