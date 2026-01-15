import java.util.Arrays;

// Algorithm: Merge Sort
// Runtime: O(n log n)
// Memory: O(n)

public class MergeSort {

    public static void main(String[] args) {

        int[] toSort = new int[]{1, 4, 2, 4, 6, 7, 1};
        mergeSort(toSort);

        System.out.println(Arrays.toString(toSort));

    }

    // Public method – user calls this one
    public static void mergeSort(int[] A) {
        sort(A, 0, A.length - 1);
    }

    public static void sort(int[] A, int l, int r) {

        if (l < r) {

            int mid = (l + r) / 2;

            sort(A, l, mid);
            sort(A, mid + 1, r);

            merge(A, l, mid, r);
        }

    }

    public static void merge(int[] A, int l, int mid, int r) {

        int nL = mid - l + 1;
        int nR = r - mid;

        int[] leftA  = new int[nL];
        int[] rightA = new int[nR];

        for (int i = 0; i < nL; ++i){
            leftA[i] = A[l + i];
        }
        for (int j = 0; j < nR; ++j){
            rightA[j] = A[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < nL && j < nR){
            if(leftA[i] <= rightA[j]){
                A[k] = leftA[i];
                i++;
            } else {
                A[k] = rightA[j];
                j++;
            }
            k++;
        }

        while (i < nL){
            A[k] = leftA[i];
            i++;
            k++;
        }

        while (j < nR){
            A[k] = rightA[j];
            j++;
            k++;
        }

    }

}
