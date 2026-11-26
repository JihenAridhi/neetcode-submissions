/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Map<Node, Node> map = new HashMap<>();

        Node copy = null;
        Node i = head, j = null;
        while (i != null) {
            j = new Node(i.val);
            if (i == head)
                copy = j;
            map.put(i, j);
            i = i.next;
            j = j.next;
        }

        for (Node node : map.keySet()) {
            Node nodeCopy = map.get(node);
            if (node.next != null)
                nodeCopy.next = map.get(node.next);
            if (node.random != null)
                nodeCopy.random = map.get(node.random);
        }

        return copy;
    }
}
