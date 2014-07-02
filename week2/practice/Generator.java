import java.io.BufferedWriter;
import java.io.FileWriter;

public class Generator {

    public static void init(int n) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        for(int i=0;i<n;i++){
            if(i==n-1)
                bw.write(StdRandom.uniform(n)+"");
            else
                bw.write(StdRandom.uniform(n)+" ");
        }
        bw.close();
    }

}
