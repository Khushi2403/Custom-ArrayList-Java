package collection;

import java.util.Arrays;

public class MyArrayListDriver {
	public static void main(String[] args) {

		MyArrayList<Integer> list = new MyArrayList<>();

		// ---------- toString() ----------
		System.out.println("Initial List: " + list);

		// ---------- add(E ele) ----------
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println("After add(): " + list);

		// ---------- size() ----------
		System.out.println("Size: " + list.size());

		// ---------- isEmpty() ----------
		System.out.println("Is Empty: " + list.isEmpty());

		// ---------- getFirst() ----------
		System.out.println("First Element: " + list.getFirst());

		// ---------- getLast() ----------
		System.out.println("Last Element: " + list.getLast());

		// ---------- indexOf() ----------
		System.out.println("Index of 30: " + list.indexOf(30));

		// ---------- LastIndexOf() ----------
		list.add(30);
		System.out.println("After adding duplicate 30: " + list);
		System.out.println("Last Index of 30: " + list.LastIndexOf(30));

		// ---------- contains() ----------
		System.out.println("Contains 40? " + list.contains(40));

		// ---------- remove(int indx) ----------
		list.remove(2);
		System.out.println("After remove(2): " + list);

		// ---------- removeFirst() ----------
		list.removeFirst();
		System.out.println("After removeFirst(): " + list);

		// ---------- removeLast() ----------
		list.removeLast();
		System.out.println("After removeLast(): " + list);

		// ---------- add(int indx, E ele) ----------
		list.add(1, 99);
		System.out.println("After add(1,99): " + list);

		// ---------- addFirst(E ele) ----------
		list.addFirst(5);
		System.out.println("After addFirst(5): " + list);

		// ---------- addLast(E ele) ----------
		list.addLast(100);
		System.out.println("After addLast(100): " + list);

		// ---------- set(int indx, E ele) ----------
		list.set(2, 77);
		System.out.println("After set(2,77): " + list);

		// ---------- trimToSize() ----------
		list.trimToSize();
		System.out.println("After trimToSize(): " + list);

		// ---------- ensureCapacity(int cap) ----------
		list.ensureCapacity(20);
		System.out.println("After ensureCapacity(20)");

		// ---------- clone() ----------
		try {
			MyArrayList<Integer> cloned = (MyArrayList<Integer>) list.clone();
			System.out.println("Cloned List: " + cloned);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// ---------- toArray() ----------
		Object[] arr = list.toArray();
		System.out.println("toArray(): " + Arrays.toString(arr));

		// ---------- get(int indx) ----------
		System.out.println("Element at index 1: " + list.get(1));

		// ---------- hashCode() ----------
		System.out.println("HashCode: " + list.hashCode());

		// ---------- equals() ----------
		MyArrayList<Integer> list2 = new MyArrayList<>();
		list2.add(5);
		list2.add(99);
		list2.add(77);
		list2.add(40);
		list2.add(30);
		list2.add(100);

		System.out.println("List equals list2? " + list.equals(list2));

		// ---------- clear() ----------
		list.clear();
		System.out.println("After clear(): " + list);
		System.out.println("Size after clear: " + list.size());
	}
}

