class LRUCache {
    private int capacity;
    private Node head = null;
    private Node tail = null;
    private Map<Integer, Node> map;
        
    class Node {
        public int val;
        public int key;
        public Node next;
        public Node prev;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>(capacity);
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            moveToHead(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (this.map.size() == capacity) {
                this.map.remove(this.tail.key);
                removeTail();
            }
            Node node = new Node(key, value);
            this.map.put(key, node);
            addToHead(node);
        }
    }
    
    private void addToHead(Node node) {
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }
    
    private void moveToHead(Node node) {
        if (node == head) 
            return;
        if (node == tail) {
            node.prev.next = null;
            this.tail = node.prev;
            node.prev = null;
            addToHead(node);
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            addToHead(node);
        }
    }
    
    private void removeTail() {
        if (this.tail == null)
            return;
        if (this.tail == this.head) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
    }
}