package sort;

public class ShellSort {
    private void shellSortSolution(int[] arr) {
        //用于交换元素
        int temp = 0;
        int j = 0;
        //确定增量值
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            //按照增量分组
            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];
                //直接插入算法，for循环写法
                for (j = i - increment; j >= 0 && arr[j] > temp; j -= increment) {
                    arr[j + increment] = arr[j];
                }
                arr[j + increment] = temp;
            }
        }

    }

    private void shellSortSolutionWhile(int[] arr) {
        //增量
        for (int increment = arr.length / 2; increment >= 1; increment /= 2) {
            //分组，插入排序while写法
            for (int i = increment; i < arr.length; i++) {
                //记录要插入的值
                int temp = arr[i];
                //和分组后的前一序列数作比较
                int j = i - increment;
                //遍历前一序列数，如果比插入值大就，当前比较数后序列位置后移
                while (j >= 0 && arr[j] > temp) {
                    arr[j + increment] = arr[j];
                    j -= increment;
                }
                arr[j + increment] = temp;
            }
        }

    }

    public void test() {
        int[] testArr = {5, 3, 7, 9, 1, 6, 4, 8, 2};
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);

        shellSortSolution(testArr);
//        shellSortSolutionWhile(testArr);
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);
    }
}
