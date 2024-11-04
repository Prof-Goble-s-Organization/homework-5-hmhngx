package hw5;

/**
 * An implementation of the COMP232List interface backed with an array of 
 * Objects
 * 
 * @author William Goble
 * @author Dickinson College
 */
public class COMP232ArrayList<E> implements COMP232List<E> {
	private static final int INITIAL_CAPACITY = 10;
	private E[] listElements;
	private int currentSize;

	public COMP232ArrayList() {
		/*
		 * Note: Java does not support the creation of arrays of generic types.
		 * Instead we will create an array of type Object and cast it to the 
		 * appropriate type.
		 */
		listElements = (E[]) new Object[INITIAL_CAPACITY];
		currentSize = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * {@inheritDoc}
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= currentSize) {
			throw new IndexOutOfBoundsException("accessed " + index + " but size is " + currentSize);
		} else {
			return listElements[index];
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void set(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= currentSize) {
			throw new IndexOutOfBoundsException("tried to set " + index + " but size is " + currentSize);
		} else {
			listElements[index] = element;
		}
	}

	/**
	 * Append the specified Object to the end of the list. The size of the list 
	 * is increaed by 1. If the list is full, then a new array with twice the 
	 * capacity will be created. All the elements will be copied into the new 
	 * array and then the new element will be added to the end.
	 * 
	 * @param element
	 *      The Object to append to the list.
	 */
	public void add(E element) {
		// if the array is full, then double its size
		if (currentSize == listElements.length) {
			doubleCapacity();
		}

		listElements[currentSize] = element;
		currentSize++;
	}

	/**
	 * Doubles the size of the array that is holding the list elements and 
	 * copies the current list into the new array
	 */
	public void doubleCapacity() {
		E[] temp = (E[]) new Object[listElements.length * 2];
		System.arraycopy(listElements, 0, temp, 0, listElements.length);
		listElements = temp;
	}

	public void insert(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > currentSize) {
			throw new IndexOutOfBoundsException("accessed " + index
					+ " but size is " + currentSize);
		} else {
			// If the array is full, first double its size
			if (currentSize == listElements.length) {
				doubleCapacity();
			}

			// shift each of the elements at index or higher up by one 
			// location to make room for the new element to be inserted.
			for (int i = currentSize; i > index; i--) {
				listElements[i] = listElements[i - 1];
			}

			// insert the new element
			listElements[index] = element;
			currentSize++;
		}
	}

	/**
	 * Hald the size of the array that is holding the list elements and copy 
	 * the current list into the new array
	 */
	private void halfCapacity() {
		E[] temp = (E[]) new Object[listElements.length / 2];
		System.arraycopy(listElements, 0, temp, 0, currentSize);
		listElements = temp;
	}

	/**
	 * {@inheritDoc}
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= currentSize) {
			throw new IndexOutOfBoundsException("accessed " + index + " but size is " + currentSize);
		} else {
			// if the array is less that 1/3 full, half its size
			if (listElements.length > INITIAL_CAPACITY && currentSize < listElements.length / 3) {
				halfCapacity();
			}

			E element = listElements[index];

			/*
			 * Shift each of the elements at index or higher down by one location 
			 * to fill in the hold left by the removal of the element at index
			 */
			for (int i = index; i < currentSize; i++) {
				listElements[i] = listElements[i + 1];
			}

			listElements[currentSize - 1] = null;
			currentSize--;
			return element;
		}
	}
}