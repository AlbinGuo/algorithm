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
//            throw new IllegalArgumentException("Enqueue fail. queue is full.");
            // 队列元素数量达到总容量一半时进行扩容
            resize(2 * this.capacity);
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
        E ret = this.queue[this.headIndex];
        // 出队后元素置空
        this.queue[this.headIndex] = null;
        // 队首索引向后移动一位
        this.headIndex = (this.headIndex + 1) % this.capacity;
        // 出队后队列元素数量减一
        this.size -= 1;
        // 队列缩容 [队列长度减少到总长度1/4时进行缩容]
        if(this.size <= this.capacity / 4 && this.capacity / 2 != 0){
            this.resize(this.capacity / 2);
        }
        return ret;
    }

    /**
     * 队列扩/缩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newQueue = (E[])new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newQueue[i] = this.queue[(this.headIndex + i) % this.capacity];
        }
        this.capacity = newCapacity;
        this.headIndex = 0;
        this.queue = newQueue;
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
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        System.out.println(queue);
//        LoopQueue<String> q = new LoopQueue<>(5);
//        for (int i = 0; i < q.capacity; i++) {
//            q.enqueue(i+1+"");
//        }
//        q.enqueue(7+"");
//        q.enqueue(8+"a");
//        q.enqueue(9+"a");
//        q.enqueue(10+"a");
//        q.enqueue(11+"a");
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        System.out.println(q);
//        System.out.println(q.getFront());
//        System.out.println(q.getTail());
    }
}
