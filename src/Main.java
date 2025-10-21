
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public int maximumTwinSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalfReversed = reverseList(slow);

        ListNode p1 = head;
        ListNode p2 = headSecondHalfReversed;
        int maxTwinSum = 0;

        while (p2 != null) {
            int twinSum = p1.val + p2.val;
            maxTwinSum = Math.max(maxTwinSum, twinSum);

            p1 = p1.next;
            p2 = p2.next;
        }

        return maxTwinSum;
    }
}

public class Main {
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {5, 4, 2, 1};
        ListNode head1 = createLinkedList(arr1);
        int result1 = solution.maximumTwinSum(head1);
        System.out.println("Input: [5,4,2,1], Max Twin Sum: " + result1 + " (Expected: 6)");

        int[] arr2 = {4, 2, 2, 3};
        ListNode head2 = createLinkedList(arr2);
        int result2 = solution.maximumTwinSum(head2);
        System.out.println("Input: [4,2,2,3], Max Twin Sum: " + result2 + " (Expected: 7)");

        int[] arr3 = {1, 100000};
        ListNode head3 = createLinkedList(arr3);
        int result3 = solution.maximumTwinSum(head3);
        System.out.println("Input: [1,100000], Max Twin Sum: " + result3 + " (Expected: 100001)");
    }
}

// ajuste asus