class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { this.key = k; this.value = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Dummy head and tail to simplify edge cases
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        remove(node);
        insertAtHead(node); // Move to most recently used
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 1. Update existing value
            Node node = map.get(key);
            node.value = value;
            // 2. Move to head (MRU)
            remove(node);
            insertAtHead(node);
        } else {
            // 3. Check capacity ONLY for new keys
            if (map.size() == capacity) {
                // Evict LRU (node before dummy tail)
                Node lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }
            // 4. Add new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Helper: Remove node from current DLL position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Always insert right after the dummy head
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
