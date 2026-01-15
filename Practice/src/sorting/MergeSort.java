package sorting;

public class MergeSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        // TODO: Implement recursive divide steps
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // TODO: Implement merge logic (Create temp arrays, copy data, merge back)
    }
}