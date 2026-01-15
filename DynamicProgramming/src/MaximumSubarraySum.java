// Algorithm: Maximum Subarray Sum (Kadane)
// Runtime: O(n)
// use:
// - find maximum sum of the element of a given array (maximum subarray sum)

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] A = {2, 4, 5, -1, -10, 8, 100};

        System.out.println(maxSubarraySum(A));
    }

    static int maxSubarraySum(int[] A) {
        int max = A[0], currMax = A[0];

        for(int i = 1; i < A.length; i++){
            currMax = Math.max(A[i], currMax + A[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}
