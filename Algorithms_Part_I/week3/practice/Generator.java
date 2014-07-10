import java.io.BufferedWriter;
import java.io.FileWriter;

public class Generator {

    public static void init(int n, boolean flag) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        for (int i = 0; i < n; i++) {
            int t = 0;
            if (flag)
                t = StdRandom.uniform(n);
            else
                t = i;
            if (i == n - 1)
                bw.write(t + "");
            else
                bw.write(t + " ");
        }
        bw.close();
    }

}
