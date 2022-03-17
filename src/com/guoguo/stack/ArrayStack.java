package com.guoguo.stack;

import com.guoguo.array.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public void push(E item) {
        this.array.addLast(item);
    }

    @Override
    public E pop() {
        return this.array.removeLast();
    }

    @Override
    public E peek() {
        return this.array.getLastEl();
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ");
        sb.append("[");
        for (int i = 0; i < this.array.getSize(); i++) {
            sb.append(this.array.getEl(i));
            if(i != this.array.getSize() - 1){
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
