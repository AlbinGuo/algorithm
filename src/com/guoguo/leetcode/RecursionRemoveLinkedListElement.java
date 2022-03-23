package com.guoguo.leetcode;

/**
 * 递归删除链表中元素
 * @return 返回最终链表
 */
public class RecursionRemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return null;
        }
        ListNode res = removeElements(head.next, val);
        if(head.val == val){
            System.out.println("a");
            return res;
        }else{
            System.out.println("a");
            head.next = res;
            return head;
        }

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new RecursionRemoveLinkedListElement()).removeElements(head, 4);
        System.out.println(res);
    }
}