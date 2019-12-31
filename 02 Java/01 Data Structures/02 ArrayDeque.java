/** Circular ArrayDeque
 *  12/31/2019
 *  @author Christopher Hong
 */
public class ArrayDeque<T> {

    private T[] array;                              // References to the array
    private int size;
    private int nextFirst;                          // Index of the first-to-be-added
    private int nextLast;                           // Index of the last-to-be-added
    private static final int INIT_CAPACITY = 8;
    private static final int RESIZE_RATIO = 2;
    private static final double MIN_USAGE_RATE = 0.25;

    public ArrayDeque() {
        array = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        array = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /** Add an item to the front of the array. */
    public void addFirst(T item) {
        if (size == array.length) {
            resize();
        }
        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Decrement the index of the first-to-be-added by one. */
    private int minusOne(int index) {
        if (index == 0) {
            return array.length - 1;
        }
        index = (index - 1) % array.length;
        return index;
    }

    /** Add an item to the end of the array. */
    public void addLast(T item) {
        if (size == array.length) {
            resize();
        }
        array[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Increment the index of the last-to-be-added by one. */
    private int plusOne(int index) {
        index = (index + 1) % array.length;
        return index;
    }

    /** Expand the array to a new array of double size of the old array if the old array is full.
     *  Shrink the array to a new array of half size of the old array if the usage factor is less than
     *  or equal to 0.25. If the size of the new array is less than 8, keep the old as-is.
     */
    private void resize() {
        T[] newarray;
        if (size == array.length) {
            newarray = (T[]) new Object[array.length * RESIZE_RATIO];
        } else {
            // Minimum size of the array is 8
            if (array.length / RESIZE_RATIO < 8) {
                return;
            }
            newarray = (T[]) new Object[array.length / RESIZE_RATIO];
        }
        int indexOfNewarray = size/2;
        int count = size;
        while (count > 0) {
            nextFirst = (nextFirst + 1) % array.length;
            newarray[indexOfNewarray] = array[nextFirst];
            indexOfNewarray += 1;
            count -= 1;
        }
        array = newarray;
        nextFirst = (size / 2 - 1) % array.length;
        nextLast = (size / 2 + size) % array.length;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (1.0 * size / array.length <= MIN_USAGE_RATE) {
            resize();
        }
        nextFirst = plusOne(nextFirst);
        T first = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        return first;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (1.0 * size / array.length <= MIN_USAGE_RATE) {
            resize();
        }
        nextLast = minusOne(nextLast);
        T last = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        return last;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int indexOfarray = nextFirst + 1;
        int count = size;
        while (size > 0) {
            System.out.print(array[indexOfarray] + " ");
            indexOfarray = (indexOfarray + 1) % array.length;
            size -= 1;
        }
        System.out.println();
    }

    public T get(int index) {
        return array[(nextFirst + 1 + index) % array.length];
    }
}
