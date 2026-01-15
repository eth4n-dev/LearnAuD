// Algorithm: Edit Distance
// Runtime: O(n*m), Space: O(n*m)
// use:
// - find the number of characters by which two strings differ

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(distance("TIGER", "ZIEGE")); // 3
        System.out.println(distance("kitten", "sitting")); // 3
    }

    // Unit-cost Levenshtein distance: insert/delete/substitute = 1; match = 0
    public static int distance(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        // base cases
        for (int i = 0; i <= n; i++) dp[i][0] = i;     // delete i chars
        for (int j = 0; j <= m; j++) dp[0][j] = j;     // insert j chars

        for (int i = 1; i <= n; i++) {
            char ca = a.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                char cb = b.charAt(j - 1);
                int costSub = (ca == cb) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1,         // delete a[i-1]
                                dp[i][j - 1] + 1),        // insert b[j-1]
                        dp[i - 1][j - 1] + costSub         // substitute or match
                );
            }
        }
        return dp[n][m];
    }

}
