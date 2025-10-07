
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        if (next == null) return String.valueOf(val);
        return val + " -> " + next.toString();
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        Solution solver = new Solution();

        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println("Lista Original 1: " + head1);
        ListNode resultado1 = solver.deleteDuplicates(head1);
        System.out.println("Resultado 1: " + resultado1);

        System.out.println("---");


        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println("Lista Original 2: " + head2);
        ListNode resultado2 = solver.deleteDuplicates(head2);
        System.out.println("Resultado 2: " + resultado2);

        System.out.println("---");

        ListNode head3 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))));
        System.out.println("Lista Original 3: " + head3);
        ListNode resultado3 = solver.deleteDuplicates(head3);
        System.out.println("Resultado 3: " + resultado3);
    }
}