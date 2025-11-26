class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution solver = new Solution();

        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Array: [2, 3, 1, 1, 4] -> Pode Saltar? " + solver.canJump(nums1) + " (Esperado: true)");

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Array: [3, 2, 1, 0, 4] -> Pode Saltar? " + solver.canJump(nums2) + " (Esperado: false)");

        int[] nums3 = {0};
        System.out.println("Array: [0] -> Pode Saltar? " + solver.canJump(nums3) + " (Esperado: true)");

        int[] nums4 = {1, 1, 1, 0, 1};
        System.out.println("Array: [1, 1, 1, 0, 1] -> Pode Saltar? " + solver.canJump(nums4) + " (Esperado: false)");
    }
}