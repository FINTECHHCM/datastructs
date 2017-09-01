package datastructs;

import datastructs.JavaStack;

import org.junit.Test;
import org.junit.Assert;

import javax.naming.OperationNotSupportedException;

public class JavaStackTest {

	@Test
	public void constructorInitSize() {
		JavaStack<Integer> stack = new JavaStack<>();

		int size = stack.size();

		Assert.assertEquals(0, size);
	}

	@Test(expected = OperationNotSupportedException.class)
	public void constructorPeekEmptyThrowsException() throws OperationNotSupportedException {
		JavaStack<Integer> stack = new JavaStack<>();

		stack.peek();
	}

	@Test(expected = OperationNotSupportedException.class)
	public void constructorPopEmptyThrowsException() throws OperationNotSupportedException {
		JavaStack<Integer> stack = new JavaStack<>();

		stack.pop();
	}

	@Test
	public void peek() {
		JavaStack<Integer> stack = new JavaStack<>();

		stack.push(3);
		stack.push(4);
		stack.push(6);

		try {
			int val = stack.peek();
			Assert.assertEquals(6, val);
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void popRemovesElement() {
		JavaStack<Integer> stack = new JavaStack<>();

		stack.push(3);
		stack.push(4);
		stack.push(6);

		try {
			int val = stack.pop();
			int size = stack.size();
			boolean empty = stack.empty();

			Assert.assertEquals(6, val);
			Assert.assertEquals(2, size);
			Assert.assertFalse(empty);

		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void stackEmptyAfterPoppingAll() {
		JavaStack<Integer> stack = new JavaStack<>();

		stack.push(3);
		stack.push(4);
		stack.push(6);

		try {
			while (!stack.empty()) {
				stack.pop();
			}
			int size = stack.size();
			boolean empty = stack.empty();

			Assert.assertTrue(empty);
			Assert.assertEquals(0, size);

		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void resize() {
		JavaStack<Integer> stack = new JavaStack<>();

		int max = 20;
		for (int i = 0; i < max; i++) {
			stack.push(i);
		}

		try {
			int j = 0;
			while (!stack.empty()) {
				int val = stack.pop();
				Assert.assertEquals(max - 1 - j, val);
				j++;
			}
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
