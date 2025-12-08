import java.util.*;

public class InsertionSortPart1 {

    public static void insertionSort1(int n, List<Integer> arr) {
        int e = arr.get(n - 1);

        int j = n - 2;

        while (j >= 0 && arr.get(j) > e) {

            arr.set(j + 1, arr.get(j));

            printArray(arr);

            j--;
        }

        arr.set(j + 1, e);

        printArray(arr);
    }

    public static void printArray(List<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 3));
        int n = arr.size();
        System.out.println("Starting array: 2 4 6 8 3");
        System.out.println("--- Shifts ---");
        insertionSort1(n, arr);
    }
}