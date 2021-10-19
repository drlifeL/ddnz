package xyz.flyly.other;


import java.util.Arrays;

public class Main {
    private String name;

    public static void main(String[] args) {
//        new Main().sayHi("Hello");
//        int n = 5;
//        System.out.println(Integer.toBinaryString((int) Math.pow(2, 1) - 1));
//        System.out.println();
//        System.out.println();
        int[] arr = new int[]{2, 3, 9, 8, 43, 234, 12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println(midSearch(arr, 234));
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
        return  -1;
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i != j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
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
