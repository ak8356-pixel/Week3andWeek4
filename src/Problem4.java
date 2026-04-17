import java.util.Arrays;
import java.util.Random;

/**
 * =========================================================
 * MAIN CLASS - Problem4
 * =========================================================
 *
 * Portfolio Return Sorting System
 */

class Asset {
    String name;
    double returnRate;
    double volatility;

    public Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }

    public String toString() {
        return name + ":" + returnRate + "%";
    }
}

public class Problem4 {

    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        System.out.println("Original:");
        print(assets);

        // Merge Sort (Ascending - stable)
        mergeSort(assets, 0, assets.length - 1);
        System.out.println("\nMerge Sort (Ascending):");
        print(assets);

        // Quick Sort (Descending + volatility ASC)
        quickSort(assets, 0, assets.length - 1);
        System.out.println("\nQuick Sort (Descending):");
        print(assets);
    }

    // ================= MERGE SORT =================
    public static void mergeSort(Asset[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(Asset[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        Asset[] L = new Asset[n1];
        Asset[] R = new Asset[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].returnRate <= R[j].returnRate) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ================= QUICK SORT =================
    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = randomPivot(low, high);
            swap(arr, pivotIndex, high);

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(Asset[] arr, int low, int high) {

        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // DESC by returnRate, ASC by volatility
            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate &&
                            arr[j].volatility < pivot.volatility)) {

                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Random Pivot
    public static int randomPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static void swap(Asset[] arr, int i, int j) {
        Asset temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(Asset[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
