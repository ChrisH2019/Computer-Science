import java.util.Iterator;

/**
 *  LinkedListDeque
 *  Skeleton provided by Prof. Josh Hug
 *  12/31/2019
 *  @author Christopher Hong
 */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    /** Private help class Node. */
    public class Node {
        T item;
        Node prev;
        Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Create an empty linkedlistDeque. */
    public LinkedListDeque() {
        sentinel = new Node(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Create a deep copy of other. */
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new Node(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++) {
            addLast(other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item)
    {
        checkNull(item);
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the end of the deque. */
    public void addLast(T item)
    {
        checkNull(item);
        Node node = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque()
    {
        Node p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /** Removes the first item in the deque.
     *  Returns null if the deque is empty.
     */
    public T removeFirst()
    {
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return first;
    }

    /**
     *  Removes the last item of the deque.
     *  Returns null if the deque is empty.
     */
    public T removeLast()
    {
        if (size == 0) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    /**
     *  Returns the ith item in the deque using iterative.
     *  Returns null if the deque is empty.
     */
    public T get(int index)
    {
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    /**
     *  Returns the ith item in the deque using recursion.
     *  Returns null if the deque is empty.
     */
    public T getRecursive(int index)
    {
        return traverse(sentinel.next, index);
    }

    /** getRecursive helper function. */
    public T traverse(Node n, int i)
    {
        if (i == 0) {
            return n.item;
        } else {
            return traverse(n.next, i-1);
        }
    }

    /**  Returns the number of items in the deque. */
    public int size()
    {
        return size;
    }

    //** Implement the inhanced for loop operation. */
    private class LinkedListDequeIterator implements Iterator<T> {
        private Node p;

        public LinkedListDequeIterator() {
            p = sentinel.next;
        }

        public boolean hasNext() {
            return p != sentinel;
        }

        public T next() {
            T returnItem = p.item;
            p = p.next;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node ptr = sentinel.next;
        while (ptr.next != sentinel) {
            sb.append(ptr.item);
            sb.append(", ");
            ptr = ptr.next;
        }
        sb.append(ptr.item);
        sb.append(("}"));
        return sb.toString();
    }

    public boolean contains(T x) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.item.equals(x)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this == o ) { return true; }
        if (this.getClass() != o.getClass()) { return false; }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (this.size() != other.size()) { return false; }
        for (T item : this) {
            if (!other.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
