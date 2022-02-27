package Question23;

//https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) return new ListNode();
        return seperateNode(lists, 0, lists.length -1);
    }

    private ListNode seperateNode(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) /2;
        ListNode left = seperateNode(lists, start, mid);
        ListNode right = seperateNode(lists, mid+1, end);
        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = new ListNode(left.val);
                left = left.next;
            } else {
                dummy.next =  new ListNode(right.val);
                right = right.next;
            }
            dummy = dummy.next;
        }
        while (left == null) {
            dummy.next = right;
        }
        while (right == null) {
            dummy.next = left;
        }
        return result.next;
    }
}
