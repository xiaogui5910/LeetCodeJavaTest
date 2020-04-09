package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    private void bucketSortSolution(int[] arr) {
        //数组内最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int value : arr) {
            if (max < value) {
                max = value;
            }
            if (min > value) {
                min = value;
            }
        }

        //计算桶的数量
        int bucketNum = (max - min) / arr.length + 1;

        //创建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将原数组元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length;
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶内进行排序,重新排序原数组
        int index = 0;
        for (ArrayList<Integer> bucket : bucketArr) {
            //桶内没有数据就跳过
            if (bucketArr.size() <= 0) {
                continue;
            }
            //可以使用api排序或者插入排序之类的
            Collections.sort(bucket);
            //桶内数字取出到原数组
            for (int value : bucket) {
                arr[index++] = value;
            }
        }

    }

    public void test() {
        int[] testArr = {1, 6, 0, 1, 3, 8, 9, 3, 7, 3, 1, 3, 2, 4, 7, 5};
        Utils.printArr(this.getClass().getSimpleName(), testArr);

        bucketSortSolution(testArr);
        Utils.printArr(this.getClass().getSimpleName(), testArr);
    }
}
