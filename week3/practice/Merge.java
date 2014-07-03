/**
 * Merge Sort
 * 
 * @author Chyace
 * 
 */
public class Merge {
    private static void merge(Comparable[] arr, Comparable[] aux, int l, int m,
            int h) {
        for (int i = l; i <= h; i++) {
            aux[i] = arr[i];
        }
        int p = l, q = m + 1;
        for (int i = l; i <= h; i++) {
            if (p > m)
                arr[i] = aux[q++];
            else if (q > h)
                arr[i] = aux[p++];
            else if (less(aux[p], aux[q]))
                arr[i] = aux[p++];
            else
                arr[i] = aux[q++];
        }
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int l, int h) {
        if (h <= l)
            return;
        int m = (l + h) / 2;
        sort(arr, aux, l, m);
        sort(arr, aux, m + 1, h);
        merge(arr, aux, l, m, h);
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
