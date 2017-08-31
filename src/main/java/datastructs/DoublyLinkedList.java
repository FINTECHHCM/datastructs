package datastructs;

public class DoublyLinkedList<T> {
	private class Node {
		public T val;
		public Node next, prev;

		Node(T val) {
			this.val = val;
			next = null;
			prev = null;
		}
	}

	private Node head;
	private Node tail;
	private int count;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}
	
	public void show() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.val + " ");
			n=n.next;
		}
	}

	public int size() {
		return count;
	}

	public boolean empty() {
		return count == 0;
	}

	public void addHead(T val) {
		Node n = new Node(val);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
		}
		count++;
	}

	public void addTail(T val) {
		Node n = new Node(val);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
		count++;
	}

	// return -1 if not found
	public int indexOf(T val) {
		Node cur = head;
		int i = 0;

		while (cur != null) {
			if (cur.val == val) {
				return i;
			}
			i++;
			cur = cur.next;
		}

		return -1;
	}

	// return false if not found
	public boolean contains(T val) {
		if (head == null)
			return false;

		Node cur = head;

		while (cur != null) {
			if (cur.val == val) {
				return true;
			}

			cur = cur.next;
		}

		return false;
	}

	// return false if not found
	public boolean remove(T val) {
		if (head == null)
			return false;

		if (head.next == null && val == head.val) {
			head = null;
			tail = null;
			count--;
			return true;
		}

		Node cur = head;

		while (cur != null) {
			if (cur.val == val) {

				if (cur == head) {
					removeHead();
				} else if (cur == tail) {
					removeTail();
				} else {
					cur.prev.next = cur.next;
					cur.next.prev = cur.prev;
				}

				count--;
				return true;
			}

			cur = cur.next;
		}

		return false;
	}

	public T removeHead() {
		if (head == null)
			return null;

		Node oldHead = head;

		if (head.next == null) {
			head = null;
			tail = null;
		} else {
			head.next.prev = null;
			head = head.next;
		}

		count--;
		return oldHead.val;
	}

	public T removeTail() {
		if (tail == null)
			return null;

		Node oldTail = tail;

		if (tail.prev == null) {
			head = null;
			tail = null;
		} else {
			tail.prev.next = null;
			tail = tail.prev;
		}

		count--;
		return oldTail.val;
	}

	public T getHead() {
		if (head == null)
			return null;
		else
			return head.val;
	}
	
	public T getTail() {
		if (tail == null)
			return null;
		else
			return tail.val;
	}
}
