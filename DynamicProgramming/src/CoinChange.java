// Algorithm: Coin Change
// Runtime: O(n * sum);
// use:
// - find how many ways are there to give a change with given types of coins

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println(coinChangeCount(coins, sum));
    }

    static int coinChangeCount(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];

        dp[0][0] = 1;
        // number of ways to make sum j using only first i coin types
        // dp[coin types][sum]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // 1. Either we don’t use the current coin and take all combinations with previous coins
                // (number of ways without coin i)
                dp[i][j] += dp[i-1][j];

                // 2. Or we take all ways to combine the smaller sum (j − coin) and extend each of them by adding the current coin.
                // (number of ways with coin i)
                if ((j - coins[i-1]) >= 0) {
                    dp[i][j] += dp[i][j - coins[i-1]];
                    // Why subtraction gives “exactly the right number”:
                    // Each way to make (j − coin) corresponds to exactly one way to make j whose last coin is coin.
                }

                // dp[i][j]
                // =
                // (number of ways without coin i)
                // +
                // (number of ways with coin i)
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

}
