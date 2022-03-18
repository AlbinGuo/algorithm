package com.guoguo.linklist;

public class DummyHeadLinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
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
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    // 获取链表中索引为index的元素
    public E get(int index){
        if(index < 0 || index > this.size){
            throw new IllegalArgumentException("Get failed; Illegal index.");
        }
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.e;
    }

    // 获取链表的第一个元素
    public E getFirst(){
        return this.get(0);
    }

    // 获取链表的最后一个元素
    public E getLast(){
        return this.get(this.size - 1);
    }

    // 修改链表中索引为index位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed, Illegal index.");
        }
        // 找出要修改元素对应的Node
        Node curr = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }

    // 查询链表中是否存在某个元素
    public boolean contains(E e){
//        Node curr = this.dummyHead.next;
//        while (curr != null){
//            if(curr.e.equals(e)){
//                return true;
//            }
//            curr = curr.next;
//        }
        for (Node curr = this.dummyHead.next; null != curr; curr = curr.next) {
            if(curr.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    // 从链表的指定index位置删除元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }
        // 查找要删除的元素的前一个元素
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 要删除的元素
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        this.size -= 1;
        return retNode.e;
    }

    // 删除链表中第一个元素
    public E removeFirst(){
        return this.remove(0);
    }

    // 删除链表中最后一个元素
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    // 删除链表中的节点
    public E removeByElement(E e){
        Node prev = null;
        for(prev = this.dummyHead; prev.next!=null; prev = prev.next){
            if(prev.next.e.equals(e)){
                break;
            }
        }
        Node delNode = null;
        if(prev.next != null){
             delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
        return delNode.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node curr = dummyHead.next; curr != null; curr = curr.next) {
            sb.append(curr + "-->");
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> dummyHeadLinkedList = new DummyHeadLinkedList<>();
        dummyHeadLinkedList.addFirst(1);
        dummyHeadLinkedList.add(1, 2);
        dummyHeadLinkedList.addLast(3);
        dummyHeadLinkedList.addLast(4);
        dummyHeadLinkedList.addLast(5);
        System.out.println(dummyHeadLinkedList);
        System.out.println(dummyHeadLinkedList.get(2));
        System.out.println("=====================");
        System.out.println(dummyHeadLinkedList.getFirst());
        System.out.println(dummyHeadLinkedList.getLast());
        dummyHeadLinkedList.set(4, 222);
        System.out.println(dummyHeadLinkedList);
        System.out.println("=====================");
        System.out.println(dummyHeadLinkedList.contains(222));
    }
}
