package datastructs;

import org.junit.Assert;
import org.junit.Test;

import datastructs.LRUCache;

public class LRUCacheTest {

	@Test
	public void InitSizes() {
		int capacity = 20;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		int size = cache.size();
		
		Assert.assertEquals(0, size);
	}
	
	@Test
	public void getReturnsValue() {
		int capacity = 4;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		int res =  cache.get(2);
		
		Assert.assertEquals(20, res);	
	}
	
	@Test
	public void putUpdatesExistingKeyValue() {
		int capacity = 20;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		cache.put(1, 4);
		cache.put(1, 6);
		
		int size = cache.size();
		int val = cache.get(1);
		
		Assert.assertEquals(1, size);
		Assert.assertEquals(6, val);
	}
	
	@Test
	public void getReturnsNullOnNoFind() {
		int capacity = 20;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		cache.put(1, 4);
		cache.put(1, 6);
		
		Integer res = cache.get(2);
		
		Assert.assertNull(res);
	}
	
	@Test
	public void putRemovesOldestAtCapacity() {
		int capacity = 4;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		cache.put(4, 40);
		cache.get(1);
		cache.get(3);
		cache.get(4);
		cache.get(1);
		cache.put(5, 50); // should remove 2
		
		int size = cache.size();
		Assert.assertEquals(4, size);
		
		Integer res = cache.get(2);
		Assert.assertNull(res);	
	}
	
}
