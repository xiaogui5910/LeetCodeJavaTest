package leetcode;

import sort.Utils;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray_53 {
    public int solution(int[] nums) {
        int max = nums[0];
        int subMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
            } else {
                subMax = nums[i];
            }
            max = Math.max(max, subMax);
        }
        return max;
    }
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        Utils.printArr(this.getClass().getSimpleName(),nums);
        int max = solution(nums);
        Utils.printNum(this,max);
    }
}
