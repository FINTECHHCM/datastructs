package datastructs;

import java.util.List;

public class Heap<T extends Comparable<T>> {

	private enum Resize {
		GROW, SHRINK
	}

	private int _count;
	private T[] _data;
	private final int INITSIZE = 8;
	private final double SHRINK_THRESHOLD = 0.25;
	private final int RESIZE_MULT = 2;

	@SuppressWarnings("unchecked")
	public Heap() {
		_count = 0;
		_data = (T[]) new Comparable[INITSIZE];
	}

	public int size() {
		return _count;
	}

	public boolean empty() {
		return _count == 0;
	}

	public void clear() {
		_count = 0;
		_data = null;
	}

	@SuppressWarnings("unchecked")
	public void _heapify(List<T> data) {
		if (data == null)
			return;

		_count = data.size();
		_data = (T[]) new Comparable[_count];

		for (int i = 0; i < _count; i++)
			_data[i] = data.get(i);

		for (int i = (_count / 2) - 1; i >= 0; i--)
			siftDown(i);
	}

	public void add(T val) {
		if (_count == _data.length)
			resize(Resize.GROW);

		_data[_count] = val;
		siftUp(_count);
		_count++;
	}

	public T top() {
		if (_count < 1)
			return null;
		else
			return _data[0];
	}

	public T removeTop() {
		if (_count < 1)
			return null;

		T top = _data[0];
		_data[0] = _data[--_count];
		siftDown(0);

		if (SHRINK_THRESHOLD * _data.length > _count && _count > INITSIZE * RESIZE_MULT)
			resize(Resize.SHRINK);

		return top;
	}

	private void siftUp(int idx) {
		while (idx > 0 && _data[idx].compareTo(_data[(idx - 1) / 2]) < 0) {
			swap(idx, (idx - 1) / 2);
			idx = (idx - 1) / 2;
		}
	}

	private void siftDown(int node) {
		while (2 * node + 1 < _count) {
			int child = 2 * node + 1;
			int largerChild = child;

			if (child + 1 < _count && _data[child + 1].compareTo(_data[child]) < 0)
				largerChild = child + 1;

			if (_data[largerChild].compareTo(_data[node]) < 0) {
				swap(node, largerChild);
				node = largerChild;
			} else
				node = _count;
		}
	}

	private void swap(int idx1, int idx2) {
		T tmp = _data[idx1];
		_data[idx1] = _data[idx2];
		_data[idx2] = tmp;
	}

	@SuppressWarnings("unchecked")
	private void resize(Resize direction) {
		T[] newData;

		if (direction == Resize.GROW)
			newData = (T[]) new Object[_data.length * RESIZE_MULT];
		else
			newData = (T[]) new Object[_data.length / RESIZE_MULT];

		for (int i = 0; i < _data.length; i++) {
			newData[i] = _data[i];
		}

		_data = newData;
	}
}
