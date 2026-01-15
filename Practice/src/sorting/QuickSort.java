package sorting;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        // TODO: Implement recursive logic
        // 1. Partition the array
        // 2. Recursively sort left and right partitions
    }

    private int partition(int[] arr, int low, int high) {
        // TODO: Pick a pivot, place it in right spot, return pivot index

        return -1;
    }
}