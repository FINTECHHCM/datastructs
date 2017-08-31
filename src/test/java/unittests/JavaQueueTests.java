package unittests;

import datastructs.JavaQueue;

import org.junit.Test;
import org.junit.Assert;

public class JavaQueueTests {

	@Test
	public void ConstructorInitsQueue() {
		JavaQueue<Integer> q = new JavaQueue<>();

		int size = q.size();

		Assert.assertEquals(0, size);
	}
	
	@Test
	public void EmptyQueueIsTrue() {
		JavaQueue<Integer> q = new JavaQueue<>();

		boolean res = q.empty();

		Assert.assertTrue(res);
	}
	
	@Test
	public void NonEmptyQueueIsFalse() {
		JavaQueue<Integer> q = new JavaQueue<>();
		q.enqueue(35);
		
		boolean res = q.empty();

		Assert.assertFalse(res);
	}
	
	@Test
	public void QueueEmtpyAfterDequeueingAll() {
		JavaQueue<Integer> q = new JavaQueue<>();
		
		q.enqueue(35);
		q.enqueue(45);
		q.enqueue(55);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		boolean res = q.empty();

		Assert.assertTrue(res);
	}

	@Test
	public void Enqueue() {
		JavaQueue<Integer> q = new JavaQueue<>();
		
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(33);
		q.enqueue(7);

		int end = q.dequeue();
		int peek = q.peek();

		Assert.assertEquals(4, peek);
		Assert.assertEquals(3, end);
	}
	
	@Test
	public void DequeueEmptyIsNull() {
		JavaQueue<Integer> q = new JavaQueue<>();
		
		Integer end = q.dequeue();
		
		Assert.assertNull(end);
	}
	
	@Test
	public void PeekEmptyIsNull() {
		JavaQueue<Integer> q = new JavaQueue<>();
		
		Integer end = q.peek();
		
		Assert.assertNull(end);
	}

}
