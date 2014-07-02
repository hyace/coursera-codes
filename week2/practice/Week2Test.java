import org.junit.Before;
import org.junit.Test;

public class Week2Test {
    Integer[] a;

    @Test
    public void geneTest() throws Exception {
        Generator.init(1000000);
    }

    @Before
    public void initTest() {
        In in = new In("data.txt");
        int[] data = in.readAllInts();
        a = new Integer[data.length];
        for (int i = 0; i < data.length; i++) {
            a[i] = data[i];
        }

    }

    @Test
    public void test() {
        // Selection.sort(a);
        // Insertion.sort(a);
        Shell.sort(a);
        /*
         * for (int i : a) { StdOut.print(i + " "); }
         */
    }

    @Test
    public void shuffleTest() {
//        a = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
//                15 };
        Shuffle.shuffle(a);
//        for (Integer i : a) {
//            StdOut.print(i + " ");
//        }
    }
}
