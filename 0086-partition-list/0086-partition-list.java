class Solution {
    public ListNode partition(ListNode head, int x) {

        // Two dummy nodes
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {
                small.next = curr;
                small = small.next;
            } 
            else {
                large.next = curr;
                large = large.next;
            }

            curr = curr.next;
        }

        // End the large list
        large.next = null;

        // Connect small list with large list
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}