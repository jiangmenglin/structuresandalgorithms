package com.jml.saa.stack;

import java.util.Stack;

/**
 * @Author: jml
 * @Date: 18-3-22
 * @Description:
 */
public class StackTest {

    public static void main(String[] args) {
        int tmp = 0;

        Stack<Integer> astack = new Stack<Integer>();

        astack.push(10);
        astack.push(20);
        astack.push(30);
        astack.push(40);

        tmp = astack.pop();
        System.out.printf("tmp=%d\n", tmp);
        tmp = astack.peek();
        System.out.printf("tmp=%d\n", tmp);

        astack.push(50);
        while (!astack.isEmpty()) {
            System.out.printf("tmp=%d\n", astack.pop());
        }

    }
}
