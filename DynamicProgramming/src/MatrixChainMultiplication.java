// Algorithm: Matrix Chain Multiplication
// Runtime: O(n^3)
// use:
// - find the most optimal order of matrix multiplication with the least amount of operations

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        // Matrices [M1, M2, M3, M3]
        int[] A = {5, 2, 8, 3};

        System.out.println(matrixChainMultiplication(A));
    }

    static int matrixChainMultiplication(int[] A) {
        int length = A.length;

        // create 2d array to store minimum costs of multiplying
        // different parts (smaller chains) of the whole chain
        int[][] dp = new int[length][length];

        // build solutions from short subchains to longer ones
        for (int chainLength = 2; chainLength < length; chainLength++) {
            // choose i and j for the current subchain length
            for (int i = 0; i < length - chainLength; i++){
                int j = i + chainLength;
                // initialise best cost to infinity
                dp[i][j] = Integer.MAX_VALUE;

                // try every possible split point when
                // multiplying matrix i and matrix j in a subchain
                for (int k = i + 1; k < j; k++) {
                    // dp[i][k] - precomputed optimal cost of (Mi+1*...*Mk)
                    // dp[k][j] - precomputed optimal cost of (Mk+1*...*Mj)
                    // A[i] * A[k] * A[j] - cost of (Mi+1*...*Mk) * (Mk+1*...*Mj)
                    // cost - is a cost for the current subchain of matrix multiplications
                    int cost = dp[i][k] + dp[k][j] + A[i] * A[k] * A[j];

                    // Update only if it smaller than the current value - this
                    // means we are taking minimum (optimal) value
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // return optimal number of steps for multiplying (M1*...*Mn) matrices
        return dp[0][length-1];
    }

}
