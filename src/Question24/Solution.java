package Question24;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode returnedNode = new ListNode(0);
        returnedNode.next = new ListNode(head.next.val);
        returnedNode.next.next = new ListNode(head.val);
        returnedNode.next.next.next = swapPairs(head.next.next);
        return returnedNode.next;
    }
}
