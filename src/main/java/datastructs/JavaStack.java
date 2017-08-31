package datastructs;

import javax.naming.OperationNotSupportedException;

public class JavaStack<T> {

	private enum RESIZE {
		GROW, SHRINK
	}

	private T[] data;
	private int index;
	private final int INIT_CAPACITY = 8;

	@SuppressWarnings("unchecked")
	public JavaStack() {
		data = (T[]) new Object[INIT_CAPACITY];
		index = -1;
	}

	public int size() {
		return index + 1;
	}

	public boolean empty() {
		return index == -1;
	}

	public void push(T val) {
		if (index + 1 == data.length) {
			resize(RESIZE.GROW);
		}

		data[++index] = val;
	}

	public T pop() throws OperationNotSupportedException {
		if (index == -1)
			throw new OperationNotSupportedException();

		if (index + 1 < 0.25 * data.length) {
			resize(RESIZE.SHRINK);
		}

		return data[index--];
	}

	public T peek() throws OperationNotSupportedException {
		if (index == -1)
			throw new OperationNotSupportedException();

		return data[index];
	}

	@SuppressWarnings("unchecked")
	private void resize(RESIZE direction) {
		T[] newData;

		int newCapacity = (direction == RESIZE.GROW) ? data.length * 2 : data.length / 2;
		newData = (T[]) new Object[newCapacity];

		for (int i = 0; i < index + 1; i++) {
			newData[i] = data[i];
		}

		data = newData;
	}
}
