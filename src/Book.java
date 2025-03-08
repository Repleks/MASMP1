import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    private String title;
    // atrybut złożony
    private Date releaseDate;
    // atrybut opcjonalny
    private String author;
    // atrybut klasowy
    private static int ID = 1;
    private final int id;
    // atrybut powtarzalny
    private final List<BookIssue> issues = new ArrayList<>();

    public Book(String title, Date releaseDate, String author) {
        setTitle(title);
        setReleaseDate(releaseDate);
        setAuthor(author);
        id = ID++;
    }

    public void addBookIssue(int issueNumber, int volume) {
        BookIssue issue = new BookIssue(this, issueNumber, volume);
        issues.add(issue);
    }

    public void showIssues() {
        for(BookIssue issue : issues) {
            System.out.println("Number of books printed " +issue.getVolume() + " (" + issue.getIssueNumber() + ")");
        }
    }

    public static int getID() {
        return ID;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null || author.isBlank()) {
            author = "Unknown";
        }
        this.author = author;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public void read() {
        System.out.println("Reading " + title + " book");
    }
}
