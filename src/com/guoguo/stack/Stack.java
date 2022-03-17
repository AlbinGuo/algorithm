package com.guoguo.stack;

public interface Stack<E> {
    // 入栈
    void push(E item);

    // 出栈
    E pop();

    // 查看栈顶元素
    E peek();

    // 获取栈内元素个数
    int getSize();

    // 栈是否为空
    boolean isEmpty();

}
