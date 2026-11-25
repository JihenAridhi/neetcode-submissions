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
    public static boolean hasCycle(ListNode head) {

        if(head==null || head.next==null || head.next.next==null)
            return false;
        
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow)
                return true;
        }
        
        return false;
    }
}
