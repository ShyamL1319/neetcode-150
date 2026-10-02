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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Use a dummy head to simplify the 'head' assignment logic
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Process until both lists are empty AND there's no remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous step

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Standard math: carry is the 'tens' place, val is the 'ones' place
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next; // Skip the dummy 0 node
    }
}
