package com.guoguo.array;

/**
 * @author guoguo
 */
public class Array {

    private int[] data;
    private int size;

    public Array(int capacity){
        data = new int[capacity];
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
    public void addFirst(int el){
        this.add(0, el);
    }

    // 在所有元素最后插入元素
    public void addLast(int el){
        this.add(this.size, el);
    }

    // 获取index索引位置元素
    public int getEl(int index){
        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("get failed, Index is illegal.");
        }
        return this.data[index];
    }

    // 修改索引位置的元素
    public void set(int index, int el){
        if(index < 0 || index >= this.size){
            throw new IllegalArgumentException("get faied, Index is Illegal");
        }
        data[index] = el;
    }

    // 在索引位置插入一个新元素
    public void add(int index, int el){
          if(this.size == this.data.length){
              throw new IllegalArgumentException("Add failed, Array is full.");
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
    public boolean contains(int el){
        for (int i = 0; i < this.size; i++) {
            if(el == this.data[i]){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素el所在的索引，如果不存在则返回-1
    public int find(int el){
        for (int i = 0; i < this.size; i++) {
            if(el == this.data[i]){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, Index is illegal");
        }
        int result = this.data[index];
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.size--;
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
    public void removeEl(int el){
        int index = find(el);
        if(index != -1){
            this.remove(index);
        }
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
        Array ar = new Array(10);
//        ar.addFirst(2);
//        ar.addLast(100);
//        ar.addLast(300);
//        ar.addFirst(11);
//        ar.addFirst(1000);
//        ar.set(2, 666);
        for (int i = 0; i < ar.getCapacity() ; i++) {
            ar.addLast(i+1);
        }
        ar.removeEl(5);
        System.out.println(ar.toString());;
    }

}
