package sort;

public class SelectionSort {
    private void seletionSortSolution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                Utils.swap(arr, i, min);
            }

        }
    }

    public void test() {
        int[] testArr = {1, 6, 3, 8, 2, 4, 7, 5};
        Utils.printArr(this.getClass().getSimpleName(), testArr);

        seletionSortSolution(testArr);
        Utils.printArr(this.getClass().getSimpleName(), testArr);
    }
}
