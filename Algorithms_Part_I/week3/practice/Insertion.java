public class Insertion {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void sort(Comparable[] a, int l, int h) {
        int N = h - l + 1;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[l + j], a[l + j - 1]))
                    exch(a, l + j, l + j - 1);
                else
                    break;
            }
        }
    }
}
