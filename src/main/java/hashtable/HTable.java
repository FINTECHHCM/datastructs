package hashtable;

import java.util.LinkedList;
import java.util.List;

public class HTable<K, V> {

	private enum RESIZE {
		GROW, SHRINK
	}

	private class Pair {
		public Pair(K k, V v) {
			key = k;
			val = v;
		}

		public K key;
		public V val;
	}

	private final int INIT_SIZE = 8;
	private int _size;
	private int _capacity;
	private List<Pair>[] _table;

	public HTable() {
		_capacity = INIT_SIZE;
		_size = 0;

		_table = (LinkedList<Pair>[]) new LinkedList[_capacity];

		for (int i = 0; i < _table.length; i++) {
			_table[i] = new LinkedList<Pair>();
		}
	}

	public boolean empty() {
		return _size == 0;
	}

	public int size() {
		return _size;
	}

	// return false if key already exists
	public boolean insert(K key, V val) {
		return insert(_table, key, val);
	}

	public boolean contains(K key) {
		for (List<Pair> l : _table) {
			for (Pair p : l) {
				if (p.key == key) {
					return true;
				}
			}
		}

		return false;
	}

	// return true if key was found and removed
	public boolean remove(K key) {
		for (List<Pair> l : _table) {
			for (Pair p : l) {
				if (p.key == key) {
					l.remove(p);
					_size--;
					return true;
				}
			}
		}

		return false;
	}

	// return null if key not found
	public V get(K key) {
		for (List<Pair> l : _table) {
			for (Pair p : l) {
				if (p.key == key) {
					l.remove(p);
					return p.val;
				}
			}
		}

		return null;
	}

	// return false if key already exists
	private boolean insert(List<Pair>[] l, K key, V val) {

		if (_size > INIT_SIZE && _size > 0.75 * _capacity) {
			resize(RESIZE.GROW);
		}

		if (_size > INIT_SIZE && _size < 0.25 * _capacity) {
			resize(RESIZE.SHRINK);
		}

		int hashCode = getHashCode(key);
		
		LinkedList<Pair> ll = (LinkedList<Pair>) _table[hashCode];
		for(Pair p : ll) {
			if(p.key == key)
				return false;
		}
		
		_table[hashCode].add(new Pair(key, val));

		_size++;
		return true;
	}

	private int getHashCode(K key) {
		return key.hashCode() % _capacity;
	}

	private void resize(RESIZE direction) {
		_size = 0;
		_capacity = (direction == RESIZE.GROW) ? _capacity * 2 : _capacity / 2;

		@SuppressWarnings("unchecked")
		List<Pair>[] newTable = (LinkedList<Pair>[]) new LinkedList[_capacity];

		for (int i = 0; i < newTable.length; i++) {
			newTable[i] = new LinkedList<Pair>();
		}

		for (List<Pair> l : _table) {
			for (Pair p : l) {
				insert(newTable, p.key, p.val);
			}
		}

		_table = newTable;
	}

}
