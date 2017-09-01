package datastructs;

import java.util.HashMap;

public class LRUCache<K, V> {

	private class Node {
		K key;
		V val;
		Node next, prev;

		Node(K key, V val) {
			this.key = key;
			this.val = val;
			next = null;
			prev = null;
		}

		Node() {
			this(null, null);
		}
	}

	private int capacity;
	private int count;
	private HashMap<K, Node> cache;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		count = 0;
		cache = new HashMap<>();
		head = new Node();
		tail = new Node();
	}
	
	public int size() {
		return count;
	}
	
    public int get(K key) {
        return 0;
    }
    
    public void put(K key, V value) {
        
    }
}
