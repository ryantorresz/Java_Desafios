import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                int sum = prevRow.get(j - 1) + prevRow.get(j);
                currentRow.add(sum);
            }

            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}

public class PascalTriangle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate(numRows1);
        System.out.println("Input: numRows = " + numRows1);
        System.out.println("Output: " + result1);

        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        System.out.println("\nInput: numRows = " + numRows2);
        System.out.println("Output: " + result2);

        int numRows3 = 6;
        List<List<Integer>> result3 = solution.generate(numRows3);
        System.out.println("\nInput: numRows = " + numRows3);
        System.out.println("Output: " + result3);
    }
}