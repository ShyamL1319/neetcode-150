class MyHashMap {
    private class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int CAPACITY = 10007; // Using a prime number for better distribution
    private List<Entry>[] table;

    public MyHashMap() {
        table = new LinkedList[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value; // Update existing key
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.key == key) return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.key == key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */