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
		cache = new HashMap<>();
		this.capacity = capacity;
		count = 0;
		cache = new HashMap<>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	public int size() {
		return count;
	}

	public V get(K key) {
		Node node = cache.get(key);
		if (node != null) {
			removeNode(node);
			addToHead(node);
			return node.val;
		} else {
			return null;
		}
	}

	public void put(K key, V value) {
		Node node = cache.get(key);

		if (node == null) {
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			addToHead(newNode);
			count++;
		} else {
			node.val = value;
			removeNode(node);
			addToHead(node);
		}

		if (count > capacity) {
			Node end = tail.prev;
			removeNode(end);
			cache.remove(end.key);
			count--;
		}
	}

	private void removeNode(Node node) {
		if (count < 3)
			return;

		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	private void addToHead(Node node) {
		Node oldHead = head.next;
		oldHead.prev = node;
		node.next = oldHead;
		node.prev = head;
		head.next = node;
	}
}
