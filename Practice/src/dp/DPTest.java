package dp;

public class DPTest {
    public static void main(String[] args) {
        System.out.println("====== DP PRACTICE TESTS ======");

        testFibonacci();
        testCoinChange();
        testKnapsack();
        testLCS();
        testEditDistance();

        // --- New Tests ---
        testJumpGame();
        testLIS();
        testSubsetSum();
    }

    private static void testFibonacci() {
        System.out.print("Testing Fibonacci... ");
        DP01_Fibonacci f = new DP01_Fibonacci();
        if(f.getNthFib(10) == 55) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL");
    }

    private static void testCoinChange() {
        System.out.print("Testing CoinChange... ");
        DP03_CoinChange cc = new DP03_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = cc.minCoins(coins, amount);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testKnapsack() {
        System.out.print("Testing Knapsack 0/1... ");
        DP06_Knapsack01 k = new DP06_Knapsack01();
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int res = k.solveKnapsack(weights, values, capacity);

        if(res == 220) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 220, Got " + res + ")");
    }

    private static void testLCS() {
        System.out.print("Testing LCS... ");
        DP07_LongestCommonSubsequence lcs = new DP07_LongestCommonSubsequence();
        String s1 = "abcde";
        String s2 = "ace";
        int res = lcs.longestCommonSubsequence(s1, s2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testEditDistance() {
        System.out.print("Testing EditDistance... ");
        DP08_EditDistance ed = new DP08_EditDistance();
        String w1 = "horse";
        String w2 = "ros";
        int res = ed.minDistance(w1, w2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testJumpGame() {
        System.out.print("Testing JumpGame... ");
        DP02_JumpGame jg = new DP02_JumpGame();
        boolean pass1 = jg.canJump(new int[]{2,3,1,1,4}); // True
        boolean pass2 = !jg.canJump(new int[]{3,2,1,0,4}); // False (stuck at 0)

        if(pass1 && pass2) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL");
    }

    private static void testLIS() {
        System.out.print("Testing LIS... ");
        DP04_LongestIncreasingSubsequence lis = new DP04_LongestIncreasingSubsequence();
        // Seq: [2, 3, 7, 101] -> length 4
        int res = lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});

        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 4, Got " + res + ")");
    }

    private static void testSubsetSum() {
        System.out.print("Testing SubsetSum... ");
        DP05_SubsetSum ss = new DP05_SubsetSum();
        boolean res = ss.hasSubsetSum(new int[]{1, 5, 11, 5}, 11);

        if(res) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected True)");
    }
}