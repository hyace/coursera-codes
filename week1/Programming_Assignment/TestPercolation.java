//import org.junit.Test;

public class TestPercolation {

//    @Test                //用junit测试最后hold不住会关闭，main测试才能留下。。。
//    public void testPercolation() {
    public static void main(String[] args){
        /*
         * Percolation p = new Percolation(1);
         * System.out.println(p.percolates()); System.out.println(p.isFull(1,
         * 1)); p.open(1, 1); System.out.println(p.percolates());
         */
        /*
        In in = new In("input20.txt"); // input file
        int N = in.readInt(); // N-by-N percolation system

        // turn on animation mode
        StdDraw.show(0);

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        PercolationVisualizer.draw(perc, N);
        StdDraw.show(10);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            PercolationVisualizer.draw(perc, N);
            StdDraw.show(10);
        }
        */
        int N=100;
        StdDraw.show(0);
        Percolation p = new Percolation(N);
        PercolationVisualizer.draw(p, N);
        StdDraw.show(1);
        while(!p.percolates()){
            int i = StdRandom.uniform(N)+1;
            int j = StdRandom.uniform(N)+1;
            p.open(i, j);
            PercolationVisualizer.draw(p, N);
            StdDraw.show(1);
        }
    }
}
