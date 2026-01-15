package search;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("====== SEARCH PRACTICE TESTS ======");

        testBinarySearch();
    }

    private static void testBinarySearch() {
        System.out.print("Testing BinarySearch... ");
        BinarySearch bs = new BinarySearch();

        int[] arr = {1, 3, 5, 7, 9, 11}; // Must be sorted

        int targetExisting = 7;
        int targetMissing = 2;

        // Should return index 3 (value 7)
        int idx1 = bs.search(arr, targetExisting);

        // Should return -1
        int idx2 = bs.search(arr, targetMissing);

        if (idx1 == 3 && idx2 == -1) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL (Got " + idx1 + " and " + idx2 + ")");
        }
    }
}