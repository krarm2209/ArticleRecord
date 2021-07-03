package datastruct;

import model.Article;

import java.io.*;
import java.util.Hashtable;

public class Struct implements Serializable {
    private Hashtable<String, Object> titleStruct;

    public Struct() {
        this.titleStruct = new Hashtable<String, Object>();
    }

    public Hashtable<String, Object> put(Article a) {
        this.titleStruct.put(a.getTitle(), a);
        return this.titleStruct;
    }

    public boolean save() {
        try {
            FileOutputStream fos = new FileOutputStream("titlemap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.titleStruct);
            oos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load() {
        try {
            FileInputStream fis = new FileInputStream("titlemap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.titleStruct = (Hashtable<String, Object>) ois.readObject();
            ois.close();
            fis.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
