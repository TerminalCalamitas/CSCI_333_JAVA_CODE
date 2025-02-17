package testing;
public class Test1 {

    public static int hash(int key, int i, int m) {
        int h1 = h1(key, m);
        int h2 = h2(key, m);
        return (h1 + i * h2) % m;
    }

    public static int h1(int key, int m) {
        return key % m;
    }

    public static int h2(int key, int m) {
        return (key % (m - 1)) + 1;
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 6;
        int[] keys = {3, 17, 6, 12, 5, 27};

        // Hash table (array) of size m
        int[] hashTable = new int[m];

        // Insert keys into the hash table
        for (int key : keys) {
            int i = 0;
            int index = hash(key, i, m);
            while (hashTable[index] != 0) {
                i++;
                index = hash(key, i, m);
            }
            hashTable[index] = key;
        }

        // Print the hash table
        System.out.println("Hash Table:");
        for (int i = 0; i < m; i++) {
            System.out.println("Index " + i + ": " + hashTable[i]);
        }
    }
}