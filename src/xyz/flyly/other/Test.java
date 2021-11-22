package xyz.flyly.other;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

public class Test {
    public static void main(String[] args) throws Exception {
//        testParkAndUnPark();

//        testAb();

        class A {
            public int val;
        }
        A a = new A();
        Unsafe unsafe = getUnsafe();
        // 先拿到 val 在 A 对象的偏移量
        long offset = unsafe.objectFieldOffset(a.getClass().getField("val"));
        // 调用 CAS 方法来设置变量
        System.out.println("更改前：" + a.val);
        unsafe.compareAndSwapInt(a, offset, 0, 1);
        System.out.println("更改后：" + a.val);

    }

    private static Unsafe getUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
