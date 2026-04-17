import java.util.Arrays;

/**
 * =========================================================
 * MAIN CLASS - Problem5
 * =========================================================
 *
 * Account ID Lookup System
 */

public class Problem5 {

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Original Logs: " + Arrays.toString(logs));

        // Linear Search (first + last)
        linearSearch(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
    }

    // Linear Search
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("\nLinear Search:");
        System.out.println("First: " + first + ", Last: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search + count
    public static void binarySearch(String[] arr, String target) {

        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int foundIndex = -1;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = target.compareTo(arr[mid]);

            if (cmp == 0) {
                foundIndex = mid;
                break;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Count occurrences
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        System.out.println("\nBinary Search:");
        System.out.println("Index: " + foundIndex);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + comparisons);
    }
}
