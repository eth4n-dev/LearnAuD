import java.util.Arrays;
// Algorithm: Jump Game
// Runtime: O(n)
// use:
// - find the minimum number of jumps to reach the end of an array

public class JumpGame {

    public static void main(String[] args) {
        int[] A = {1, 4, 1, 4, 6, 7, 10, 3, 12};

        System.out.println(minimumJumps(A));
    }

    static int minimumJumps(int[] A) {

        // prepare for memoization
        int[] memo = new int[A.length];
        Arrays.fill(memo, -1);

        // launch recursive method
        int result = minimumJumpRecurrence(0, A, memo);

        // If end is unreachable return -1
        if (result == Integer.MAX_VALUE)
            return -1;

        return result;
    }

    private static int minimumJumpRecurrence(int i, int[] A, int[] memo) {

        // Base case: If you are at the last index, no more jumps needed
        if (i == A.length - 1)
            return 0;

        // return value if it was already computed before
        if (memo[i] != -1)
            return memo[i];

        // initialise result as if we can not yet reach the end from i
        int result = Integer.MAX_VALUE;

        // try all possible next position for jumping from position i to j
        // j must satisfy: i < j <= i + A[i]
        // j > i - j is the next position
        // j <= i+A[i] - j is the next position such that we can reach it
        // with maximum jump length from i (that is A[i]) (j must satisfy: i < j <= i + A[i])
        // j < A.length - j is inside the array (so we can jump there)
        for (int j = i+1; j <= i+A[i] && j < A.length; j++) {

            // check all jump possibilities recursively
            // "If I jump to position j, what is the minimum number of jumps from there to the end?"
            int value = minimumJumpRecurrence(j, A, memo);

            // if j can reach the end (value != Integer.MAX_VALUE)
            // 1 + value - add 1 jump from i to j
            // Math.min - keep the minimum number of jumps
            if (value != Integer.MAX_VALUE)

                // "Among all places I can legally jump to next, which one
                // leads to the fewest total jumps to reach the end?"
                result = Math.min(result, 1 + value);
        }

        // memoize computed value for better runtime (reusing in the future)
        memo[i] = result;

        // return computed value - optimal number jumps up to i
        return result;
    }

}
