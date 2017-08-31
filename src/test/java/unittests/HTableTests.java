package unittests;

import org.junit.Test;

import datastructs.HTable;

import org.junit.Assert;

public class HTableTests {

	@Test
	public void Constructor() {
		HTable<Integer, Integer> ht = new HTable<>();

		int size = ht.size();

		Assert.assertEquals(0, size);
	}

	@Test
	public void EmptyTableReturnsTrue() {
		HTable<Integer, Integer> ht = new HTable<>();

		Assert.assertTrue(ht.empty());
	}

	@Test
	public void EmptyTableReturnsZeroSize() {
		HTable<Integer, Integer> ht = new HTable<>();

		Assert.assertEquals(0, ht.size());
	}

	@Test
	public void InsertNewReturnsTrue() {
		HTable<Integer, Character> ht = new HTable<>();

		boolean res = ht.insert(12, 'c');
		Assert.assertTrue(res);
	}

	@Test
	public void ContainsFindsKey() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		boolean res = ht.contains(12);

		Assert.assertTrue(res);
	}

	@Test
	public void GetReturnsNullOnNoMatch() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		ht.insert(1, 'd');
		ht.insert(2, 'g');
		
		Character c = ht.get(33);
		
		Assert.assertEquals(null , c);
	}

	@Test
	public void GetReturnsValue() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		char c = ht.get(12);

		Assert.assertEquals('c', c);
	}

	@Test
	public void InsertReturnsFalseOnDuplicates() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		boolean res = ht.insert(12, 'a');

		Assert.assertFalse(res);
	}

	@Test
	public void RemoveDeletesKVPair() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		ht.insert(1, 'a');
		ht.insert(16, 'g');
		ht.insert(5, 'n');

		boolean res = ht.remove(1);
		boolean found = ht.contains(1);

		Assert.assertTrue(res);
		Assert.assertFalse(found);
	}
	
	@Test
	public void ResizeTable() {
		HTable<Integer, Integer> ht = new HTable<>();
		
		for(int i=0;i<14;i++) {
			ht.insert(i, i);
		}
		
		int size = ht.size();
		
		Assert.assertEquals(14, size);
	}

}
