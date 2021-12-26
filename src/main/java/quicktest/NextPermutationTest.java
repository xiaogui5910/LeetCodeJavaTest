package quicktest;

import sort.Utils;

import java.util.List;

/**
 * Created by xiaogui on 2021/12/26.
 */
public class NextPermutationTest {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        //从后往前，找到相邻的，nums[i-1]<nums[i]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            //从后往前，i到nums.length-1,找到nums[i]<nums[j]
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            //交换i,j
            Utils.swap(nums, i, j);
        }
        Utils.reverse(nums, i + 1);
    }

    public void test() {
        int[] nums = {1, 2, 3, 4, 6, 5};
        Utils.printArr(this.toString(), nums);
        nextPermutation(nums);
        Utils.printArr(this.toString(), nums);

    }


}
