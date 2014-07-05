/**
 * Bottom up Merge sort
 * 
 * @author Chyace
 * 
 */
public class MergeBU {
    private static void merge(Comparable[] arr, Comparable[] aux, int l, int m,
            int h) {
        for (int k = l; k <= h; k++)
            aux[k] = arr[k];
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            if (i > m)
                arr[k] = aux[j++];
            else if (j > h)
                arr[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        Comparable[] aux = new Comparable[N];
        for (int st = 1; st < N; st += st) {
            for (int i = 0; i < N - st; i += st + st) {
                merge(arr, aux, i, i + st - 1, Math.min(i + st + st - 1, N - 1));
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
