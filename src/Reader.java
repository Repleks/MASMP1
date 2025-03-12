import java.util.List;

public class Reader extends Person {

    private static int avergageBooksReadYearly = 7;
    private int booksReadYearly;
    private Library library;

    public Reader(String name, String surname, int booksReadYearly, Library library) {
        super(name, surname);
        try {
            setBooksReadYearly(booksReadYearly);
            setLibrary(library);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public void setLibrary(Library library) {
        if(library == null) {
            throw new IllegalArgumentException("Library cannot be null");
        }
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public int getBooksReadDifferenceFromAvergage() {
        return booksReadYearly - avergageBooksReadYearly;
    }

    public static int getAvergageBooksReadYearly() {
        return avergageBooksReadYearly;
    }

    public static void setAvergageBooksReadYearly(int avergageBooksReadYearly) {
        if(avergageBooksReadYearly < 0) {
            throw new IllegalArgumentException("Average books read yearly cannot be negative");
        }
        Reader.avergageBooksReadYearly = avergageBooksReadYearly;
    }

    public void tryToRead(Book book) {
        if(book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        System.out.println(super.getName() +" can read " + book.getTitle());
    }

    public void didIReadEnoughBooks() {
        if(booksReadYearly >= avergageBooksReadYearly) {
            System.out.println("You read enough books this year");
        } else {
            System.out.println("You should read more books this year");
        }
    }

    public static int getHowManyBooksHaveBeenReadByReaders() {
        List <Reader> allReaders = ObjectPlus.getExtentFromClass(Reader.class);
        int sum = 0;
        for (Reader reader : allReaders) {
            sum += reader.getBooksReadYearly();
        }
        return sum;
    }

    public int getBooksReadYearly() {
        return booksReadYearly;
    }

    public void setBooksReadYearly(int booksReadYearly) {
        if(booksReadYearly < 0) {
            throw new IllegalArgumentException("Books read yearly cannot be negative");
        }
        this.booksReadYearly = booksReadYearly;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name = " + super.getName() +
                ", surname = " + super.getSurname() +
                ", booksReadYearly=" + booksReadYearly +
                ", library=" + library +
                '}';
    }
}
