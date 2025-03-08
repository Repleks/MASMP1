import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {
    private static int ID = 0;
    private String username;
    private static int averageReadingTime = 0;
    private int readingTime;
    private static final List<Reader> readers = new ArrayList<>();

    public Reader(String name, String username) {
        super(name);
        setUsername(username);
        ID++;
        addReader(this);
    }

    private static void addReader(Reader reader) {
        readers.add(reader);
    }

    public static void showReaders() {
        for(Reader reader : readers) {
            System.out.println("Username: " + reader.getUsername() + " ID: " + reader.getID());
        }
    }

    public static int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public void setUsername(String username) {
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }

    public static int getAverageReadingTime() {
        return averageReadingTime;
    }

    public void readBack(String tmp) {
        System.out.println("You can read now " + tmp);
    }

    public void startReadingFor(int minutes) {
        if(minutes < 0) {
            throw new IllegalArgumentException("Reading time must be positive");
        }
        readingTime += minutes;
        int totalReadingTime = 0;
        for(Reader reader : readers) {
            totalReadingTime += reader.getReadingTime();
        }
        averageReadingTime = totalReadingTime / readers.size();
    }
}
