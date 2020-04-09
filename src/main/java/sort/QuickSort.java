package sort;

import java.util.Random;

public class QuickSort {
    private void quickSortSolution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quick(arr, 0, arr.length - 1);
    }

    private void quick(int[] arr, int left, int riht) {
        if (left >= riht) {
            return;
        }
        //随机一个索引
        int index = new Random().nextInt(riht - left + 1);
        //随机元素和最后一个元素交换，也是属于找到一个随机数到最后一位
        Utils.swap(arr, left + index, riht);
        int[] position = partition(arr, left, riht, arr[riht]);
        quick(arr, left, position[0] - 1);
        quick(arr, position[1] + 1, riht);
    }

    private int[] partition(int[] arr, int left, int right, int key) {
        int less = left - 1;
        int more = right + 1;
        int index = left;

        while (index < more) {
            //放到左边
            if (arr[index] < key) {
                Utils.swap(arr, ++less, index++);
            }
            //放到右边
            else if (arr[index] > key) {
                Utils.swap(arr, --more, index);
            }
            //相等放到中间
            else {
                index++;
            }
        }

        return new int[]{(less + 1), (more - 1)};
    }

    public void test() {
        int[] testArr = {5, 4,3, 7, 4,9, 1, 6, 4, 8, 2};
        Utils.printArr(this.getClass().getSimpleName(), testArr);

        quickSortSolution(testArr);
        Utils.printArr(this.getClass().getSimpleName(), testArr);
    }
}
