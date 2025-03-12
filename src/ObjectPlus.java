import java.io.*;
import java.util.*;

public class ObjectPlus implements Serializable {
    public static Map<Class, List> extent = new HashMap<>();

    public ObjectPlus() {
        addToExtent();
    }

    public static void saveExtent() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("extent.dat"))){
            oos.writeObject(extent);
            oos.writeInt(Reader.getAvergageBooksReadYearly());
        }
    }

    public static void loadExtent() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("extent.dat"))){
            extent = (Map<Class, List>) ois.readObject();
            Reader.setAvergageBooksReadYearly(ois.readInt());
        }
    }

    public static <T> List<T> getExtentFromClass(Class<T> c) {
        extent.computeIfAbsent(c, _ -> new ArrayList<>());
        return Collections.unmodifiableList(extent.get(c));
    }

    protected void addToExtent() {
       List list = extent.computeIfAbsent(this.getClass(), _ -> new ArrayList<>());
       list.add(this);
    }

    protected void removeFromExtent() {
        List list = extent.get(this.getClass());
        if(list != null) {
            list.remove(this);
        }
    }

}
