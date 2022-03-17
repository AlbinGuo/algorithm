package com.guoguo.queue;

import com.guoguo.array.Array;

/**
 * @Author guoguo
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E>{

    Array<E> array = null;

    private ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    private ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public boolean enqueue(E el) {
        this.array.addLast(el);
        return true;
    }

    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    @Override
    public int getSize() {
        return this.array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    @Override
    public E getFront() {
        return this.array.getFirstEl();
    }

    @Override
    public E getTail() {
        return this.array.getLastEl();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ Queue: ");
        sb.append("capacity: " + this.array.getCapacity());
        sb.append(", size: " + this.array.getSize());
        sb.append(". front: [");
        for (int i = 0; i < this.array.getSize(); i++) {
            sb.append(this.array.getEl(i));
            if(i != this.array.getSize() - 1){
                sb.append(",");
            }
        }
        sb.append("] tail.}");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                System.out.println(queue.dequeue());
            }
        }
        System.out.println("=="+queue);
        System.out.println(queue.getFront());
        System.out.println(queue.getTail());
    }
}
