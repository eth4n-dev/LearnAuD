// Algorithm: Linear Search
// Runtime: O(n)
// use:
// - find an index of a value in an array

public class LinearSearch {

    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 2, 3, 4, 5, 6, 10, 50, 63, 79, 80, 95};
        int x = 50;

        System.out.println("Index of x is: " + linearSearch(A, x));
    }

    public static int linearSearch(int[] A, int x){
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x)
                return i;
        }
        return -1;
    }
}
