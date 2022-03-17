package com.guoguo.queue;

public interface Queue<E> {
    /** 入队
     * @param el
     * @return
     */
    void enqueue(E el);

    /** 出队
     * @return
     */
    E dequeue();

    /** 队列长度
     * @return
     */
    int getSize();

    /** 队列是否为空
     * @return
     */
    boolean isEmpty();

    /** 查看队首元素
     * @return
     */
    E getFront();

}
