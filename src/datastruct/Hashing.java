package datastruct;

public class Hashing {
    public static int djb2_Hashing(String s) {
        int hash = 5381;

        for (char c: s.toCharArray()) {
            hash = (hash * 33) + c;
        }

        return hash;
    }
}
