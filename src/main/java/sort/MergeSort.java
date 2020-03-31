package sort;

public class MergeSort {
    private void mergeSortSolution(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int[] tempArr = new int[arr.length];
        sort(arr, left, right, tempArr);
    }

    private void sort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        sort(arr, left, mid, tempArr);

        sort(arr, mid + 1, right, tempArr);

        mergeArr(arr, left, right, mid, tempArr);
    }

    private void mergeArr(int[] arr, int left, int right, int mid, int[] tempArr) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;

        //临时数组存储指针
        int t = 0;

        //左右两边比较
        while (i <= mid && j <= right) {
            //左边的小
            if (arr[i] < arr[j]) {
                tempArr[t++] = arr[i++];
            }
            //右边的小
            else {
                tempArr[t++] = arr[j++];
            }
        }

        //添加左边剩余元素填充进temp中
        while (i <= mid) {
            tempArr[t++] = arr[i++];
        }

        //添加右边剩余元素填充进temp中
        while (j <= right) {
            tempArr[t++] = arr[j++];
        }

        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = tempArr[t++];
        }

    }

    public void test() {
        int[] testArr = {5, 3, 7, 9, 1, 6, 4, 8, 2};
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);

        mergeSortSolution(testArr);
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);
    }
}
