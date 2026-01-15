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
        Fibonacci f = new Fibonacci();
        if(f.getNthFib(10) == 55) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL");
    }

    private static void testCoinChange() {
        System.out.print("Testing CoinChange... ");
        CoinChange cc = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = cc.minCoins(coins, amount);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testKnapsack() {
        System.out.print("Testing Knapsack 0/1... ");
        Knapsack01 k = new Knapsack01();
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int res = k.solveKnapsack(weights, values, capacity);

        if(res == 220) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 220, Got " + res + ")");
    }

    private static void testLCS() {
        System.out.print("Testing LCS... ");
        LCS lcs = new LCS();
        String s1 = "abcde";
        String s2 = "ace";
        int res = lcs.longestCommonSubsequence(s1, s2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testEditDistance() {
        System.out.print("Testing EditDistance... ");
        EditDistance ed = new EditDistance();
        String w1 = "horse";
        String w2 = "ros";
        int res = ed.minDistance(w1, w2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testJumpGame() {
        System.out.print("Testing JumpGame... ");
        JumpGame jg = new JumpGame();
        boolean pass1 = jg.canJump(new int[]{2,3,1,1,4}); // True
        boolean pass2 = !jg.canJump(new int[]{3,2,1,0,4}); // False (stuck at 0)

        if(pass1 && pass2) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL");
    }

    private static void testLIS() {
        System.out.print("Testing LIS... ");
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        // Seq: [2, 3, 7, 101] -> length 4
        int res = lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});

        if(res == 4) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 4, Got " + res + ")");
    }

    private static void testSubsetSum() {
        System.out.print("Testing SubsetSum... ");
        SubsetSum ss = new SubsetSum();
        boolean res = ss.hasSubsetSum(new int[]{1, 5, 11, 5}, 11);

        if(res) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected True)");
    }
}