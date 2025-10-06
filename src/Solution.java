class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;

        for(int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];

                k++;
            }
        }

        return k;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);

        System.out.println("--- Teste 1: [1, 1, 2] ---");
        System.out.println("Comprimento (k) retornado: " + k1);

        System.out.print("Primeiros k elementos de nums: [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");


        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);

        System.out.println("\n--- Teste 2: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] ---");
        System.out.println("Comprimento (k) retornado: " + k2);

        System.out.print("Primeiros k elementos de nums: [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");


        int[] nums3 = {5, 6, 7, 8};
        int k3 = solution.removeDuplicates(nums3);

        System.out.println("\n--- Teste 3: [5, 6, 7, 8] ---");
        System.out.println("Comprimento (k) retornado: " + k3);

        System.out.print("Primeiros k elementos de nums: [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + (i < k3 - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}