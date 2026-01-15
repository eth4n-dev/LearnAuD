import java.util.Arrays;

// Algorithm: Binary Search
// Runtime: O(log n)
// use:
// - find an index of a value in a sorted (ascendingly) array

public class BinarySearch {

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 6, 10, 50, 63, 79, 80, 95};
        int x = 6;

        System.out.println("Index of x is: " + binarySearch(A, x));
    }

    public static int binarySearch(int[] A, int x){

        int low = 0;
        int high = A.length-1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            if (x == A[mid])
                return mid;

            if (x < A[mid]){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
