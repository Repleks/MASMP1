import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(1, "Test1", LocalDate.of(1999, 1,1), "Author1", "Pseudonym1");
        Book book2 = new Book(2, "TEst2", LocalDate.of(2000, 1,1), "Author2");
        Book book3 = new Book(3, "Test5", LocalDate.of(2001, 1,1), "Author3", "");

        book1.addBookIssue(new BookIssue(10000, 1));
        book1.addBookIssue(new BookIssue(10001, 2));
        book1.addBookIssue(new BookIssue(10002, 3));

        System.out.println("Test1 release date " + book1.getReleaseDate());
        System.out.println("Test1 author pseudonym "+book1.getAuthorPseudonym());
        System.out.println("Test2 author pseudonym "+book2.getAuthorPseudonym());
        System.out.println("Test1 book issues "+ book1.getBookIssues());
        System.out.println("Test2 age "+ book2.getBookAge());
        System.out.println("Average books read yearly in Poland "+ Reader.getAvergageBooksReadYearly());

        Reader reader1 = new Reader("Test", "Test", 10, new Library("TestCity1", "TestLibraryName1"));
        Reader reader2 = new Reader("Test2", "Test2", 20, new Library("TestCity2", "TestLibraryName2"));
        Reader reader3 = new Reader("Test3", "Test3", 0, new Library("TestCity3", "TestLibraryName3"));
        Reader reader4 = new Reader("Test4", "Test4", 1, new Library("TestCity4", "TestLibraryName4"));

        System.out.println("Readers have read "+ Reader.getHowManyBooksHaveBeenReadByReaders() + " books this year");
        System.out.println("Reader1 books read yearly "+ reader1.getBooksReadYearly()+ " which is "+ reader1.getBooksReadDifferenceFromAvergage() + " from average");
        System.out.println("Reader2 books read yearly "+ reader2.getBooksReadYearly()+ " which is "+ reader2.getBooksReadDifferenceFromAvergage() + " from average");
        System.out.println("Reader3 books read yearly "+ reader3.getBooksReadYearly()+ " which is "+ reader3.getBooksReadDifferenceFromAvergage() + " from average");
        System.out.println("Reader4 books read yearly "+ reader4.getBooksReadYearly()+ " which is "+ reader4.getBooksReadDifferenceFromAvergage() + " from average");

        Person person1 = new Person("PersonTest", "pTest");
        person1.tryToRead();
        reader1.tryToRead(book1);

        try{
            ObjectPlus.saveExtent();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            ObjectPlus.loadExtent();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(ObjectPlus.getExtentFromClass(Book.class));
//        System.out.println(ObjectPlus.getExtentFromClass(Reader.class));
//        System.out.println(ObjectPlus.getExtentFromClass(Person.class));
    }
}
