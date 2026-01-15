import java.util.Arrays;
// Algorithm: Longest Ascending Subsequence (Longest Increasing Subsequence)
// Runtime: O(n^2)
// use:
// - find the longest subsequence in the given array which has increasing values

public class LongestAscendingSubsequence {

    public static void main(String[] args) {
        int[] arr = {1, 15, 4, 38, 11, 4, 30, 70};
        System.out.println(longestAscendingSubsequence(arr));
    }

    static int longestAscendingSubsequence(int[] A) {
        int length = A.length;

        // If empty return length 0
        if (A.length == 0) return 0;

        // prepare for memoization
        int[] memo = new int[length];
        Arrays.fill(memo, -1);


        // find the maximum of longest subsequences
        int result = 1;
        for (int i = 1; i < length; i++)
            result = Math.max(result, lasEndingAtI(A, i, memo));

        // return the length of a longest subsequence
        return result;
    }

    private static int lasEndingAtI(int[] A, int i, int[] memo) {

        // Base case
        if (i == 0)
            return 1;

        // return already computed values
        if (memo[i] != -1)
            return memo[i];

        // since any single element by itself is LAS we start with length 1
        int max = 1;
        // check recursively over all previous indices
        for (int prev = 0; prev < i; prev++)
            // if previous index is smaller, then it's ascending towards i
            if (A[prev] < A[i])
                // lasEndingAtI(A, prev, memo) + 1 length of the longest increasing
                // subsequence ending at prev and appended A[i]
                // max - keep the longest such possibility among all previous indices
                max = Math.max(max, lasEndingAtI(A, prev, memo) + 1);

        // Store computer result in memo (for future reuse)
        memo[i] = max;
        // return the length of a longest subsequence ending at i
        return memo[i];
    }

}
