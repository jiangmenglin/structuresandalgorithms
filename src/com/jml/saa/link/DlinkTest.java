package com.jml.saa.link;

/**
 * @Author: jml
 * @Date: 18-3-17
 * @Description:
 */
public class DlinkTest {

    private static void int_test() {
        int[] iarr = {10, 20, 30, 40};
        System.out.println("\n------int_test------");
        DoubleLink<Integer> dlink = new DoubleLink<>();
        dlink.insert(0, 20);
        dlink.appendLast(10);
        dlink.insertFirst(30);
        //双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        //双向链表的size
        System.out.printf("size()=%d\n", dlink.size());
        //打印出全部节点
        for (int i = 0;i < dlink.size();i++) {
            System.out.println("dlink[" + i + "]=" + dlink.get(i));
        }
    }

    private static void string_test() {
        String[] sarr = {"ten", "twenty", "thirty", "forty"};
        System.out.println("\n------string_test-----");
        DoubleLink<String> dlink = new DoubleLink<>();
        dlink.insert(0, sarr[1]);
        dlink.appendLast(sarr[0]);
        dlink.insertFirst(sarr[2]);
        //双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        //双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());
        //打印出所有节点
        for (int i = 0;i < dlink.size();i++)  {
            System.out.println("dlink(" + i + ")=" + dlink.get(i));
        }
    }

    private static class Student {
        private String name;
        private int id;
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String  toString() {
            return "[" + id + "," + name + "]";
        }

    }

    private static Student[] students = new Student[] {
        new Student(10, "sky"),
        new Student(20, "jody"),
        new Student(30, "vic"),
        new Student(40, "dan")
    };

    private static void object_test() {
        System.out.println("\n-----object_test----");
        DoubleLink<Student> dlink = new DoubleLink<>();
        dlink.insert(0,  students[1]);
        dlink.appendLast(students[3]);
        dlink.insertFirst(students[2]);

        //双向链表是否为空
        System.out.printf("isEmpty()=%b\n", dlink.isEmpty());
        //双向链表的大小
        System.out.printf("size()=%d\n", dlink.size());
        //表里双向链表的节点
        for (int i = 0;i<dlink.size();i++) {
            System.out.println("dlink[" + i + "]=" + dlink.get(i));
        }
    }

    public static void main(String[] args) {
        int_test();
        string_test();
        object_test();
    }
}
