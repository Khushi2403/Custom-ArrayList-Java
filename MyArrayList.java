package collection;

import java.util.*;

class UserNoSuchElementException extends RuntimeException {
	public UserNoSuchElementException() {
		super();
	}
}

class UserIndexOutOfBoundsException extends RuntimeException {
	public UserIndexOutOfBoundsException(String desc) {
		super(desc);
	}
}

public class MyArrayList<E> implements Cloneable {
	private final int INITIAL_CAPACITY = 10;
	private E[] arr;
	private int indx;

	public MyArrayList() {
		arr = (E[]) new Object[INITIAL_CAPACITY];
	}

	@Override
	public String toString() {
		if (indx == 0)
			return "[]";

		String op = "[";
		for (int i = 0; i < indx - 1; i++) {
			op += arr[i] + ", ";

		}
		op += arr[indx - 1] + "]";
		return op;
	}

	private int newCapacity(int oldCap) {
		return (int) (oldCap * 1.5);
	}

	public boolean add(E ele) {
		if (indx == arr.length) {
			int newCap = newCapacity(arr.length);
			E[] newArr = (E[]) new Object[newCap];
			int i = 0;
			for (E ele1 : arr) {
				newArr[i++] = ele1;
			}
			arr = newArr;

		}
		arr[indx++] = ele;
		return true;
	}

	public int size() {
		return indx;
	}

	public boolean isEmpty() {
		return indx == 0;
	}

	public E getFirst() {
		if (size() == 0)
			throw new UserNoSuchElementException();
		return arr[0];
	}

	public E getLast() {
		if (size() == 0)
			throw new UserNoSuchElementException();
		return arr[indx - 1];
	}

	public int indexOf(Object obj) {
		for (int i = 0; i < size(); i++) {
			if (arr[i].equals((E) obj))
				return i;
		}
		return -1;

	}

	public int LastIndexOf(Object obj) {
		for (int i = size() - 1; i >= 0; i--) {
			if (arr[i].equals((E) obj))
				return i;
		}
		return -1;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	public E remove(int indx) {
		if (indx < 0 || indx >= size())
			throw new UserIndexOutOfBoundsException("Index " + indx + " out of bounds for length " + size());

		E temp = arr[indx];
		for (int i = indx + 1; i <= size() - 1; i++)
			arr[i - 1] = arr[i];

		arr[size() - 1] = null;
		this.indx--;
		return temp;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size() - 1);
	}

	public void add(int indx, E ele) {

		if (indx < 0 || indx > size())
			throw new UserIndexOutOfBoundsException("Index " + indx + " out of bounds for length " + size());

		// If array is full, resize
		if (arr.length == size()) {
			E[] newArr = (E[]) new Object[newCapacity(arr.length)];
			for (int i = 0; i < size(); i++)
				newArr[i] = arr[i];
			arr = newArr;
		}

		// Shift elements to right
		for (int i = size(); i > indx; i--)
			arr[i] = arr[i - 1];

		arr[indx] = ele;
		this.indx++;
	}

	public void addFirst(E ele) {
		add(0, ele);
	}

	public void addLast(E ele) {
		add(size() - 1, ele);
	}

	public E set(int indx, E ele) {
		if (indx < 0 || indx >= size())
			throw new UserIndexOutOfBoundsException("Index " + indx + " out of bounds for length " + size());
		E temp = arr[indx];
		arr[indx] = ele;
		return temp;
	}

	public void trimToSize() {
		if (arr.length == size())
			return;

		E[] newArr = (E[]) new Object[size()];
		for (int i = 0; i < size(); i++)
			newArr[i] = this.arr[i];
		arr = newArr;
	}

	public void ensureCapacity(int cap) {
		if (arr.length >= cap)
			return;

		E[] newArr = (E[]) new Object[cap];
		for (int i = 0; i < size(); i++)
			newArr[i] = this.arr[i];
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Object[] toArray() {
		Object[] newArr = new Object[size()];
		for (int i = 0; i < size(); i++)
			newArr[i] = this.arr[i];
		return newArr;
	}

	public E get(int indx) {
		if (indx < 0 || indx >= size())
			throw new UserIndexOutOfBoundsException("Index " + indx + " out of bounds for length " + size());
		return arr[indx];
	}

	public int hashCode() {
		int i = 0;
		int hashCode = 1;
		for (E ele : this.arr) {
			hashCode *= ele.hashCode();
			if (++i == size())
				break;
		}
		return hashCode;
	}

	public boolean equals(Object obj) {
		E ele = (E) obj;
		if (this.hashCode() == ele.hashCode())
			return true;
		return false;
	}

	public void clear() {
		E[] newArr = (E[]) new Object[this.arr.length];
		this.indx = 0;
		arr = newArr;
	}

}
