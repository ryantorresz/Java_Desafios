import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[n + 1];

        newDigits[0] = 1;

        return newDigits;
    }
}

class Main {

    public static void printArray(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("--- Testes Plus One ---");

        int[] input1 = {1, 2, 3};
        int[] result1 = solution.plusOne(input1);
        System.out.print("Input: [1, 2, 3] -> Output: ");
        printArray(result1);
        System.out.println();

        int[] input2 = {4, 3, 2, 9};
        int[] result2 = solution.plusOne(input2);
        System.out.print("Input: [4, 3, 2, 9] -> Output: ");
        printArray(result2);
        System.out.println();

        int[] input3 = {9};
        int[] result3 = solution.plusOne(input3);
        System.out.print("Input: [9] -> Output: ");
        printArray(result3);
        System.out.println();

        int[] input4 = {9, 9, 9};
        int[] result4 = solution.plusOne(input4);
        System.out.print("Input: [9, 9, 9] -> Output: ");
        printArray(result4);
        System.out.println();
    }
}