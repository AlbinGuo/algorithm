package com.guoguo.test;

/**
 * 递归乘法
 */
public class Leetcode578 {

    public int recursiveMulti(int A, int B){
        if(A == 0 || B == 0){
            return 0;
        }
        return B + recursiveMulti(A - 1, B);
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode578().recursiveMulti(2,5));
    }
}
