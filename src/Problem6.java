import java.util.Arrays;

/**
 * =========================================================
 * MAIN CLASS - Problem6
 * =========================================================
 *
 * Risk Threshold Lookup System
 */

public class Problem6 {

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        System.out.println("Sorted Risks: " + Arrays.toString(risks));

        int target = 30;

        // Linear Search
        linearSearch(risks, target);

        // Binary Search Floor & Ceiling
        binarySearch(risks, target);
    }

    // Linear Search
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int val : arr) {
            comparisons++;
            if (val == target) {
                found = true;
                break;
            }
        }

        System.out.println("\nLinear Search:");
        System.out.println("Found: " + found);
        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search Floor & Ceiling
    public static void binarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Floor: " + floor);
        System.out.println("Ceiling: " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }
}
