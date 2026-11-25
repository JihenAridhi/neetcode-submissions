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
    public void reorderList(ListNode head) {
        // determine mid
        ListNode slow=head, fast=head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right side
        ListNode mid = fast==null ? slow : slow.next;
        ListNode reversedMidList = null;
        while(mid!=null){
            ListNode node = mid;
            mid = mid.next;
            node.next = reversedMidList;
            reversedMidList = node;
        }

        // merge both lists
        ListNode i = head, j=reversedMidList;
        while (i!=null && j!=null) { 
            ListNode nextI = i.next;
            ListNode nextJ = j.next;
            i.next = j;
            j.next = nextI;
            i=nextI;
            j=nextJ;
        }
        if(i==null)
            j.next=null;
        else
            i.next=null;
    }
}
