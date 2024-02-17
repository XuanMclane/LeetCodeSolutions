package Question206;

//https://leetcode.com/problems/reverse-linked-list/description/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode returnedNode = new ListNode(0);
        while(head != null) {
            ListNode current = new ListNode(head.val);
            current.next = returnedNode.next;
            returnedNode.next = current;
            head = head.next;
        }
        return returnedNode.next;
    }
}
