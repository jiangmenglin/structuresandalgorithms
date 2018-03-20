package com.jml.saa.sort;

/**
 * 冒泡排序算法
 * @Author: jml
 * @Date: 18-3-20
 * @Description:
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * @param a
     */
    public static void bubble_sort1(int[] a) {
        int i, j;
         for (i = a.length - 1;i > 0;i--) {
             //将a[0...i]中最大的数据放到末尾
             for (j = 0;j < i;j++) {
                 if (a[j] > a[j+1]) {
                     int temp = a[j+1];
                     a[j+1] = a[j];
                     a[j] = temp;
                 }
             }
         }
    }

    /**
     * 改进版冒泡排序
     * @param a
     */
    public static void bubble_sort2(int[] a) {
        int i, j, flag;
        for (i = a.length -1;i > 0;i--) {
            flag = 0;
            for (j = 0;j < i;j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.println("before sort:");
        for (int item:a
             ) {
            System.out.printf("%d ", item);
        }
        System.out.println();
//        bubble_sort1(a);
        bubble_sort2(a);
        System.out.println("after sort:");
        for (int item:a
             ) {
            System.out.printf("%d ", item);
        }
    }
}
