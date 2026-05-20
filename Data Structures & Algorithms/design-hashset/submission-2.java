class MyHashSet {
  private final int BUCKET_SIZE = 1000000;
  private LinkedList<Integer>[] buckets;

  public MyHashSet() {
    buckets = new LinkedList[BUCKET_SIZE];
  }

  private int hash(int key) {
    return key % BUCKET_SIZE;
  }

  public void add(int key) {
    int index = hash(key);
    if (buckets[index] == null) {
      buckets[index] = new LinkedList<>();
    }
    if (!buckets[index].contains(key)) {
      buckets[index].add(key);
    }
  }

  public void remove(int key) {
    int index = hash(key);
    if (buckets[index] != null) {
      buckets[index].remove((Integer) key);
    }
  }

  public boolean contains(int key) {
    int index = hash(key);
    return buckets[index] != null && buckets[index].contains(key);
  }
}