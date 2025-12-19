package data_structures;

/**
 * personal implementation of a dynamic array (ArrayList)
 * includes functions (add, get, set, remove, size, isEmpty, clear, add(index),
 * remove(value))
 */
public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }

        this.size = 0;
        this.elements = new Object[capacity];
    }

    /**
     * add an element
     * @param obj
     */
    public void add(T obj) {
        if (size == elements.length) {
            increaseCapacity();
        }

        elements[size] = obj;
        size++;
    }
    
    /**
     * check if arraylist is empty
     * returns true if empty, else false
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the value stored at the specified index
     * if the index is invalid, it returns an exception
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkBoundary(index);

        return (T) (elements[index]);
    }

    /**
     * sets a value at an index as long as it valid
     * else returns an exception
     * @param index
     * @param value
     */
    public T set(int index, T value) {
        checkBoundary(index);

        T oldValue = get(index);
        elements[index] = value;
        return oldValue;
    }

    /**
     * size of arraylist
     */
    public int size() {
        return size;
    }

    /**
     * remove all elements
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * removes the element at the specified position in the list. shifts any subsequent elements (subtracts one from their indices)
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkBoundary(index);

        T removedEl = (T) (elements[index]);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;
        return removedEl;
    }

    public void add(int index, T value) {
        checkBoundaryAdd(index);        
        if (size == elements.length) {
            increaseCapacity();
        }

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        
        elements[index] = value;
        size++;
    }

    private void checkBoundary(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void checkBoundaryAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void increaseCapacity() {
        Object[] old = elements;
        elements = new Object[elements.length * 2];
        System.arraycopy(old, 0, elements, 0, size);
    }
}