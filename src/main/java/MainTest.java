import leetcode.SingleNumberExtension;
import leetcode.SingleNumber_136;
import sort.*;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("hello world!");

        new SingleNumber_136().test();

        new SingleNumberExtension().test();

        new BubbleSort().test();

        new SelectionSort().test();

        new InsertSort().test();

        new ShellSort().test();

        new MergeSort().test();

        new QuickSort().test();

//        reviewSort();
    }

    private static void reviewSort() {
        int[] arr = {2, 6, 4, 1, 8, 7, 3, 5};
        SortUtils.printArr("maintest", arr);
//        bubble(arr);
//        selection(arr);
//        insert(arr);
//        shell(arr);
        merge(arr);
        SortUtils.printArr("maintest", arr);
    }

    private static void merge(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, 0, arr.length - 1, tempArr);
    }

    private static void sort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, tempArr);
        sort(arr, mid + 1, right, tempArr);

        mergeArr(arr, left, right, mid, tempArr);
    }

    private static void mergeArr(int[] arr, int left, int right, int mid, int[] tempArr) {
        //左指针
        int i = left;
        //右指针
        int j = mid + 1;
        //临时指针
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[t++] = arr[i++];
            } else {
                tempArr[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            tempArr[t++] = arr[i++];
        }

        while (j <= right) {
            tempArr[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = tempArr[t++];
        }
    }

    private static void shell(int[] arr) {
        //增量
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            //分组排序
            for (int i = increment; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - increment;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + increment] = arr[j];
                    j -= increment;
                }
                arr[j + increment] = temp;
            }
        }
    }

    private static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void bubble(int[] arr) {
        //是否有序，默认无序，需要交换
        boolean isSwap = true;
        for (int i = 0; i < arr.length && isSwap; i++) {
            isSwap = false;
            for (int j = arr.length - 1 - 1; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
