/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Find the k-th node (groupEnd)
            ListNode groupEnd = getKthNode(groupPrev, k);
            if (groupEnd == null) break; // Fewer than k nodes left

            ListNode nextGroupStart = groupEnd.next;
            ListNode groupStart = groupPrev.next;

            // Reverse the group [groupStart...groupEnd]
            reverse(groupStart, nextGroupStart);

            // Re-link the reversed group to the rest of the list
            // After reversal, groupEnd is the new head of the group
            groupPrev.next = groupEnd;
            // After reversal, groupStart is the new tail of the group
            groupStart.next = nextGroupStart;

            // Move groupPrev forward for the next iteration
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    // Helper: Standard reversal but stops at a specific node
    private void reverse(ListNode start, ListNode stop) {
        ListNode prev = null;
        ListNode curr = start;
        while (curr != stop) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
    }

    // Helper: Finds the k-th node from a starting point
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
