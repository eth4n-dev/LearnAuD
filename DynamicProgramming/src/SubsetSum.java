// Algorithm: Subset Sum
// Runtime: O(n*sum),
// use:
// - check if there is a subset of an array with sum equal to the given sum

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int sum = 37;

        System.out.println(isSubsetSum(arr, sum));
    }

    // Function to check if there is a subset of arr[]
    // with sum equal to the given sum using tabulation
    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        // Create a 2D array for storing results of
        // subproblems
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // If sum is 0, then answer is true
        // (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the dp table in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {

                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
                else {

                    // Include or exclude
                    dp[i][j] = dp[i - 1][j]
                            || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

}
