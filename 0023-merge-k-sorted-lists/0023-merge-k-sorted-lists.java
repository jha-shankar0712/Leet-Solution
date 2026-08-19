import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Har list ka first node heap mein add karo
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {

            // Smallest node nikalo
            ListNode node = pq.poll();

            // Result mein add karo
            current.next = node;
            current = current.next;

            // Us node ke next ko heap mein add karo
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}