package sort;

public class InsertSort {
    private void insertSortSolution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (i != j) {
                arr[j] = temp;
            }

        }

    }

    public void test() {
        int[] testArr = {1, 6, 3, 8, 2, 4, 7, 5};
        SortUtils.printArr(this.getClass().getSimpleName(),testArr);

        insertSortSolution(testArr);
        SortUtils.printArr(this.getClass().getSimpleName(),testArr);
    }
}
