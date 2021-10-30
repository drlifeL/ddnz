package xyz.flyly.other;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class TwoThreadPrint {
    volatile int flag = 0;

    public static void main(String[] args) throws Exception {

        Unsafe unsafe = getUnsafe();

        TwoThreadPrint print = new TwoThreadPrint();

        long offset = unsafe.objectFieldOffset(TwoThreadPrint.class.getDeclaredField("flag"));


        List<Character> list1 = Arrays.asList('a', 'b', 'c', 'd');
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);


        Thread t1 = new Thread(() -> {
            int i = 0;
            while (true) {
                if (unsafe.compareAndSwapInt(print, offset, 0, 1)) {
                    System.out.print(list1.get(i++));
                    if (i == list1.size()) break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            int j = 0;
            while (true) {
                if (unsafe.compareAndSwapInt(print, offset, 1, 0)) {
                    System.out.print(list2.get(j++));
                    if (j == list2.size()) break;

                }
            }
        });

        t1.start();
        t2.start();
    }

    private static Unsafe getUnsafe() {
        try {
            Class<?> clazz = Class.forName("sun.misc.Unsafe");
            Field field = clazz.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }


    private static void waitAndNotify() throws Exception {
        Object o = new Object();
        List<Character> list1 = Arrays.asList('a', 'b', 'c', 'd');
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);


        Thread t1 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < list1.size(); i++) {
                    System.out.print(list1.get(i));
                    o.notifyAll();
                    try {
                        if (i != list1.size() - 1)
                            o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < list2.size(); i++) {
                    System.out.print(list2.get(i));
                    o.notifyAll();
                    try {
                        if (i != list2.size() - 1)
                            o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(1000);

    }
}
