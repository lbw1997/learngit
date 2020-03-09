package com.company.jvmstu;

public class ClassInitTest {
    private static int num1 = 1;

    static {
        num1 = 2;
        num2 = 20;
        System.out.println(num1);
        //System.out.println(num2); 报错，非法的前向引用
    }
    private static int num2 = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num1);
        System.out.println(ClassInitTest.num2);
    }
}
