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
        ListNode res = new ListNode();

        int aux = 0;
        ListNode node = res;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            node.next = new ListNode((val1 + val2+ aux) % 10);
            aux = (val1 + val2 + aux) / 10;
            if (l1 != null) 
                l1 = l1.next;
            if (l2 != null) 
                l2 = l2.next;
            node = node.next;
        }

        if (aux != 0)
            node.next = new ListNode(aux); 

        return res.next;
    }
}
