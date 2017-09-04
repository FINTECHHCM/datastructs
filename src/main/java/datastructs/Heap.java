package datastructs;

import java.util.Comparator;
import java.util.List;

public class Heap<T> {

	private enum Resize {
		GROW, SHRINK
	}

	private Comparator<T> _comp;
	private int _count;
	private T[] _data;
	private final int INITSIZE = 8;

	@SuppressWarnings("unchecked")
	public Heap(Comparator<T> comp) {
		this._comp = comp;
		_count = 0;
		_data = (T[]) new Object[INITSIZE];
	}

	public int size() {
		return _count;
	}

	public void clear() {
		_count = 0;
		_data = null;
		_comp = null;
	}

	public T top() {
		if (_count > 0)
			return _data[0];
		else
			return null;
	}

	public T get() {
		if (_count > 0) {
			_count--;
			siftUp();
			
			if(0.25 * _data.length > _count)
				resize(Resize.SHRINK);
			
			return _data[0];
		} else
			return null;
	}

	public void heapify(List<T> data) {
		_count = data.size();
	}

	public void add(T val) {
		
		_count++;
	}

	private void siftUp() {

	}

	private void siftDown() {

	}

	@SuppressWarnings("unchecked")
	private void resize(Resize direction) {
		T[] newData;

		if (direction == Resize.GROW)
			newData = (T[]) new Object[_data.length * 2];
		else
			newData = (T[]) new Object[_data.length / 2];

		for (int i = 0; i < _data.length; i++) {
			newData[i] = _data[i];
		}

		_data = newData;
	}
}
