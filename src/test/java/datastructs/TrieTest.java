package datastructs;

import org.junit.Test;
import org.junit.Assert;
import datastructs.Trie;

public class TrieTest {

	@Test
	public void initTrie() {
		Trie trie = new Trie();

		int size = trie.size();
		boolean empty = trie.empty();

		Assert.assertEquals(0, size);
		Assert.assertTrue(empty);
	}

	@Test
	public void clearTrie() {
		Trie trie = new Trie();

		trie.add("words");
		trie.add("testing");
		trie.add("test");

		trie.clear();
		int size = trie.size();
		boolean empty = trie.empty();

		Assert.assertTrue(empty);
		Assert.assertEquals(0, size);
	}

	@Test
	public void doNotCountDuplicatesOnInsert() {

		Trie trie = new Trie();
		trie.add("words");
		trie.add("testing");
		trie.add("words");
		trie.add("test");
		trie.add("words");
		trie.add("words");

		int size = trie.size();
		boolean empty = trie.empty();

		Assert.assertEquals(3, size);
		Assert.assertFalse(empty);
	}

	@Test
	public void findExistingWord() {
		Trie trie = new Trie();
		trie.add("words");
		trie.add("testing");
		trie.add("test");

		boolean found1 = trie.find("words");
		boolean found2 = trie.find("testing");
		boolean found3 = trie.find("test");

		Assert.assertTrue(found1);
		Assert.assertTrue(found2);
		Assert.assertTrue(found3);
	}

	@Test
	public void findNonExistingWords() {
		Trie trie = new Trie();
		trie.add("words");
		trie.add("testing");
		trie.add("test");

		boolean found1 = trie.find("cat");
		boolean found2 = trie.find("testin");
		boolean found3 = trie.find("word");

		Assert.assertFalse(found1);
		Assert.assertFalse(found2);
		Assert.assertFalse(found3);
	}

	@Test
	public void removeNonLeafFromEmptyTrie() {
		Trie trie = new Trie();

		trie.add("words");
		trie.add("testing");
		trie.add("test");

		trie.remove("test");
		int size = trie.size();

		boolean found = trie.find("test");

		Assert.assertFalse(found);
		Assert.assertEquals(2, size);
	}

	@Test
	public void removeLeafFromTrie() {
		Trie trie = new Trie();

		trie.add("words");
		trie.add("testing");
		trie.add("test");

		trie.remove("testing");

		int size = trie.size();
		boolean found = trie.find("testing");

		Assert.assertEquals(2, size);
		Assert.assertFalse(found);
	}

	@Test
	public void removeNonExistingWordFromTrie() {
		Trie trie = new Trie();

		trie.add("words");
		trie.add("testing");
		trie.add("test");

		trie.remove("tes");
		int size = trie.size();

		Assert.assertEquals(3, size);
	}
}
