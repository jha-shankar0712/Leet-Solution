class Solution {
    public ListNode swapPairs(ListNode head) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {

            // First and second node
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Next pair par jao
            current = first;
        }

        return dummy.next;
    }
}