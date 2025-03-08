public class BookIssue extends Book {
    private int issueNumber;
    private int volume;

    public BookIssue(Book book, int issueNumber, int volume) {
        super(book.getTitle(), book.getReleaseDate(), book.getAuthor());
        setIssueNumber(issueNumber);
        setVolume(volume);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public int getVolume() {
        return volume;
    }

    public void setIssueNumber(int issueNumber) {
        if(issueNumber < 0) {
            throw new IllegalArgumentException("Issue number must be positive");
        }
        this.issueNumber = issueNumber;
    }

    public void setVolume(int volume) {
        if(volume < 0) {
            throw new IllegalArgumentException("Volume must be positive");
        }
        this.volume = volume;
    }

    public void read() {
        System.out.println("Reading " + super.getTitle() + " book, issue number "+ issueNumber);
    }
}
