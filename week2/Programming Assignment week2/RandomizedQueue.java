/**
 * name: ZhangHui date: July 2, 2014
 * purpose: To model a data structure that the 
 * item removed is chosen uniformly at random. 
 * Execution: Needs unit tests.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private Node head;

    private class Node {
        private Item item;
        private Node next;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        head = null;
        N = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException();
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;
        head = newNode;
        N++;
    }

    // delete and return a random item
    public Item dequeue() {
        if (N == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(N);
        Node p = head;
        Node pre = head;
        if (i == 0) {
            head = p.next;
        }
        while (i > 0) {
            pre = p;
            p = p.next;
            i--;
        }
        Item item = p.item;
        pre.next = p.next;
        p = null;
        N--;
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (N == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(N);
        Node p = head;
        while (i > 0) {
            p = p.next;
            i--;
        }
        Item item = p.item;
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    // implement Iterator
    private class RandomizedIterator implements Iterator<Item> {
        private Item[] arr;
        private int t = 0;

        public RandomizedIterator() {
            arr = (Item[]) new Object[N];
            Node p = head;
            for (int i = 0; i < N; i++) {
                arr[i] = p.item;
                p = p.next;
            }
            StdRandom.shuffle(arr);
        }

        public boolean hasNext() {
            return t < N;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return arr[t++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
