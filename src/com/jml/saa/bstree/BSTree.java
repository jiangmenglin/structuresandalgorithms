package com.jml.saa.bstree;

import java.util.Comparator;

/**
 * @Author: jml
 * @Date: 18-3-17
 * @Description:
 */
public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot;       //root节点

    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /*
    前序遍历
     */
    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
    中序遍历
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key+" ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /*
    后序遍历
     */

    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /*
    递归实现查找二叉树中键值为key的结点
     */
    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
    非递归版本的查找
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else return x;
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;
        //查找z的插入位置
        while(x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        if (y == null)
            bst.mRoot = z;
        else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    public void insert(T key) {
        BSTNode<T> z = new BSTNode<>(key, null, null, null);
        //如果新建节点失败，则返回
        if (z != null)
            insert(this, z);
    }

    //查找最小值
    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    //叉查找后继节点
    public BSTNode<T> successor(BSTNode<T> x) {
        //如果x存在右孩子，则x的后继节点为以右孩子为根的最小节点
        if (x.right != null)
            return minimum(x.right);

        //如果x没有右孩子。则有以下两种可能
        //x是一个左孩子，则x的后继节点为他的父节点
        //x是一个左孩子，则查找x的最低父节点，并且该父节点要具有左孩子，找到的这个最低的父节点就是x的后继节点
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /*
    找节点x的前驱节点  即查找二叉树中数据值小鱼该节点的最大节点
     */
    public BSTNode<T> predecessor(BSTNode<T> x) {
        //如果存在左孩子，则x的前驱节点为 以其右孩子为根的子树的最大 节点
        if (x.left != null)
            return maximum(x.left);

        //如果x没有左孩子 则x有以下两种可能
        //x是一个右孩子 则x的前驱节点为他的父节点
        //x是一个左孩子 则查找x的最低的父节点 并且该父节点要具有右孩子 找到这个最低的父节点就是x的前驱节点
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x =y;
            y = y.parent;
        }
        return y;
    }

    /*
    查找最大节点 返回tree为根节点的二叉树的最大结点
     */
    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    /*
    二叉树的最大值
     */
    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;
        return null;
    }

    /*
    删除结点
     */

    /**
     *
     * @param bst 二叉树
     * @param z 被删除的结点
     * @return
     */
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x = null;
        BSTNode<T> y = null;

        if ((z.left == null) || (z.right == null)) {
            y = z;
        }
        else
            y = successor(z);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            bst.mRoot = x;
        else if (y == y.parent)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z)
            z.key = y.key;
        return y;
    }

    /**
     * 删除结点
     * @param key
     * @return
     */
    public void remove(T key) {
        BSTNode<T> z, node;
        if ((z = search(mRoot, key)) != null)
            if ((node = remove(this, z)) != null)
                node = null;
    }

    //打印二叉树

    /**
     *
     * @param tree
     * @param key 节点的值
     * @param direction 0 表示结点是根节点 -1表示该节点是他的父节点的左孩子 1 表示是他的父节点的右孩子
     */
    private void print(BSTNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0) {
                System.out.printf("%2d is root\n", tree.key);
            }else {
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1?"right" : "left");
            }
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    //销毁二叉树
    private void destroy(BSTNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }
}
