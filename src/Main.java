
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
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
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("=== Teste 1: Lista [1,2,3,4,5] ===");
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original: ");
        printList(head1);

        ListNode reversed1 = solution.reverseList(head1);
        System.out.print("Invertida: ");
        printList(reversed1);

        System.out.println("\n=== Teste 2: Lista [1,2] ===");
        ListNode head2 = createList(new int[]{1, 2});
        System.out.print("Original: ");
        printList(head2);

        ListNode reversed2 = solution.reverseList(head2);
        System.out.print("Invertida: ");
        printList(reversed2);

        System.out.println("\n=== Teste 3: Lista vazia [] ===");
        ListNode head3 = null;
        System.out.print("Original: ");
        printList(head3);

        ListNode reversed3 = solution.reverseList(head3);
        System.out.print("Invertida: ");
        printList(reversed3);

        System.out.println("\n=== Teste 4: Lista [5] ===");
        ListNode head4 = createList(new int[]{5});
        System.out.print("Original: ");
        printList(head4);

        ListNode reversed4 = solution.reverseList(head4);
        System.out.print("Invertida: ");
        printList(reversed4);
    }

    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println(" → null");
    }
}