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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            // 1. Save the next node
            ListNode nextTemp = curr.next;
            
            // 2. Reverse the link
            curr.next = prev;
            
            // 3. Move pointers forward
            prev = curr;
            curr = nextTemp;
        }
        
        // At the end, prev will be the new head
        return prev;
    }
}
