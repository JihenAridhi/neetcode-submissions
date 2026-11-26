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
        ListNode i = l1, j = l2, k = res;
        while (i != null || j != null) {
            int val1 = (i != null) ? i.val : 0;
            int val2 = (j != null) ? j.val : 0;
            k.val += (val1 + val2+ aux) % 10 ;
            aux = (val1 + val2 + aux) / 10;
            if (i != null) 
                i = i.next;
            if (j != null) 
                j = j.next;
            if(i != null || j != null || aux!=0)
                k.next = new ListNode();
            k = k.next;
        }

        if (aux != 0)
            k.val = aux; 

        return res;
    }
}
