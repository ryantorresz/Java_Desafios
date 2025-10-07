import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int pMerge = m + n - 1;

        while (p2 >= 0) {

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge] = nums1[p1];
                p1--;
            } else {
                nums1[pMerge] = nums2[p2];
                p2--;
            }

            pMerge--;
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2_1 = {2, 5, 6};
        int n1 = 3;

        solver.merge(nums1_1, m1, nums2_1, n1);
        System.out.println(Arrays.toString(nums1_1));

        int[] nums1_2 = {1};
        int m2 = 1;
        int[] nums2_2 = {};
        int n2 = 0;

        solver.merge(nums1_2, m2, nums2_2, n2);
        System.out.println(Arrays.toString(nums1_2));

        int[] nums1_3 = {0};
        int m3 = 0;
        int[] nums2_3 = {1};
        int n3 = 1;

        solver.merge(nums1_3, m3, nums2_3, n3);
        System.out.println(Arrays.toString(nums1_3));

        int[] nums1_4 = {4, 5, 6, 0, 0, 0};
        int m4 = 3;
        int[] nums2_4 = {1, 2, 3};
        int n4 = 3;

        solver.merge(nums1_4, m4, nums2_4, n4);
        System.out.println(Arrays.toString(nums1_4));
    }
}