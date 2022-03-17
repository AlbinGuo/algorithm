package com.guoguo.queue;

import java.util.Arrays;

class LoopQueue<E> implements Queue<E>{

    // 队列
    private E[] queue;
    // 队首索引 [ 可以通过队首索引算出队尾索引：(headIndex + count - 1) % capacity ]
    private int headIndex;
    // 队列长度
    private int size;
    // 队列容量
    private int capacity;

    private LoopQueue(int capacity){
        this.queue = (E[])new Object[capacity];
        this.headIndex = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    private LoopQueue(){
        this(10);
    }

    @Override
    public boolean enqueue(E el) {
        if(this.size == this.capacity){
            throw new IllegalArgumentException("Enqueue fail. queue is full.");
        }
        this.queue[(this.headIndex + this.size) % this.capacity] = el;
        this.size += 1;
        return true;
    }

    @Override
    public E dequeue() {
        if(this.size == 0){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        int currHeadIndex = this.headIndex;
        // 队首索引向后移动一位
        this.headIndex = (currHeadIndex + 1) % this.capacity;
        // 出队后元素置空
        this.queue[currHeadIndex] = null;
        // 出队后队列元素数量减一
        this.size -= 1;
        return this.queue[currHeadIndex];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == this.capacity;
    }

    @Override
    public E getFront() {
        if(this.size == 0){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return this.queue[this.headIndex];
    }

    @Override
    public E getTail() {
        if(this.size == 0){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return this.queue[(this.headIndex + this.size -1) % this.capacity];
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "queue=" + Arrays.toString(queue) +
                ", headIndex=" + headIndex +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        LoopQueue<String> q = new LoopQueue<>(5);
        for (int i = 0; i < q.capacity; i++) {
            q.enqueue(i+1+"");
        }
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(6+"");
        q.enqueue(7+"");
        q.enqueue(8+"a");
        System.out.println(q);
        System.out.println(q.getFront());
        System.out.println(q.getTail());
    }
}
