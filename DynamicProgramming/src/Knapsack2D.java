// Algorithm: Knapsack 0-1
// Runtime: O(n*W), Space: O(n*W)
// use:
// - find the optimal profit with the given capacity of the backpack

public class Knapsack2D {

    public static void main(String[] args) {
        int[] values = {0, 3, 10, 2, 50, 19};
        int[] weights = {40, 29, 4, 2, 3, 19};
        int backpackCapacity = 40;

        System.out.println("Maximum profit with capacity " + backpackCapacity + " is: " + knapsack2D(backpackCapacity, values, weights));
    }

    public static int knapsack2D(int W, int[] val, int[] wt){
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build the table row by row (items), column by column (capacity)
        for (int i = 1; i <= n; i++) {
            int wi = wt[i - 1];
            int vi = val[i - 1];
            for (int w = 0; w <= W; w++) {
                // Option 1: don't take item i-1
                dp[i][w] = dp[i - 1][w];

                // Option 2: take item i-1 (if it fits)
                if (wi <= w) {
                    // go above one row and to the left to the column
                    // which describes a weight which is left after filling
                    // the space with the current object. Add remaining profit
                    // (after subtracting) with current object profit to see the overall profit
                    // - compare it with the profit of the above row
                    // (profit from option 1 which represents the profit without
                    // taking the current item) and see which profit is bigger to have
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - wi] + vi);
                }
            }
        }

        return dp[n][W];
    }
}
