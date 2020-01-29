package com.wt.leetcode2;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        fillNode(l1, l2);
        return add(l1, l2, 0);
    }

    private void fillNode(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            return;
        } else if (l1.next == null) {
            l1.next = new ListNode(0);
        } else if (l2.next == null) {
            l2.next = new ListNode(0);
        }

        fillNode(l1.next, l2.next);
    }


    private ListNode add(ListNode l1, ListNode l2, int carry) {
        ListNode result = new ListNode(0);

        int nextjinwei = 0;
        int val = l1.val + l2.val + carry;
        if (val >= 10) {
            val = val - 10;
            nextjinwei = 1;
        }

        result.val = val;

        if (l1.next != null) {
            result.next = add(l1.next, l2.next, nextjinwei);
        } else if (nextjinwei == 1) {
            result.next = new ListNode(1);
        }

        return result;
    }
}
