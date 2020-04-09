package sort;

public class BubbleSort {
    private void bubbleSortSolution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        boolean isSwap = true;
        for (int i = arr.length - 1; i >= 0 && isSwap; i--) {
            isSwap = false;
            //相邻两个比较,j >= arr.length - 1 - i + 1条件可以去除数组前面已经排过序的元素
            for (int j = arr.length - 1; j >= arr.length - 1 - i + 1; j--) {
                //前一个比后一个大，则交换他们
                if (arr[j - 1] > arr[j]) {
                    Utils.swap(arr, j - 1, j);
                    //剩下元素还需要交换位置，则isSwap =true;，如果不需要交换位置则不需要继续进行比较了
                    isSwap = true;
                }
            }
        }
    }

    private void bubbleSortSolution1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        boolean isSwap = true;
        for (int i = 0; i < arr.length && isSwap; i++) {
            isSwap = false;
            for (int j = arr.length - 1 - 1; j >= i; j--) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                    isSwap = true;
                }
            }
        }
    }

    public void test() {
        int[] testArr = {1, 6, 3, 8, 2, 4, 7, 5};
        Utils.printArr(this.getClass().getSimpleName(),testArr);

        bubbleSortSolution(testArr);
//        bubbleSortSolution1(testArr);
        Utils.printArr(this.getClass().getSimpleName(),testArr);
    }

}
