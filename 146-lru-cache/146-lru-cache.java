class Node {
    int key, value;
    Node next;
    Node prev;
    
    Node(int _key, int _value) {
        this.key = _key;
        this.value = _value;
        next = prev = null;
    }
}
class LRUCache {
    
    Map<Integer, Node> map;
    Node head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        // remove the node from list and add to start
        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            removeNode(map.get(key));
        }
        
        if(map.size() == capacity) {
            // remove the least recently used node
            removeNode(tail.prev);
        }
        Node curr = new Node(key,value);
        addNode(curr);
    }
    
    private void addNode(Node node) {
        // add node to the start of the list
        map.put(node.key, node);
        Node next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void removeNode(Node node) {
        // remove node from the list
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */