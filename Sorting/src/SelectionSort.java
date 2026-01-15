import java.util.Arrays;

// Algorithm: Selection Sort
// Runtime: Θ(n^2) comparisons, O(n) swaps

public class SelectionSort {

    public static void main(String[] args) {

        int[] toSort = new int[]{1, 4, 2, 4, 6, 7, 1};
        selectionSort(toSort);

        System.out.println(Arrays.toString(toSort));

    }

    public static void selectionSort(int[] a) {
        for (int j = a.length - 1; j >= 0; j--) {
            int maxIdx = 0;
            for (int i = 1; i <= j; i++) {
                if (a[i] > a[maxIdx])
                    maxIdx = i; // find index of max value
            }
            int t = a[maxIdx];
            a[maxIdx] = a[j];
            a[j] = t;
        }
    }
}
