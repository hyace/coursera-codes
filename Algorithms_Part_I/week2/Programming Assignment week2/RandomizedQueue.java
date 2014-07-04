/**
 * name: ZhangHui date: July 2, 2014
 * purpose: To model a data structure that the 
 * item removed is chosen uniformly at random. 
 * Execution: Needs unit tests.
 */
//之前用Linked List实现的，但是在dequeue的时候会超时，所以用resizing queue重构了，随机存取是常数时间。
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private Item[] arr;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[2];
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
        if (N == arr.length)
            resize(2 * arr.length);
        arr[N++] = item;
    }

    private void resize(int n) {
        Item[] aux = (Item[]) new Object[n];
        for (int i = 0; i < N; i++)
            aux[i] = arr[i];
        arr = aux;
    }

    // delete and return a random item
    public Item dequeue() {
        if (N == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(N);
        Item item = arr[i];
        //这里随机删去一个元素，再用最后一个填补进来，从而兼顾随机存取和数组的连续。
        if (i < N - 1) {
            arr[i] = arr[N - 1];
        }
        arr[N - 1] = null;
        N--;
        if (N > 0 && N == arr.length / 4)
            resize(arr.length / 2);
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (N == 0)
            throw new NoSuchElementException();
        int i = StdRandom.uniform(N);
        Item item = arr[i];
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    // implement Iterator
    private class RandomizedIterator implements Iterator<Item> {
        private Item[] a;
        private int t = 0;

        public RandomizedIterator() {
            a = (Item[]) new Object[N];
            for (int i = 0; i < N; i++)
                a[i] = arr[i];
            StdRandom.shuffle(a);
        }

        public boolean hasNext() {
            return t < N;
        }

        public Item next() {
            if (!hasNext()) {
                a = null;
                throw new NoSuchElementException();
            }
            return a[t++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
