/**
 * name: ZhangHui date: July 2, 2014
 * purpose: To model a queue supports inserting and removing 
 * items from either the front or the back of the data structure. 
 * Execution: Needs unit tests.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Item[] arr;
    private int N = 0;
    private int first = 0; // index of first element of queue
    private int last = 0; // index of last element of queue

    // construct an empty deque
    public Deque() {
        arr = (Item[]) new Object[2];
    }

    // resizing a deque
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[(first + i) % arr.length];
        }
        arr = copy;
        first = 0;
        last = N;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the deque
    public int size() {
        return N;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (N == arr.length)
            resize(2 * arr.length);
        if (--first < 0)
            first = arr.length - 1;
        arr[first] = item;
        N++;
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();
        if (N == arr.length)
            resize(2 * arr.length);
        arr[last++] = item;
        if (last == arr.length)
            last = 0;
        N++;
    }

    // delete and return the item at the front
    public Item removeFirst() {
        if (N == 0)
            throw new NoSuchElementException("Queue underflow");
        Item item = arr[first];
        arr[first] = null;
        N--;
        if (++first == arr.length)
            first = 0;
        if (N > 0 && N == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    // delete and return the item at the end
    public Item removeLast() {
        if (N == 0)
            throw new NoSuchElementException("Queue underflow");
        if (last-- < 0)
            last = arr.length;
        Item item = arr[last];
        arr[last] = null;
        N--;
        if (N > 0 && N == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new IteratorDeque();

    }

    // implement Iterator
    private class IteratorDeque implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < N;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return arr[(first + i++) % arr.length];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
