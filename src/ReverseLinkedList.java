public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; next = next; }
    }

  
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

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
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("--- Teste Iterativo ---");
        System.out.print("Lista Original: ");
        printList(head1);

        ListNode reversed1 = solution.reverseListIterative(head1);
        System.out.print("Lista Revertida: ");
        printList(reversed1); 

        System.out.println("\n--- Teste Recursivo ---");
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.print("Lista Original: ");
        printList(head2);

        ListNode reversed2 = solution.reverseListIterative(head2);
        System.out.print("Lista Revertida: ");
        printList(reversed2); 
    }
}