import java.util.Arrays;

/**
 * =========================================================
 * MAIN CLASS - Problem2
 * =========================================================
 *
 * Client Risk Score Ranking System
 */

class Client {
    String name;
    int riskScore;
    double accountBalance;

    public Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class Problem2 {

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 8000),
                new Client("clientB", 50, 3000)
        };

        System.out.println("Original:");
        print(clients);

        // Bubble Sort (Ascending riskScore)
        bubbleSort(clients);
        System.out.println("\nBubble Sort (Ascending):");
        print(clients);

        // Insertion Sort (Descending riskScore + accountBalance)
        insertionSort(clients);
        System.out.println("\nInsertion Sort (Descending):");
        print(clients);

        // Top 3 highest risk
        System.out.println("\nTop High Risk Clients:");
        printTop(clients, 3);
    }

    // Bubble Sort (Ascending)
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Swaps: " + swaps);
    }

    // Insertion Sort (Descending + accountBalance)
    public static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {

            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Print array
    public static void print(Client[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Top N clients
    public static void printTop(Client[] arr, int k) {
        for (int i = 0; i < Math.min(k, arr.length); i++) {
            System.out.println(arr[i].name + "(" + arr[i].riskScore + ")");
        }
    }
}
