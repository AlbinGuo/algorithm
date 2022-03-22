package com.guoguo.leetcode;

public class ListNode {
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

    ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr cannot null or empty.");
        }
        // 构造头节点数据
        this.val = arr[0];
        ListNode curr = this;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        sb.append("ListNode head: ");
        for(; curr!=null ;){
            sb.append(curr.val + "->");
            curr = curr.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
