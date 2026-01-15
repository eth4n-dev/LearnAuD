package sorting;

import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        System.out.println("====== SORTING PRACTICE TESTS ======");

        testMergeSort();
        testQuickSort();
        testHeapSort();
    }

    private static void testMergeSort() {
        System.out.print("Testing MergeSort... ");
        int[] input = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        MergeSort sorter = new MergeSort();
        sorter.sort(input);

        if (Arrays.equals(input, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Got " + Arrays.toString(input) + ")");
        }
    }

    private static void testQuickSort() {
        System.out.print("Testing QuickSort... ");
        int[] input = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        QuickSort sorter = new QuickSort();
        sorter.sort(input);

        if (Arrays.equals(input, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Got " + Arrays.toString(input) + ")");
        }
    }

    private static void testHeapSort() {
        System.out.print("Testing HeapSort... ");
        int[] input = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        HeapSort sorter = new HeapSort();
        sorter.sort(input);

        if (Arrays.equals(input, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Got " + Arrays.toString(input) + ")");
        }
    }
}