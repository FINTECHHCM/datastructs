package datastructs;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class HeapTest {

	@Test
	public void constructorInitSize() {

		Heap<Integer> heap = new Heap<>();

		int size = heap.size();
		boolean empty = heap.empty();
		Assert.assertTrue(empty);
		Assert.assertEquals(0, size);
	}

	@Test
	public void heapifyWithNull() {

		Heap<Integer> heap = new Heap<>();

		heap._heapify(null);

		int size = heap.size();
		boolean empty = heap.empty();
		Assert.assertTrue(empty);
		Assert.assertEquals(0, size);
	}

	@Test
	public void clearResetsHeap() {
		Heap<Integer> heap = new Heap<>();
		ArrayList<Integer> data = new ArrayList<>();

		data.add(2);
		data.add(4);
		data.add(-31);
		data.add(8);
		data.add(-23);
		data.add(13);

		heap.clear();

		Integer top = heap.top();
		Assert.assertNull(top);

		int size = heap.size();
		Assert.assertEquals(0, size);

		boolean empty = heap.empty();
		Assert.assertTrue(empty);
	}

	@Test
	public void topIsMin() {
		Heap<Integer> heap = new Heap<>();
		ArrayList<Integer> data = new ArrayList<>();

		data.add(2);
		data.add(4);
		data.add(-31);
		data.add(8);
		data.add(-23);
		data.add(13);

		heap._heapify(data);

		int top = heap.removeTop();

		Assert.assertEquals(-31, top);

		int size = heap.size();
		Assert.assertEquals(5, size);
	}

	@Test
	public void addInsertsWithPriority() {
		Heap<Integer> heap = new Heap<>();

		heap.add(2);
		heap.add(4);
		heap.add(-31);
		heap.add(8);
		heap.add(-23);
		heap.add(13);

		Integer min = Integer.MIN_VALUE;
		while (!heap.empty()) {
			Assert.assertTrue(min < heap.top());
			min = heap.removeTop();
		}
	}

	@Test
	public void heapifyInsertsWithPriority() {
		Heap<Integer> heap = new Heap<>();
		ArrayList<Integer> data = new ArrayList<>();

		data.add(2);
		data.add(4);
		data.add(-31);
		data.add(8);
		data.add(-23);
		data.add(13);

		heap._heapify(data);

		Integer min = Integer.MIN_VALUE;
		while (!heap.empty()) {
			Assert.assertTrue(min < heap.top());
			min = heap.removeTop();
		}

		int size = heap.size();
		Assert.assertEquals(0, size);
	}

}
