import java.io.Serializable;

public class BookIssue implements Serializable {
    private int volume;
    private int id;

    public BookIssue(int volume, int id) {
        setId(id);
        setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Volume cannot be negative");
        }
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookIssue{" +
                "volume=" + volume +
                ", id=" + id +
                '}';
    }
}
