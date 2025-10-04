public class MergeSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Criação do nó sentinela (dummyHead)
        ListNode dummyHead = new ListNode(0);

        // Ponteiro 'current' para construir a lista
        ListNode current = dummyHead;

        // Loop principal: compara e anexa o nó menor
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Anexa o restante da lista que não se esgotou
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        // Retorna o cabeçalho real
        return dummyHead.next;
    }

    // --- Métodos Auxiliares para Teste ---

    public static ListNode createList(int[] arr) {
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

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.print("[]");
            return;
        }
        System.out.print("[");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        MergeSortedLists solution = new MergeSortedLists();

        // Exemplo 1: [1,2,4], [1,3,4] -> [1,1,2,3,4,4]
        ListNode list1_1 = createList(new int[]{1, 2, 4});
        ListNode list2_1 = createList(new int[]{1, 3, 4});
        ListNode merged1 = solution.mergeTwoLists(list1_1, list2_1);
        System.out.print("Resultado 1: "); printList(merged1); System.out.println();

        // Exemplo 2: [], [0] -> [0]
        ListNode list1_3 = createList(new int[]{});
        ListNode list2_3 = createList(new int[]{0});
        ListNode merged3 = solution.mergeTwoLists(list1_3, list2_3);
        System.out.print("Resultado 2: "); printList(merged3); System.out.println();
    }
}