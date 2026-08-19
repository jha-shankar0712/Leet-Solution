class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // k-th node find karo
            ListNode kth = getKthNode(groupPrev, k);

            // Agar k nodes available nahi hain
            // toh remaining nodes ko same rehne do
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse current group
            ListNode prev = groupNext;
            ListNode current = groupPrev.next;

            while (current != groupNext) {

                ListNode temp = current.next;

                current.next = prev;
                prev = current;
                current = temp;
            }

            // Group ko previous part se connect karo
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;

            // Next group ke liye move karo
            groupPrev = temp;
        }

        return dummy.next;
    }

    // groupPrev ke baad k-th node find karta hai
    private ListNode getKthNode(ListNode current, int k) {

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
    }
}