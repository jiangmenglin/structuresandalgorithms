package com.jml.saa.link;

/**
 * @Author: jml
 * @Date: 18-3-17
 * @Description:
 */
public class DoubleLink<T> {
    //表头
    private DNode<T> mHead;
    //节点个数
    private int mCount;

    public DoubleLink() {
        mHead = new DNode(null, null, null);
        mHead.prev = mHead.next = mHead;
        mCount = 0;
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    private DNode<T> getNode(int index) {
        if(index < 0 ||  index >= mCount) {
            throw new IndexOutOfBoundsException();
        }

        //正向查找
        if (index <= mCount/2) {
            DNode<T> node = mHead.next;
            for (int i = 0;i < index;i++){
                node = node.next;
            }
            return node;
        }

        //反向查找
        DNode<T> rnode = mHead.prev;
        int rindex = mCount - index -1;
        for (int j = 0;j < index;j++){
            rnode = rnode.prev;
        }
        return rnode;
    }

    public T get(int index){
        return getNode(index).value;
    }

    public T getFirst() {
        return getNode(0).value;
    }

    public T getLast() {
        return getNode(mCount - 1).value;
    }

    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> node = new DNode<>(t, mHead, mHead.next);
            mHead.next.prev = node;
            mHead.next = node;
            mCount++;
            return;
        }

        DNode<T> inode = getNode(index);
        DNode<T> tnode = new DNode<>(t, inode.prev, inode.next);
        inode.next.prev = tnode;
        inode.next = tnode;
        mCount++;
        return;
    }

    public void insertFirst(T t) {
        insert(0, t);
    }

    public void appendLast(T t) {
        DNode<T> node = new DNode<>(t, mHead.prev, mHead);
        mHead.prev.next = node;
        mHead.prev = node;
        mCount++;
    }

    public void del(int index) {
        DNode<T> inode = getNode(index);
        inode.prev.next = inode.next;
        inode.next.prev  = inode.prev;
        inode = null;
        mCount--;
    }

    public void delFirst() {
        del(0);
    }

    public void delLast() {
        del(mCount - 1);
    }

    //双向链表节点对应的结构体
    private class DNode<T> {
        public DNode prev;
        public DNode  next;
        public T value;

        public DNode(T value, DNode prev, DNode next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
