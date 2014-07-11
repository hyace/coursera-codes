import java.util.Comparator;

/**
 * name: ZhangHui date: July 11, 2014 purpose: Create an immutable data type
 * Point that represents a point in the plane .
 */
public class Point implements Comparable<Point> {
    // compare points by slope to this point
    public final Comparator<Point> SLOPE_ORDER = new PointComp();
    private int x, y;

    // construct the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // draw this point
    public void draw() {
        StdDraw.point(x, y);
    }

    // draw the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // is this point lexicographically smaller
    public int compareTo(Point that) {
        return this.y > that.y ? 1 : this.y == that.y ? 0 : this.x - that.x;
    }

    // the slope between this point and that point
    public double slopeTo(Point that) {
        double dy = that.y - this.y;
        if (dy == 0)
            return 0;
        double dx = that.x = this.x;
        if (dy > 0 && dx == 0)
            return Double.POSITIVE_INFINITY;
        if (dy < 0 && dx == 0)
            return Double.NEGATIVE_INFINITY;
        return dy / dx;
    }

    private class PointComp implements Comparator<Point> {
        public int compare(Point p, Point q) {

            return 0;
        }
    }
}
