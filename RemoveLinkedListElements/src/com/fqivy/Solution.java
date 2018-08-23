package com.fqivy;

/**
 * @program: RemoveLinkedListElements
 * @description:
 * @author: fqivy
 * @create: 2018-08-20 16:14
 */

class Solution {
    public ListNode removeElements(ListNode head, int val) {
//      如果头结点等于val
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        new Solution().removeElements(head, 6);
        System.out.println(head);
    }
}
