class DeleteMiddleNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    static class Solution {
        public ListNode deleteMiddle(ListNode head) {

            if (head == null || head.next == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {

                prev = slow;

                slow = slow.next;

                fast = fast.next.next;
            }

            prev.next = slow.next;

            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        System.out.println("--- Exemplo 1 (N=7) ---");
        System.out.println("Original: " + head1.toString());
        ListNode result1 = solution.deleteMiddle(head1);
        System.out.println("Resultado: " + (result1 != null ? result1.toString() : "Lista Vazia"));

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("\n--- Exemplo 2 (N=4) ---");
        System.out.println("Original: " + head2.toString());
        ListNode result2 = solution.deleteMiddle(head2);
        System.out.println("Resultado: " + (result2 != null ? result2.toString() : "Lista Vazia"));

        ListNode head3 = new ListNode(2, new ListNode(1));
        System.out.println("\n--- Exemplo 3 (N=2) ---");
        System.out.println("Original: " + head3.toString());
        ListNode result3 = solution.deleteMiddle(head3);
        System.out.println("Resultado: " + (result3 != null ? result3.toString() : "Lista Vazia"));

        ListNode head4 = new ListNode(5);
        System.out.println("\n--- Exemplo 4 (N=1) ---");
        System.out.println("Original: " + head4.toString());
        ListNode result4 = solution.deleteMiddle(head4);
        System.out.println("Resultado: " + (result4 != null ? result4.toString() : "Lista Vazia"));
    }
}