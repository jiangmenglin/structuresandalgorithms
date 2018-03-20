package com.jml.saa.bstree;

/**
 * @Author: jml
 * @Date: 18-3-20
 * @Description:
 */
public class BSTreeTest {
    private static final int arr[] = {1, 5, 4, 3, 2, 6};

    public static void main(String[] args) {
        int i, ilen;
        BSTree<Integer> tree = new BSTree<>();

        System.out.println("== 依次添加：");
        ilen = arr.length;
        for (i = 0;i < ilen;i++) {
            System.out.println(arr[i] + " ");
            tree.insert(arr[i]);
        }

        System.out.println("\n == 前序遍历：");
        tree.preOrder();
        System.out.println("\n == 后序遍历：");
        tree.postOrder();
        System.out.println("\n == 中序遍历");
        tree.inOrder();
        System.out.println();

        System.out.println("\n==最小值：" + tree.minimum());
        System.out.println("\n ==最大值是：" + tree.maximum());
        System.out.println("\n==树的详细信息：");
        tree.print();
        System.out.println("\n==删除节点：" + arr[3]);
        System.out.println("\n==中序遍历：");
        tree.inOrder();
        System.out.println("destroy this tree");
        tree.clear();

    }
}
