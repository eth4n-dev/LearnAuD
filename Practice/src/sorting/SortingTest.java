package sorting;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        System.out.println("====== SORTING PRACTICE TESTS ======");

        int[] input = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        System.out.print("Testing MergeSort... ");
        MergeSort sorter = new MergeSort();
        sorter.sort(input);

        if (Arrays.equals(input, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Got " + Arrays.toString(input) + ")");
        }
    }
}