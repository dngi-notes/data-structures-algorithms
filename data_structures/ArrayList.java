package data_structures;
/**
 * personal implementation of a dynamic array (ArrayList)
 * includes functions (add, get, set, remove, size, isEmpty, clear, add(index), remove(value))
 * 
 * generics
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
     * add an element to the ArrayList (dynamic array)
     */
    public void add(T obj) {
        if (size == elements.length) {
            
        }
    }
}
