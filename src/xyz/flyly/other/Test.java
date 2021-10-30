package xyz.flyly.other;

import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String[] args) throws Exception {
//        testParkAndUnPark();

        testAb();

    }

    public static void testAb() {

        Thread t2 = new Thread(() -> {
            System.out.println("t2 上锁");
            LockSupport.park();
            System.out.println("t2 继续运行");
        });

        Thread t1 = new Thread(() -> {
            LockSupport.unpark(t2);
            System.out.println("t1 解锁完毕");
        });

        t2.start();
        t1.start();

        System.out.println("主线程 ok !");

    }


    public static void testParkAndUnPark() throws Exception {

        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();

        t1.start();
//        t2.start();

        Thread.sleep(500);

        LockSupport.unpark(t1);
        System.out.println("un park");
        Thread.sleep(500);


    }

    static class MyThread extends Thread {
        @Override
        public void run() {
//            synchronized (MyThread.class) {
            System.out.println(Thread.currentThread().getName() + " 获得锁!");
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
            System.out.println(Thread.currentThread().getName() + "继续运行");
//            }
        }
    }
}
