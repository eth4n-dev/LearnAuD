import java.util.Arrays;

// Algorithm: Heapsort
// Runtime: O (n log n)

public class Heapsort {

    public static void main(String[] args) {

        int[] toSort = new int[]{1, 4, 2, 4, 6, 7, 1};
        heapSort(toSort);

        System.out.println(Arrays.toString(toSort));

    }

    // Public method: sorts the entire array
    public static void heapSort(int[] a) {
        int n = a.length;

        // --- Phase 1: Build max-heap ---
        // corresponds to "Heapify" in the script
        for (int i = (n / 2) - 1; i >= 0; i = i - 1) {
            downHeap(a, i, n);
        }

        // --- Step 2: Repeatedly extract the maximum ---
        // "ExtractMax" in the script
        for (int end = n - 1; end > 0; end = end - 1) {

            // Move the largest element (root) to the end
            int temp = a[0];
            a[0] = a[end];
            a[end] = temp;

            // Restore heap property for the reduced heap
//            siftDown(a, 0, end);
        }
    }

    // Helper: maintain max-heap property by moving a[i] down the tree
    private static void downHeap(int[] a, int i, int n) {
        while (true) {
            int leftChild = (i * 2) + 1;
            int rightChild = leftChild + 1;
            int largest = i;

            // Compare with left child
            if (leftChild < n && a[leftChild] > a[largest]) {
                largest = leftChild;
            }

            // Compare with right child
            if (rightChild < n && a[rightChild] > a[largest]) {
                largest = rightChild;
            }

            // If parent is largest → heap is valid
            if (largest == i) {
                return;
            }

            // Otherwise, swap and continue down
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            i = largest; // move down to the swapped child
        }
    }
}
