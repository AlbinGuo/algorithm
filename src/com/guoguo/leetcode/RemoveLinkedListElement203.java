package com.guoguo.leetcode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveLinkedListElement203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        System.out.println(head);
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {6,1,6,2,3,4,6,7,5,6};
        ListNode list = new ListNode(arr);
        System.out.println(list);
        ListNode nodeList = new RemoveLinkedListElement203().removeElements(list, 6);
        System.out.println(nodeList);
    }
}
