package com.guoguo.linklist;

import com.guoguo.queue.Queue;

/**
 * 链表实现队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

    }

    private Node head, tail;
    private int size;

    @Override
    public boolean enqueue(E el) {
        if(tail == null){
            tail = new Node(el);
            head = tail;
        }else{
            tail.next = new Node(el);
            tail = tail.next;
        }
        this.size += 1;
        return true;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty dequeue.");
        }
        Node retNode = this.head;
        this.head = head.next;
        retNode.next = null;

        if(this.head == null){
            this.tail = null;
        }
        this.size -= 1;
        return retNode.e;
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E getFront() {
        return this.head.e;
    }

    @Override
    public E getTail() {
        return this.tail.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue front: ");
        Node cur = this.head;
//        for(;cur!=null;){
        while(cur != null){
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append(" NULL tail. ");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
