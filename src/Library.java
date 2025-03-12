import java.io.Serializable;

public class Library implements Serializable {
    private String city;
    private String name;

    public Library(String city, String name) {
        setCity(city);
        setName(name);
    }

    public void setCity(String city) {
        if(city == null || city.isBlank()){
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        this.city = city;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Library{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
