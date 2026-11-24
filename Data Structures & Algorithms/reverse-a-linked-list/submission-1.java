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
        ListNode reversed = null;
        ListNode i = head;
        while (i != null) {
            reversed = new ListNode(i.val, reversed);
            i = i.next;
        }

        return reversed;
    }
}
