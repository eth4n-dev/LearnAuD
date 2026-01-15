import java.util.Arrays;

//Algorithm: Bubble Sort
//Runtime: Θ(n^2) comparisons, O(n^2) swaps in the worst case of fully reversed input

public class BubbleSort {

    public static void main(String[] args) {

        int[] toSort = new int[]{1, 4, 2, 4, 6, 7, 1};
        bubbleSort(toSort);

        System.out.println(Arrays.toString(toSort));

    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int pass = 0; pass < n; pass++) {
            for (int i = 0; i + 1 < n; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                }
            }
        }
    }

}
