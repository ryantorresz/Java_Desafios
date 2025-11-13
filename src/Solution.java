class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];

        for (int num : nums)
            count[num + 10000]++;

        for (int i = count.length - 1; i >= 0; i--)
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) return i - 10000;
            }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Teste 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Array: [3, 2, 1, 5, 6, 4]");
        System.out.println(k1 + "º maior elemento: " + solution.findKthLargest(nums1, k1));
        System.out.println();

        // Teste 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Array: [3, 2, 3, 1, 2, 4, 5, 5, 6]");
        System.out.println(k2 + "º maior elemento: " + solution.findKthLargest(nums2, k2));
        System.out.println();

        // Teste 3
        int[] nums3 = {-1, -2, -3, -4, -5};
        int k3 = 1;
        System.out.println("Array: [-1, -2, -3, -4, -5]");
        System.out.println(k3 + "º maior elemento: " + solution.findKthLargest(nums3, k3));
        System.out.println();

        // Teste 4
        int[] nums4 = {7};
        int k4 = 1;
        System.out.println("Array: [7]");
        System.out.println(k4 + "º maior elemento: " + solution.findKthLargest(nums4, k4));
    }
}