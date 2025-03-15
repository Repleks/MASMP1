public class Person extends ObjectPlus {
    private String name;
    private String surname;

    public Person (String name, String surname) {
        try {
            setName(name);
            setSurname(surname);
        }
        catch (Exception e){
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if(surname == null || surname.isBlank()){
            throw new IllegalArgumentException("Surname cannot be null or blank");
        }
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

