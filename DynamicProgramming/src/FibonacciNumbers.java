// Algorithm: Fibonacci Numbers
// Runtime: O(n), Space:  O(1)
// use:
// - Calculate the n-th Fibonacci number

public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(fibonacciNumbers(18));
    }

    // Calculate the n-th Fibonacci number using DP with space optimisation to O(1)
    static int fibonacciNumbers(int n) {
        if (n <= 1) return n;

        // initialise var for resulting (current) fibonacci number
        int F_result = 0;

        // variables for 2 previous fibonacci numbers
        int F1 = 1;
        int F2 = 0;

        for (int i = 2; i <= n; i++) {
            // Calculate Fibonacci number: F1 + F2 = F_result
            F_result = F1 + F2;
            // prepare prev2 for the next iteration: F2 = F1
            F2 = F1;
            // prepare prev1 for the next iteration: F1 = F_result
            F1 = F_result;
        }

        return F_result;
    }

}
