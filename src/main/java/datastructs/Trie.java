package datastructs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {

	private class TrieNode {
		private boolean isWord;
		private HashMap<Character, TrieNode> charMap;

		public TrieNode() {
			isWord = false;
			charMap = new HashMap<Character, TrieNode>();
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}

		public TrieNode add(Character c) {
			TrieNode newNode;
			if (charMap.containsKey(c))
				newNode = charMap.get(c);
			else {
				newNode = new TrieNode();
				charMap.put(c, newNode);
			}
			return newNode;
		}

		public boolean contains(Character c) {
			return charMap.containsKey(c);
		}

		public TrieNode getNext(Character c) {
			return charMap.get(c);
		}
	}

	private TrieNode _root;
	private int _size;

	public Trie() {
		init();
	}

	public int size() {
		return _size;
	}

	public boolean empty() {
		return _size == 0;
	}

	public void clear() {
		init();
	}

	public void add(String word) {
		TrieNode node = _root;

		for (int i = 0; i < word.length(); i++) {
			if (i == word.length() - 1 && node.isWord() == false) {
				node.setWord(true);
				_size++;
				break;
			}

			node = node.add(word.charAt(i));
		}
	}

	public boolean find(String word) {
		TrieNode node = _root;

		for (int i = 0; i < word.length() - 1; i++) {
			if (!node.contains(word.charAt(i))) {
				return false;
			}
			node = node.getNext(word.charAt(i));
		}

		return node.isWord();
	}

	public void remove(String word) {
		if (empty())
			return;

		TrieNode node = _root;

		Stack<TrieNode> path = new Stack<TrieNode>();
		path.push(node);

		for (int i = 0; i < word.length() - 1; i++) {
			if (!node.contains(word.charAt(i))) {
				return;
			}
			node = node.getNext(word.charAt(i));
			path.push(node);
		}

		if (!node.isWord)
			return;

		if (node.charMap.size() > 0) {
			node.setWord(false);
		} else {
			TrieNode current = path.pop();
			while (!path.empty() && current.charMap.size() == 0) {
				TrieNode parent = path.pop();
				parent.charMap.clear();
				current = null;
				current = parent;
			}
		}

		_size--;
	}

	private void init() {
		_root = new TrieNode();
		_size = 0;
	}

}
