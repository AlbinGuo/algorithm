package com.guoguo.array;

import com.guoguo.array.dto.Student;

/**
 * @author guoguo
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    // 获取数组容量
    public int getCapacity(){
        return this.data.length;
    }

    // 获取数组的元素个数
    public int getSize(){
        return this.size;
    }

    // 数组是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }

    // 在所有元素之前添加一个元素
    public void addFirst(E el){
        this.add(0, el);
    }

    // 在所有元素最后插入元素
    public void addLast(E el){
        this.add(this.size, el);
    }

    // 获取index索引位置元素
    public E getEl(int index){
        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("get failed, Index is illegal.");
        }
        return this.data[index];
    }

    // 修改索引位置的元素
    public void set(int index, E el){
        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("get faied, Index is Illegal");
        }
        data[index] = el;
    }

    // 在索引位置插入一个新元素
    public void add(int index, E el){
          if(this.size == this.data.length){
              // throw new IllegalArgumentException("Add failed, Array is full.");
              // 数组扩容
              this.resize(2 * this.data.length);
          }

          if(index < 0 || index > size) {
              throw new IllegalArgumentException("Add failed, Required index >= 0 and index <= size.");
          }

         for (int i = size - 1; i >= index; i--) {
             this.data[i+1] = this.data[i];
         }
        this.data[index] = el;
        this.size++;
    }

    // 查找数组中是否存在元素el
    public boolean contains(E el){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(el)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素el所在的索引，如果不存在则返回-1
    public int find(E el){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i].equals(el)){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        E result = this.data[index];
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
        this.data[size] = null; // loitering objects
        // 数组缩容 [ 除以4表示size达到length的1/4时进行缩容，lazy模式 ]
        if(this.size == this.data.length / 4 && this.data.length / 2 != 0){
            this.resize(this.data.length / 2);
        }
        return result;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public void removeFirst(){
        this.remove(0);
    }

    // 从数组中删除最后一个元素， 返回删除的元素
    public void removeLast(){
        this.remove(this.size - 1);
    }

    // 从数组中删除元素
    public void removeEl(E el){
        int index = find(el);
        if(index != -1){
            this.remove(index);
        }
    }

    // 数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: capacity = %d , size = %d\n", this.getCapacity(), this.size));
        sb.append("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.data[i]);
            if(i != this.size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
//        Array<String> ar = new Array<>(10);
//        for (int i = 0; i < ar.getCapacity() ; i++) {
//            ar.addLast(i+"aa");
//        }
//        System.out.println(ar.remove(3));
//        System.out.println(ar);

        Array<Student> studentArray = new Array<>(2);
        Student stu1 = new Student(10, "子龙", 56);
        Student stu2 = new Student(10, "关羽", 49);
        Student stu3 = new Student(10, "刘备", 46);
        Student stu5 = new Student(10, "司马懿", 77);
        studentArray.addLast(stu1);
        studentArray.addLast(stu2);
        studentArray.addLast(stu3);
        studentArray.addFirst(stu5);
        studentArray.addFirst(stu5);
        studentArray.addFirst(stu5);
        studentArray.addFirst(stu5);
        studentArray.addFirst(stu5);
        studentArray.addFirst(stu5);
        System.out.println(studentArray);
    }

}
