package com.guoguo.linklist;

/**
 * @Desc 链表
 * add ： 通过设定index索引的方式添加节点
 * @param <E>
 */
public class LinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return this.size;
    }

    // 链表是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    // 向链表中添加元素, index从0开始
    public void add(int index, E e){
        if(index <= 0 || index > this.size){
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        // 获取要插入索引位置前一项的Node信息
        // 头节点是从索引为0的Node开始遍历的
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);
        this.size += 1;
    }

    // 链表头部添加新元素
    public void addFirst(E e){
        head = new Node(e, null);
        this.size += 1;
    }

    // 链表尾部添加元素
    public void addLast(E e){
        this.add(this.size, e);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<Integer>();
        linkedList.addFirst(1);
        linkedList.add(1, 2);
        linkedList.addLast(3);
        System.out.println(linkedList);
    }


}
