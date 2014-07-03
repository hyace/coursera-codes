/**
 * name: ZhangHui date: July 3, 2014 
 * purpose: Write a client program takes a
 * command-line integer k; reads in a sequence of N strings from standard input
 * using StdIn. readString(); and prints out exactly k of them, uniformly at
 * random. Execution: Needs unit tests.
 */
public class Subset {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}
