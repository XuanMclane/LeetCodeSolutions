package Question21;

//https://leetcode.com/problems/merge-two-sorted-lists/

import java.util.Arrays;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode output = new ListNode(0);
        generate(output, list1, list2);
        return output.next;
    }

    private void generate(ListNode output, ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                output.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                output.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            generate(output.next, list1, list2);
        } else {
            if (list1 == null) {
                output.next = list2;
            } else {
                output.next = list1;
            }
        }
    }
}




