/**
 * name: ZhangHui date: Jun 20, 2014 purpose: To estimate a threshold of the
 * percolation system. Execution: java PercolationStas.java
 * 
 */

public class PercolationStats {
    private int n, t;
    private double[] m;
    private double means;
    private double stddevs;

    /**
     * Perform T independent computational experiments on an N-by-N grid.
     * 
     * @param N
     *            the size of each row.
     * @param T
     *            the times of experiments.
     */
    public PercolationStats(int N, int T) {
        if ((N <= 0) || (T <= 0))
            throw new IllegalArgumentException("Wrong Argument ! ");
        this.n = N;
        this.t = T;
        m = new double[t];
        for (int k = 0; k < t; k++) {
            int count = 0;
            Percolation p = new Percolation(n);
            int i = 0, j = 0;
            while (!p.percolates()) {
                i = StdRandom.uniform(n) + 1;
                j = StdRandom.uniform(n) + 1;
                if (!p.isOpen(i, j)) {
                    count++;
                    p.open(i, j);
                }
            }
            m[k] = count / (double) (n * n);
        }
        means = StdStats.mean(m);
        stddevs = StdStats.stddev(m);
    }

    /**
     * sample mean of percolation threshold
     * 
     * @return
     */
    public double mean() {
        return means;
    }

    /**
     * sample standard deviation of percolation threshold
     * 
     * @return
     */
    public double stddev() {
        return stddevs;
    }

    /**
     * returns lower bound of the 95% confidence interval
     * 
     * @return
     */
    public double confidenceLo() {
        return means - 1.96 * stddevs / Math.sqrt(t);
    }

    /**
     * returns upper bound of the 95% confidence interval
     * 
     * @return
     */
    public double confidenceHi() {
        return means + 1.96 * stddevs / Math.sqrt(t);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(N, T);
        StdOut.println("mean                          "
                + "         = " + ps.mean());
        StdOut.println("stddev                        "
                + "        = " + ps.stddev());
        StdOut.println("95% confidence interval = " + ps.confidenceLo() + ","
                + ps.confidenceHi());
    }
}
