import java.util.Iterator;
import java.util.NoSuchElementException;
/* Doubly-linked list class (UNFINISHED).
 * @author Doung Lan Cheung */
public class DoubleList<E> implements Iterable<E> {
	private Link<E> head; // Pointer to list header
	private Link<E> tail; // Pointer to last node
	private int listSize; // Size of list

	//Create an empty LList.
	DoubleList() {
		clear();
	}

	//Remove all elements.
	public void clear() {
		tail = new Link<E>(null, null); // Create trailer
		head = new Link<E>(null, tail); // Create header
		tail.setPrev(head);
		listSize = 0;
	}

	//Append item to the end of the list.
	public void append(E item) {
		Link<E> newLink = new Link<>(item, tail.prev(), tail);
		tail.prev().setNext(newLink); //setNext is referencing to the next node
		tail.setPrev(newLink); //setPrev is referencing to the prev node
		listSize++;
	}

	// Return the element at the provided index. This method will iterate from the
	//head or the tail depending on which will require fewer steps.
	public E get(int pos) {
		if (pos < 0 || pos >= listSize) {
			throw new IndexOutOfBoundsException();
		}
		if (pos < listSize / 2) {
			return forward(pos).element();
		} 
		else {
			return backward(pos).element();
		}
	}

	//Helper method for iterating forward from the head.
	private Link<E> forward(int pos) {
		Link<E> current = head.next();
		for (int i = 0; i < pos; i++) {
			current = current.next();
		}
		return current;
	}

	// Helper method for iterating backward from the tail.
	private Link<E> backward(int pos) {
		Link<E> current = tail.prev();
		for (int i = 0; i < (listSize - 1) - pos; i++) {
			current = current.prev();
		}
		return current;
	}

	//Return the number of elements stored in the list.
	public int size() {
		return listSize;
	}

	//Iterates forward through the list. Remove operation is supported.
	@Override
	public Iterator<E> iterator() {
		return new DoubleIterator();
	}

	private class DoubleIterator implements Iterator<E> {
		private Link<E> current = head;
		
		@Override
		public boolean hasNext() { //Returns true if the iteration has more elements.
			Link<E> nxt = current.next(); //sets nxt as the next index in list
			return (nxt.next() != null); //if the third item in the list is not empty, then return true
			}
		
		@Override
		public E next() { //Returns the next element in the iteration.
			current = current.next();
			E temp = current.element();
			return temp;
		}

		@Override
		public void remove() { //Removes from the underlying collection the last element returned by this iterator, leaves the last element
			Link<E> previous = current.prev();
			Link<E> next = current.next();
			previous.setNext(next);
			next.setPrev(previous);
			current = previous;
			listSize--;
		}
	}
	//end of iterator interface

	//Add the item at the specified index.
	public void add(int index, E item) { //use append, use get
		//COMPLETE THIS
		if (index < 0 || index >= listSize) {
			throw new IndexOutOfBoundsException();
		}

		Link<E> current = head.next();
		for(int i = 0; i < index; i++) {
			current = current.next();
		}

		Link<E> before = current.prev();
		Link<E> newLink = new Link<>(item, current.prev(), current);
		before.setNext(newLink);
		newLink.setPrev(before);
		current.setPrev(newLink);
		newLink.setNext(current);
	}

	//Remove and return the item at the specified index.
	public E remove(int index) { //use get
		//COMPLETE THIS
		int local = 0;
		Link<E> current = head;

		while(local != index -1) {
			current = head.next();
			local++;
		}

		Link<E> x = current.next();
		Link<E> newNext = current.next().next();
		current.setNext(newNext);
		return x.element();
	}

	// Reverse the list (in place)
	public void reverse() { //use backward
		//COMPLETE THIS
		int len = 0;
		Link<E> temp = head;
		do {
			temp = head.next();
			len++;
		}
		while(temp != null);

		temp = head.prev();
		Link<E> current = head;
		for(int i = 0; i < len; i++) {
			current.setNext(temp.prev());
		}
	}
}