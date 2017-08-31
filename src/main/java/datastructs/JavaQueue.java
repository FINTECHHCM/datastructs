package datastructs;


public class JavaQueue<T> {
	
	DoublyLinkedList<T> ll;
	
	public JavaQueue() {
		ll = new DoublyLinkedList<>();
	}
	
	public int size() {
		return ll.size();
	}
	
	public boolean empty() {
		return ll.empty();
	}
	
	public void enqueue(T val) {
		ll.addHead(val);
	}
	
	public T peek() {
		return ll.getTail();
	}
	
	public T dequeue() {
		return ll.removeTail();
	}
	
}
