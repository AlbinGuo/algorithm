package com.guoguo.leetcode;

/**
 * 反转链表
 */
public class ReverseLinkedListElement206 {

    public ListNode reverseElements(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode res = reverseElements(head.next); // 1,2 -> 2,1
        head.next.next = head;
        head.next = null;
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode list = new ListNode(arr);
//        System.out.println(list);
        ListNode nodeList = new ReverseLinkedListElement206().reverseElements(list);
        System.out.println(nodeList);
    }
}
