import javax.swing.text.DefaultEditorKit.CutAction;

/**
 * practical implements of merge sort.
 * 
 * @author Chyace
 * 
 */
public class MergePractical {
    private static final int CUTOFF = 7;

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++)
            aux[i] = arr[i];
        sort(aux, arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int l, int h) {
        //添加长度判定，小于定长时用Insertion sort来排序，减小递归开销
        if (l + CUTOFF > h) {
            Insertion.sort(aux, l, h);
            return;
        }
        int m = (l + h) / 2;
        //调换arr，aux 的顺序，不用每次给aux赋值，而是两数组来回切换，可以save time
        sort(aux, arr, l, m);
        sort(aux, arr, m + 1, h);
        //添加判定，如果两数组已排序，直接返回
        if (less(aux[m], aux[m + 1]))
            return;
        merge(arr, aux, l, m, h);
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int l, int m,
            int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            if (i > m)
                aux[k] = arr[j++];
            else if (j > h)
                aux[k] = arr[i++];
            else if (less(arr[i], arr[j]))
                aux[k] = arr[i++];
            else
                aux[k] = arr[j++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
