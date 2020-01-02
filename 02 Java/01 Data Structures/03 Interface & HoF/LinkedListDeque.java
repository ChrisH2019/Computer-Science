/**
 *  LinkedListDeque
 *  Skeleton provided by Prof. Josh Hug
 *  12/31/2019
 *  @author Christopher Hong
 */
public class LinkedListDeque<T> implements Deque<T> {

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
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** Adds an item of type T to the end of the deque. */
    public void addLast(T item)
    {
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
}
