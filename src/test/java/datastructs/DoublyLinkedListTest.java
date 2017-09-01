package datastructs;

import org.junit.Test;

import datastructs.DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;

public class DoublyLinkedListTest{
	
	@Test
	public void constructorInitSize() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		int size = ll.size();
		boolean res = ll.empty();
		
		Assert.assertTrue(res);
		Assert.assertEquals(0, size);
	}
	
	@Test
	public void sizeGetsCount() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(2);
		
		int size = ll.size();
		boolean res = ll.empty();
		
		Assert.assertFalse(res);
		Assert.assertEquals(3, size);
	}
	
	@Test 
	public void removeFromEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		Integer head = ll.removeHead();
		
		Assert.assertNull(head);
	}
	
	@Test 
	public void removeValueFromEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		boolean res = ll.remove(3);
		
		Assert.assertFalse(res);
	}
	
	@Test 
	public void removeValueFromLsitOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		ll.addHead(3);
		boolean res = ll.remove(3);
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertTrue(res);
	}
	
	@Test 
	public void removeHeadFromListOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		ll.addHead(3);
		int head = ll.removeHead();
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertEquals(3, head);
	}
	
	@Test 
	public void removeTailFromListOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		ll.addHead(3);
		int head = ll.removeTail();
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertEquals(3, head);
	}
	
	@Test 
	public void removeHead() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		int head = ll.removeHead();
		int newHead = ll.getHead();
		
		Assert.assertEquals(44, newHead);
		Assert.assertEquals(5, head);
	}
	
	@Test 
	public void removeTail() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		int tail = ll.removeTail();
		
		Assert.assertEquals(2, tail);
	}
	
	@Test 
	public void removeExistingElement() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		boolean res = ll.remove(44);
		int size = ll.size();
		int head = ll.getHead();
		
		Assert.assertEquals(5, head);
		Assert.assertEquals(3, size);
		Assert.assertTrue(res);
	}
	
	@Test 
	public void removeExistingElementFromHead() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		boolean res = ll.remove(5);
		int size = ll.size();
		int head = ll.getHead();
		
		Assert.assertEquals(44, head);
		Assert.assertEquals(3, size);
		Assert.assertTrue(res);
	}
	
	@Test 
	public void removeExistingElementFromTail() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		boolean res = ll.remove(2);
		int size = ll.size();
		int head = ll.getTail();
		
		Assert.assertEquals(4, head);
		Assert.assertEquals(3, size);
		Assert.assertTrue(res);
	}
	
	@Test 
	public void removeNonExistingElement() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		boolean res = ll.remove(222);
		int size = ll.size();
		
		Assert.assertEquals(4, size);
		Assert.assertFalse(res);
	}
	
	@Test 
	public void addTail() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(2);
		ll.addTail(4);
		ll.addTail(44);
		ll.addTail(5);
		
		int tail = ll.removeTail();
		int newTail = ll.getTail();
		
		Assert.assertEquals(44, newTail);
		Assert.assertEquals(5, tail);
	}
	
	@Test
	public void getHeadFromEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		Integer head = ll.getHead();
		
		Assert.assertNull(head);
	}
	
	@Test 
	public void indexOfExistingValue() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(2);
		ll.addTail(4);
		ll.addTail(44);
		ll.addTail(5);
		
		int idx = ll.indexOf(44);
		
		Assert.assertEquals(2, idx);
	}
	
	@Test 
	public void indexOfMissingValue() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(2);
		ll.addTail(4);
		ll.addTail(44);
		ll.addTail(5);
		
		int idx = ll.indexOf(100);
		int tail = ll.getTail();
		
		Assert.assertEquals(5, tail);
		Assert.assertEquals(-1, idx);
	}
	
	@Test 
	public void emptyListContains() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		boolean res = ll.contains(100);
		
		Assert.assertFalse(res);
	}
	
	@Test 
	public void contains() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(2);
		ll.addTail(4);
		ll.addTail(44);
		ll.addTail(5);
		
		boolean res1 = ll.contains(44);
		boolean res2 = ll.contains(100);
		
		Assert.assertTrue(res1);
		Assert.assertFalse(res2);
	}
	
	@Test 
	public void iteratorOnEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		Iterator<Integer> itr = ll.iterator();
		boolean res = itr.hasNext();
		
		Assert.assertFalse(res);
	}
	
	@Test 
	public void iteratorOnNonEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(0);
		ll.addTail(1);
		ll.addTail(2);
		ll.addTail(3);
		
		Iterator<Integer> itr = ll.iterator();
		
		Integer j=0;
		while(itr.hasNext()) {
			Integer i = itr.next();
			Assert.assertEquals(j, i);
			j++;
		}
		
		boolean res = itr.hasNext();
		Assert.assertFalse(res);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void iteratorNextThrowsExceptionOnEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		Iterator<Integer> itr = ll.iterator();
		
		@SuppressWarnings("unused")
		Integer i = itr.next();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void iteratorRemoveThrowsException() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		Iterator<Integer> itr = ll.iterator();
		
		itr.remove();
	}
	
}