import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book extends ObjectPlus {
    private int id;
    private String title;
    private LocalDate releaseDate;
    private final List<BookIssue> bookIssues = new ArrayList<>();
    private String author;
    private String authorPseudonym;
    private LocalDate bookAge;

    public Book(int id, String title, LocalDate releaseDate, String author) {
        try{
            setId(id);
            setTitle(title);
            setReleaseDate(releaseDate);
            setAuthor(author);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public Book(int id, String title, LocalDate releaseDate, String author, String authorPseudonym) {
        try{
            setId(id);
            setTitle(title);
            setReleaseDate(releaseDate);
            setAuthor(author);
            setAuthorPseudonym(authorPseudonym);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public LocalDate getBookAge() {
        bookAge = LocalDate.now().minusYears(releaseDate.getYear());
        return bookAge;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorPseudonym() {
        return authorPseudonym;
    }

    public void setAuthor(String author) {
        if(author == null || author.isBlank()){
            throw new IllegalArgumentException("Author cannot be null or blank");
        }
        this.author = author;
    }

    public void setAuthorPseudonym(String pseudonym) {
        if(!(pseudonym==null)){
            if(!pseudonym.isEmpty()){
            }
        }
        this.authorPseudonym = pseudonym;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative");
        }
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if(releaseDate == null){
            throw new IllegalArgumentException("Release date cannot be null");
        }
        if(releaseDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Release date cannot be in the future");
        }
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addBookIssue(BookIssue bookIssue) {
        if(!bookIssues.contains(bookIssue)) {
            bookIssues.add(bookIssue);
        }
    }

    public void removeBookIssue(BookIssue bookIssue) {
        if(!bookIssues.contains(bookIssue)){
            throw new IllegalArgumentException("This book issue does not exist");
        }
        bookIssues.remove(bookIssue);
    }

    public List<BookIssue> getBookIssues() {
        return Collections.unmodifiableList(bookIssues);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", bookIssues=" + bookIssues +
                ", author='" + author + '\'' +
                ", authorPseudonym='" + authorPseudonym + '\'' +
                '}';
    }
}
