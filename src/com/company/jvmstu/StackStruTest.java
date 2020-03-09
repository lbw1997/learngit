package com.company.jvmstu;

public class StackStruTest {
    public static void main(String[] args) {
        //int i = 2+3;
        int i = 2;
        int j = 3;
        int k = i+j;
        /*try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("hello");
        StackStruTest s1 = new StackStruTest();
        Integer s2 = new Integer(1);
        System.out.println(s1.getClass().getClassLoader());
        System.out.println(s2.getClass().getClassLoader());
    }
}
