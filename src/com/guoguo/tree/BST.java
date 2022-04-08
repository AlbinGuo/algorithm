package com.guoguo.tree;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e){
            this.e = e;
        }

        public Node(){
            this(null, null, null);
        }
    }

    private Node root;
    private int size;

    public BST(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    public BST() {
        this(null, 0);
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }


}
