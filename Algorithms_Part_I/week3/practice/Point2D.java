import java.util.Comparator;

// 添加比较器
public class Point2D {
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.y - a.y);
        if (area2 > 0)
            return 1;
        if (area2 < 0)
            return -1;
        return 0;
    }

    private class PolarOrder implements Comparator<Point2D> {

        public int compare(Point2D q1, Point2D q2) {
            double dy1 = q1.y - y;
            double dy2 = q2.y - y;
            if (dy1 >= 0 && dy2 < 0)
                return -1;
            if (dy2 >= 0 && dy1 < 0)
                return 1;
            else
                return -ccw(Point2D.this, q1, q2);
        }

    }
}
