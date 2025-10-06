class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 3, 5, 6};

        System.out.println("--- Testes de Busca Binária (searchInsert) ---");

        int target1 = 5;
        int result1 = solution.searchInsert(nums, target1);
        System.out.println("Array: [1, 3, 5, 6], Target: " + target1);
        System.out.println("Resultado: " + result1);

        int target2 = 2;
        int result2 = solution.searchInsert(nums, target2);
        System.out.println("Array: [1, 3, 5, 6], Target: " + target2);
        System.out.println("Resultado: " + result2 );

        int target3 = 7;
        int result3 = solution.searchInsert(nums, target3);
        System.out.println("Array: [1, 3, 5, 6], Target: " + target3);
        System.out.println("Resultado: " + result3);

        int target4 = 0;
        int result4 = solution.searchInsert(nums, target4);
        System.out.println("Array: [1, 3, 5, 6], Target: " + target4);
        System.out.println("Resultado: " + result4);
    }
}
