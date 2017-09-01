package datastructs;
import datastructs.HTable;
import org.junit.Test;


import org.junit.Assert;

public class HTableTest {

	@Test
	public void constructor() {
		HTable<Integer, Integer> ht = new HTable<>();

		int size = ht.size();

		Assert.assertEquals(0, size);
	}

	@Test
	public void emptyTableReturnsTrue() {
		HTable<Integer, Integer> ht = new HTable<>();

		Assert.assertTrue(ht.empty());
	}

	@Test
	public void emptyTableReturnsZeroSize() {
		HTable<Integer, Integer> ht = new HTable<>();

		boolean res = ht.empty();
		
		Assert.assertTrue(res);
		Assert.assertEquals(0, ht.size());
	}

	@Test
	public void insertNewReturnsTrue() {
		HTable<Integer, Character> ht = new HTable<>();

		boolean res = ht.insert(12, 'c');
		Assert.assertTrue(res);
	}

	@Test
	public void containsFindsKey() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		boolean res = ht.contains(12);

		Assert.assertTrue(res);
	}

	@Test
	public void getReturnsNullOnNoMatch() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		ht.insert(1, 'd');
		ht.insert(2, 'g');
		
		Character c = ht.get(33);
		
		Assert.assertEquals(null , c);
	}

	@Test
	public void getReturnsValue() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		char c = ht.get(12);

		Assert.assertEquals('c', c);
	}

	@Test
	public void insertReturnsFalseOnDuplicates() {
		HTable<Integer, Character> ht = new HTable<>();

		ht.insert(12, 'c');
		boolean res = ht.insert(12, 'a');

		Assert.assertFalse(res);
	}

	@Test
	public void removeDeletesKVPair() {
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
	
}
