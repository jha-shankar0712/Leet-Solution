class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Duplicate mila
            if (curr.next != null && curr.val == curr.next.val) {

                int duplicateValue = curr.val;

                // Saare duplicate nodes skip karo
                while (curr != null && curr.val == duplicateValue) {
                    curr = curr.next;
                }

                prev.next = curr;
            }

            // Duplicate nahi hai
            else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}