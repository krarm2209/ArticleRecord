package datastruct;

import model.Article;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Struct implements Serializable {
    private Hashtable<String, Article> titleHashTable;
    private ArrayList<Article> articleList;

    public Struct() {
        this.titleHashTable = new Hashtable<String, Article>();
        this.articleList = new ArrayList<Article>();
    }

    public ArrayList<Article> put(Article a) {
        this.titleHashTable.put(a.getTitle(), a);
        this.articleList.add(a);
        this.save();
        return this.articleList;
    }

    public ArrayList<Article> getRecords() {
        return this.articleList;
    }

    public Hashtable<String, Article> getTitleHashTable() {
        return this.titleHashTable;
    }

    public boolean save() {
        try {
            FileOutputStream fos = new FileOutputStream("struct.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
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

    public static Struct load() {
        try {
            FileInputStream fis = new FileInputStream("struct.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Struct temp = (Struct) ois.readObject();
            ois.close();
            fis.close();
            return temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
