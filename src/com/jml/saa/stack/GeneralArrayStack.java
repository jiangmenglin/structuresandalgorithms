package com.jml.saa.stack;

import java.lang.reflect.Array;

/**
 * @Author: jml
 * @Date: 18-3-22
 * @Description:
 */
public class GeneralArrayStack<T> {

    private static final int DEFAULT_SIZE = 12;
    private T[] mArray;
    private int count;

    public GeneralArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public GeneralArrayStack(Class<T> type, int size) {
        //这里需要泛型的类型 不能直接new 数组对象
        mArray = (T[]) Array.newInstance(type, size);
        count = 0;
    }

    public void push(T val) {
        mArray[count++] = val;
    }

    public T peek() {
        if (!(count > 0))
            return null;
        return mArray[count - 1];
    }

    public T pop() {
        T tmp = null;
        if (count > 0) {
            tmp = mArray[count - 1];
            count--;
        }
        return tmp;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void print() {
        if (isEmpty())
            System.out.println("stack is empty!");
        System.out.printf("stack size()=%d\n", size());
        int i = size() - 1;
        while (i >= 0) {
            System.out.println(mArray[i]);
            i--;
        }
    }

    public static void main(String[] args) {
        String tmp;
        GeneralArrayStack<String> astack = new GeneralArrayStack<String>(String.class);
        astack.push("10");
        astack.push("20");
        astack.push("30");

        //将栈顶元素 赋值给tmp 并删除栈顶元素
        tmp = astack.pop();
        System.out.println("tmp=" + tmp);

        //只将栈顶元素赋值给tmp,不删除站点元素
        tmp = astack.peek();
        System.out.println("tmp=" + tmp);

        astack.push("40");
        astack.print();
    }
}
