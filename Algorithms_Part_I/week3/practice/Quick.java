/**
 * Quick Sort 测试中如果数据集是顺序的，即使不大也会造成栈溢出，添加shuffle后测试 初始版本有问题，排序是错的，
 * 修改了sort中的几个下标后好了，QuickSort各有各的实现方式，所以自己设置边界时要小心。
 * 
 * @author Chyace
 * 
 */
public class Quick {
    public static void sort(Comparable[] a) {
        // shuffle之後不會再stackoverflow
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int i = lo, j = hi + 1;
        while (true) {
            while (++i < hi && less(a[i], a[lo]));
            while (--j > lo && less(a[lo], a[j]));
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
