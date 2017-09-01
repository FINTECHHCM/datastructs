package unittests;

import org.junit.Assert;
import org.junit.Test;

import datastructs.LRUCache;

public class LRUCacheTests {

	@Test
	public void InitSizes() {
		int capacity = 20;
		LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(capacity);
		
		int size = cache.size();
		
		Assert.assertEquals(0, size);
	}
}
