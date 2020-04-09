package sort;

public class CountSort {
    private void countSortSolution(int[] arr) {
        //找到数组内最大和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        //有了最大值和最小值能够确定中间数组的长度
        int len = max - min + 1;
        int[] countArr = new int[len];

        //统计出现的次数
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }

        int index = 0;
        //遍历数组，排序
        for (int i = 0; i < countArr.length; i++) {
            //根据次数写入数组
            while (countArr[i]-- > 0) {
                //原来减少了min现在加上min，值就变成了原来的值
                arr[index++] = i + min;
            }
        }
    }

    public void test() {
        int[] testArr = {1, 6, 0, 1, 3, 8, 9, 3, 7, 3, 1, 3, 2, 4, 7, 5};
        Utils.printArr(this.getClass().getSimpleName(), testArr);

        countSortSolution(testArr);
        Utils.printArr(this.getClass().getSimpleName(), testArr);
    }


}
