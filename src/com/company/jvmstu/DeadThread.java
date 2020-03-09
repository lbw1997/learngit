package com.company.jvmstu;

public class DeadThread {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName()+"开始");
            Dead dead = new Dead();
            System.out.println(Thread.currentThread().getName()+"结束");
        };
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}
class Dead {
    static {
         if (true) {
             System.out.println(Thread.currentThread().getName()+"初始化该类");
             while (true) {}
         }
    }
}
