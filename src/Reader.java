import java.util.List;

public class Reader extends Person {

    private static int avergageBooksReadYearly = 7;
    private int booksReadYearly;
    private Library library;
    private static int id = 1;
    private int ID;

    public Reader(String name, String surname, int booksReadYearly, Library library) {
        super(name, surname);
        try {
            setBooksReadYearly(booksReadYearly);
            setLibrary(library);
            ID = id;
            id++;
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    @Override
    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        } else if (name.length() < 3) {
            throw new IllegalArgumentException("Name can't be that short");
        }
        super.setName(name);
    }

    @Override
    public void setSurname(String surname) {
        if(surname == null || surname.isBlank()){
            throw new IllegalArgumentException("Surname cannot be null or blank");
        }
        else if(surname.length() < 3) {
            throw new IllegalArgumentException("Surname can't be that short");
        }
        super.setSurname(surname);
    }

    public int getID() {
        return ID;
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

    public void tryToRead(int bookID) {
        List <Book> allBooks = ObjectPlus.getExtentFromClass(Book.class);
        for (Book book : allBooks) {
            if(book.getId() == bookID){
                System.out.println(super.getName() +" can read " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ID "+ bookID + " not found");
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

    public static int getHowManyBooksHaveBeenReadByReaders(int idFrom, int idTo){
        List <Reader> allReaders = ObjectPlus.getExtentFromClass(Reader.class);
        int sum = 0;
        for (Reader reader : allReaders) {
            if(reader.getID() >= idFrom && reader.getID() <= idTo){
                sum += reader.getBooksReadYearly();
            }
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
                "ID=" + ID +
                ", name = " + super.getName() +
                ", surname = " + super.getSurname() +
                ", booksReadYearly=" + booksReadYearly +
                ", library=" + library +
                '}';
    }
}
