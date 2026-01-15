package dp;

public class DPTest {
    public static void main(String[] args) {
        System.out.println("====== DP PRACTICE TESTS ======");

        testFibonacci();
        testCoinChange();
        testKnapsack();
        testLCS();
        testEditDistance();
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
        // Expected: 3 coins (5, 5, 1)
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
        // Expected: 220 (items 2 and 3: 20+30=50 weight, 100+120=220 value)
        int res = k.solveKnapsack(weights, values, capacity);

        if(res == 220) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 220, Got " + res + ")");
    }

    private static void testLCS() {
        System.out.print("Testing LCS... ");
        LCS lcs = new LCS();
        String s1 = "abcde";
        String s2 = "ace";
        // Expected: 3 ("ace")
        int res = lcs.longestCommonSubsequence(s1, s2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }

    private static void testEditDistance() {
        System.out.print("Testing EditDistance... ");
        EditDistance ed = new EditDistance();
        String w1 = "horse";
        String w2 = "ros";
        // Expected: 3
        int res = ed.minDistance(w1, w2);

        if(res == 3) System.out.println("✅ PASS");
        else System.out.println("❌ FAIL (Expected 3, Got " + res + ")");
    }
}