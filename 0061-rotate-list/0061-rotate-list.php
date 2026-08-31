class Solution {

    function rotateRight($head, $k) {

        // Empty list or single node
        if ($head == null || $head->next == null || $k == 0) {
            return $head;
        }

        // Find length and last node
        $length = 1;
        $tail = $head;

        while ($tail->next != null) {
            $tail = $tail->next;
            $length++;
        }

        // Remove unnecessary rotations
        $k = $k % $length;

        if ($k == 0) {
            return $head;
        }

        // Make circular linked list
        $tail->next = $head;

        // Find new tail
        $steps = $length - $k;

        $newTail = $head;

        for ($i = 1; $i < $steps; $i++) {
            $newTail = $newTail->next;
        }

        // New head
        $newHead = $newTail->next;

        // Break the circle
        $newTail->next = null;

        return $newHead;
    }
}