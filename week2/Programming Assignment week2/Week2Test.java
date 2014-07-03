import java.util.Iterator;

import org.junit.Test;

public class Week2Test {
    @Test
    public void dequeTest() {
        Deque<String> q = new Deque<String>();
        /*
         * while (!StdIn.isEmpty()) { String item = StdIn.readString();
         * if("-1".equals(item)) break; if (item.equals("0"))
         * StdOut.println(q.removeFirst()); else if(item.equals("$"))
         * StdOut.println(q.removeLast()); else q.addFirst(item); } Iterator it
         * = q.iterator(); while(it.hasNext()){ StdOut.print(it.next());
         * if(it.hasNext()) StdOut.print(" : "); } StdOut.println();
         * StdOut.println("(" + q.size() + " left on queue)");
         */
        // test Exceptions
        // String str = "Bingo~";
        // q.addLast(str);
        Iterator<String> it = q.iterator();
        // it.remove();
        StdOut.println(it.next());
        // StdOut.println(it.next());
        StdOut.println(q.removeLast());
        // StdOut.println(q.removeLast());
    }

    @Test
    public void randomTest() {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if ("-1".equals(item))
                break;
            rq.enqueue(item);
        }
        /*
         * while (!rq.isEmpty()) { StdOut.println(rq.dequeue()); }
         */
        // /*
        while (!StdIn.readString().equals("-1")) {
            Iterator<String> it = rq.iterator();
            while (it.hasNext()) {
                StdOut.print(it.next());
                if (it.hasNext())
                    StdOut.print(" : ");
            }
            StdOut.println();
        }
        // */
        StdOut.println("(" + rq.size() + " left on queue)");
    }
}
