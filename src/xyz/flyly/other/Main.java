package xyz.flyly.other;


import xyz.flyly.leetcode.utils.ListNode;

public class Main {
    private String name;

    public static void main(String[] args) throws InterruptedException {
//        new Main().sayHi("Hello");
//        int n = 5;
//        System.out.println(Integer.toBinaryString((int) Math.pow(2, 1) - 1));
//        System.out.println();
//        System.out.println();
//        int[] arr = new int[]{2, 3, 9, 8, 43, 234, 12};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(midSearch(arr, 8));
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Integer.toBinaryString((int) Math.pow(2, i)));
//            System.out.println(Integer.toBinaryString((int) Math.pow(2, i) - 1));
//        }

//        Mutex m = new Mutex();
//
//        ReentrantLock r = new ReentrantLock();
////        r.lock();
//
//        Thread t1 = new Thread(() -> {
//            r.lock();
//            try {
//
//            } finally {
//                r.unlock();
//            }
//        });
//        t1.start();
//        Thread.sleep(1000000);
//
//        try {
//            System.out.println("ajajaj");
//        } finally {
//            r.unlock();
//        }
//        Thread t = new Thread(() -> {
//            m.lock();
//            try {
//                System.out.println(Thread.currentThread().getName() + " ok!");
//            } finally {
//                m.unlock();
//            }
//        });
//        Thread t1 = new Thread(() -> {
//            m.lock();
//            try {
//                System.out.println(Thread.currentThread().getName() + " ok!");
//            } finally {
//                m.unlock();
//            }
//        });
//        t1.start();
//        t.start();
//        Thread.sleep(1000);

//        Object a = new Object();
//        new Thread(() -> {
//
//            synchronized (a) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + " - 获得锁");
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//
//        }).start();
//        new Thread(() -> {
//            synchronized (a) {
//                try {
//                    System.out.println(Thread.currentThread().getName() + " - 获得锁");
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        Thread.sleep(1500);
        ListNode node = ListNode.createListNode(1, 8);
        ListNode.printListNode(node);
        ListNode f1 = f1(node);
        ListNode.printListNode(f1);


    }

    public static int midSearch(int[] arr, int target) {
        int left = 0;
        int mid;
        int right = arr.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i != j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            while (i < j && arr[i] <= temp) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static ListNode f1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode headNode = f1(head.next);
        head.next = null;
        nextNode.next = head;
        return headNode;
    }

    public void sayHi(String name) {
        new InnerClass().setName(name);
        System.out.println(this.name);
    }

    class InnerClass {

        private void setName(String sName) {
            name = sName;
        }
    }
}
