package sort;

import java.util.ArrayList;

public class RadixSort {
    private void radixSortSolution(int[] arr) {
        //取数组内最大元素位数
        int maxDigit = getMaxDigit(arr);

        //分组，创建桶
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }

        //将数组元素添加到桶中
        for (int i = 0, factor = 1; i < maxDigit; i++, factor *= 10) {
            //LSD从低位到高位存入
            for (int value : arr) {
                int index = (value / factor) % factor;
                list.get(index).add(value);
            }

            //根据存入桶内的数字，重新排序原数组
            int j = 0;
            for (ArrayList<Integer> data : list) {
                //如果一个桶内有数据，或多个数据时，取出赋值给原数组
                while (!data.isEmpty()) {
                    arr[j] = data.get(0);
                    data.remove(0);
                    j++;
                }
            }
        }
    }
    public void test() {
        int[] testArr = {421,240,35,532,305,430,124};
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);

        radixSortSolution(testArr);
        SortUtils.printArr(this.getClass().getSimpleName(), testArr);
    }

    private int getMaxDigit(int[] arr) {
        int maxLen = 0;
        for (int i : arr) {
            int length = Integer.toString(i).length();
            maxLen = maxLen > length ? maxLen : length;
        }
        return maxLen;
    }
}
