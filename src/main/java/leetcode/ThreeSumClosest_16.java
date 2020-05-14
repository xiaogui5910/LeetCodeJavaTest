package leetcode;

import sort.Utils;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_16 {
    public int solution(int[] nums, int target) {
        int sum = 0;
        int delta = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDelta = Math.abs(currentSum - target);
                if (currentDelta == 0) {
                    return currentSum;
                }
                if (currentDelta < delta) {
                    delta = currentDelta;
                    sum = currentSum;
                }
                if (currentSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return sum;
    }

    public void test() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Utils.printArr(this.getClass().getSimpleName(), nums);
        int result = solution(nums, target);
        Utils.printNum(this, result);
    }
}
