/**
 * name: ZhangHui date: Jun 20, 2014 purpose: To model a percolation system.
 * Execution: java Percolation.java
 * 
 */
public class Percolation {
    private int N;
    private int t, b;
    private int[][] grid;
    private WeightedQuickUnionUF wp;
    private WeightedQuickUnionUF wf;

    /**
     * a constructor to initialize an Percolation instance.
     * 
     * @param N
     *            the size of each row
     */
    public Percolation(int N) {
        if (N < 1)
            throw new IllegalArgumentException();
        this.N = N;
        grid = new int[N + 1][N + 1];
        t = 0;
        b = N * N + 1;

        wp = new WeightedQuickUnionUF(N * N + 2);
        wf = new WeightedQuickUnionUF(N * N + 1);
        for (int i = 1; i <= N; i++) {
            wp.union(t, xyTo1D(1, i));
            wp.union(b, xyTo1D(N, i));
            wf.union(t, xyTo1D(1, i));
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                grid[i][j] = 0;
            }
        }
    }

    /**
     * Are the indices legal?
     * 
     * @param i
     * @param j
     * @return
     */
    public void validate(int i, int j) {
        if (i < 1 || i > N || j < 1 || j > N) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * To map 2D coordinates to 1D coordinates.
     * 
     * @param i
     * @param j
     * @return the index of this site in the WeightedQuickUnion array.
     */
    public int xyTo1D(int i, int j) {
        return (i - 1) * N + j;
    }

    /**
     * To open a site.
     * 
     * @param i
     *            the index of row
     * @param j
     *            the index of column
     */
    public void open(int i, int j) {
        validate(i, j);
        if (grid[i][j] != 0)
            return;
        grid[i][j] = 1;
        if (i > 1 && isOpen(i - 1, j)) {
            wp.union(xyTo1D(i, j), xyTo1D(i - 1, j));
            wf.union(xyTo1D(i, j), xyTo1D(i - 1, j));
        }
        if (i < N && isOpen(i + 1, j)) {
            wp.union(xyTo1D(i, j), xyTo1D(i + 1, j));
            wf.union(xyTo1D(i, j), xyTo1D(i + 1, j));
        }
        if (j > 1 && isOpen(i, j - 1)) {
            wp.union(xyTo1D(i, j), xyTo1D(i, j - 1));
            wf.union(xyTo1D(i, j), xyTo1D(i, j - 1));
        }
        if (j < N && isOpen(i, j + 1)) {
            wp.union(xyTo1D(i, j), xyTo1D(i, j + 1));
            wf.union(xyTo1D(i, j), xyTo1D(i, j + 1));
        }
    }

    /**
     * Is the site [i][j] open?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isOpen(int i, int j) {
        validate(i, j);
        return grid[i][j] != 0;
    }

    /**
     * Is the site full?
     * 
     * @param i
     * @param j
     * @return
     */
    public boolean isFull(int i, int j) {
        validate(i, j);
        return isOpen(i, j) && wf.connected(t, xyTo1D(i, j));
    }

    /**
     * Has the system percolated?
     * 
     * @return
     */
    public boolean percolates() {
        if (N == 1)
            return grid[1][1] != 0;
        return wp.connected(t, b);
    }
}