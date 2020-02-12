package com.company.collection;

import java.util.Vector;
import java.util.function.Consumer;

public class VectorTest {
    private static Vector<String> v;
    //第一种循环方法
    public static void vectorCircle1() {
        System.out.print("第一种循环方法");
        for(String string :v) {
            System.out.print(string+" ");
        }
    }
    //第二种循环方法，JDK8中功能，给定一个参数，对其进行处理，处理可以是任意操作
    public static void vectorCircle2() {
        System.out.print("第二种循环方法");
        v.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
    }
    public static void main(String[] args) {
        v = new Vector<>();
        v.add("a");
        v.add("b");
        v.add("c");
        v.add("d");
        v.add("e");
        vectorCircle1();
        vectorCircle2();
    }
}
