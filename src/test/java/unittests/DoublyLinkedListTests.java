package unittests;

import org.junit.Test;

import datastructs.DoublyLinkedList;

import org.junit.Assert;

public class DoublyLinkedListTests {
	
	@Test
	public void ConstructorInitSize() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		int size = ll.size();
		boolean res = ll.empty();
		
		Assert.assertTrue(res);
		Assert.assertEquals(0, size);
	}
	
	@Test
	public void SizeGetsCount() {
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
	public void RemoveFromEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		Integer head = ll.removeHead();
		
		Assert.assertNull(head);
	}
	
	@Test 
	public void RemoveValueFromEmptyList() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		boolean res = ll.remove(3);
		
		Assert.assertFalse(res);
	}
	
	@Test 
	public void RemoveValueFromLsitOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		ll.addHead(3);
		boolean res = ll.remove(3);
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertTrue(res);
	}
	
	@Test 
	public void RemoveHeadFromListOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		ll.addHead(3);
		int head = ll.removeHead();
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertEquals(3, head);
	}
	
	@Test 
	public void RemoveTailFromListOfSizeOne() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
				
		ll.addHead(3);
		int head = ll.removeTail();
		int size = ll.size();
		
		Assert.assertEquals(0, size);
		Assert.assertEquals(3, head);
	}
	
	@Test 
	public void RemoveHead() {
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
	public void RemoveTail() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addHead(2);
		ll.addHead(4);
		ll.addHead(44);
		ll.addHead(5);
		
		int tail = ll.removeTail();
		
		Assert.assertEquals(2, tail);
	}
	
	@Test 
	public void RemoveExistingElement() {
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
	public void RemoveExistingElementFromHead() {
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
	public void RemoveExistingElementFromTail() {
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
	public void RemoveNonExistingElement() {
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
	public void AddTail() {
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
	public void IndexOfExistingValue() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		ll.addTail(2);
		ll.addTail(4);
		ll.addTail(44);
		ll.addTail(5);
		
		int idx = ll.indexOf(44);
		
		Assert.assertEquals(2, idx);
	}
	
	@Test 
	public void IndexOfMissingValue() {
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
	public void EmptyListContains() {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<>();
		
		boolean res = ll.contains(100);
		
		Assert.assertFalse(res);
	}
	
	@Test 
	public void Contains() {
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
	
}