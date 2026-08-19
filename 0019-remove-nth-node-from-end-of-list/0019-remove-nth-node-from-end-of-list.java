class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Fast ko n steps aage le jao
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Dono pointers ko move karo
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Nth node remove
        slow.next = slow.next.next;

        return dummy.next;
    }
}