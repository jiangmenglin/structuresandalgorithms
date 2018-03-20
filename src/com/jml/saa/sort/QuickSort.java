package com.jml.saa.sort;

/**
 * 快速排序
 * @Author: jml
 * @Date: 18-3-20
 * @Description:
 */
public class QuickSort {

    public static void quickSort(int[] a, int l ,int r) {
        if (a == null || a.length == 0)
            return;
        if (l >= r)
            return;

        int i, j , x;
        i = l;
        j = r;
        x = a[i];
        while (i < j) {
            while (i < j && a[j] > x) {
                j--; //从右向左找第一个小于x的数
            }
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] < x)
                i++; //从左向右找第一个大于x的数
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = x;
        quickSort(a, l, i-1);
        quickSort(a, i+1, r);
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50};
        System.out.println("before sort:");
        for (int item : a) {
            System.out.printf("%d ", item);
        }
        quickSort(a, 0, a.length - 1);
        System.out.println("\nafter sort:");
        for (int item : a) {
            System.out.printf("%d ", item);
        }
    }
}
