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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while(node!=null){
            length++;
            node = node.next;
        }
        int position = length-n;
        int i = 0;
        node = head;
        ListNode previous = new ListNode();
        while(i <= position){
            if(i == position){
                if(position == 0)
                    head = head.next;
                previous.next = node.next;
                node.next = null;
            }
            previous = node;
            node = node.next;
            i++;
        }
        return head;
    }
}
