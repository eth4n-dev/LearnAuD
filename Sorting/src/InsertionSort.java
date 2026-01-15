import java.util.Arrays;

// Algorithm: Insertion Sort
// Runtime: O(n^2)

public class InsertionSort {

    public static void main(String[] args) {
        int[] input = {0, 4, 1, 2, 30, 14};
        insertionSort(input);

        System.out.println(Arrays.toString(input));
    }

    public static void insertionSort(int[] a)
    {
        int n = a.length;

        for (int j = 1; j < n; j++) {
            int x = a[j]; // element to insert
            // (element to insert saved in a variable because
            // it will be replaced soon due to the
            // shift in the following for loop)

            // Find insertion position in sorted part a[0..j-1]
            int k = lowerBound(a, 0, j, x);

            // Shift elements one step to the right
            for (int i = j; i > k; i--) {
                a[i] = a[i - 1];
            }

            // Insert the element
            a[k] = x;
        }
    }

    // Binary search: find first index in [lo, hi)
    // where a[idx] >= key
    // using lower bound
    private static int lowerBound(int[] a, int lo, int hi, int key) {
        while (lo < hi) {
            // more efficient alternative with a bitshift for (/ 2)
            // (lo + hi) >>> 1
            int mid = (lo + hi) / 2;
            if (a[mid] < key) {
                lo = mid + 1;  // go right
            } else {
                hi = mid;      // go left
            }
        }
        return lo;
    }
}
