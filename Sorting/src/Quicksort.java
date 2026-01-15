import java.util.Arrays;

// Algorithm: Quicksort
// Runtime: O(n^2) - if input is sorted, but if array randomised - best runtime is O(n log n)

public class Quicksort {

    public static void main(String[] args) {

        int[] toSort = new int[]{1, 4, 2, 4, 6, 7, 1};
        quickSort(toSort);

        System.out.println(Arrays.toString(toSort));

    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right)
    {
        if (left < right) {
            int p = partition(a, left, right);
            quickSort(a, left, p - 1);
            quickSort(a, p + 1, right);
        }
    }

    // Partition using last element as pivot
    private static int partition(int[] a, int left, int right)
    {
        int pivot = a[right];         // choose pivot
        int i = left;                 // left pointer
        int j = right - 1;            // right pointer

        while (true) {
            while (i < right && a[i] <= pivot) {
                i = i + 1;
                // move i right until value > pivot
            }
            while (j > left && a[j] > pivot) {
                j = j - 1;
                // move j left until value <= pivot
            }
            if (i >= j) break;
            // stop if pointers crossed

            // swap elements at i and j
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // place pivot between the two parts
        int temp = a[i];
        a[i] = a[right];
        a[right] = temp;

        return i;  // pivot’s final index
    }
}
