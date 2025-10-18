import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int operations = 0;

        for (int num : nums) {
            int complement = k - num;

            if (freqMap.getOrDefault(num, 0) <= 0) {
                continue;
            }

            if (complement != num) {
                if (freqMap.getOrDefault(complement, 0) > 0) {
                    freqMap.put(num, freqMap.get(num) - 1);
                    freqMap.put(complement, freqMap.get(complement) - 1);
                    operations++;
                }

            } else {
                if (freqMap.get(num) >= 2) {
                    freqMap.put(num, freqMap.get(num) - 2);
                    operations++;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        int result1 = solver.maxOperations(nums1, k1);
        System.out.println("Example 1:");
        System.out.println("Input: nums = [1, 2, 3, 4], k = 5");
        System.out.println("Max Operations: " + result1);

        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        int result2 = solver.maxOperations(nums2, k2);
        System.out.println("\nExample 2:");
        System.out.println("Input: nums = [3, 1, 3, 4, 3], k = 6");
        System.out.println("Max Operations: " + result2);

        int[] nums3 = {4, 4, 1, 3, 1, 3, 2, 2};
        int k3 = 4;
        int result3 = solver.maxOperations(nums3, k3);
        System.out.println("\nExample 3:");
        System.out.println("Input: nums = [4, 4, 1, 3, 1, 3, 2, 2], k = 4");
        System.out.println("Max Operations: " + result3);
    }
}