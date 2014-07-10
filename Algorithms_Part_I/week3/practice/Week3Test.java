import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class Week3Test {
    Integer[] a;

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
    public void geneTest() throws Exception {
        Generator.init(1000000, false);
    }

    @Test
    public void sortTest() throws Exception {
        // a = new Integer[] { 9, 2, 7, 6, 5, 4, 3, 8, 1 };
        // BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
        // Merge.sort(a);
        // MergePractical.sort(a);
        // MergeBU.sort(a);
        // Insertion.sort(a);
        Quick.sort(a);
        // for (int i = 0; i < a.length; i++) {
        // bw.write(a[i] + " ");
        // }
        // bw.close();
        // for (int i = 0; i < a.length; i++) {
        // StdOut.print(a[i] + " ");
        // }
    }

}
