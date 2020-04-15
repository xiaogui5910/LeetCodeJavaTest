package leetcode;

import sort.Utils;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert_35 {
    public int solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     *
     * @param nums   数组
     * @param target 目标数
     * @return 插入索引
     */
    public int solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;
        while (left <= right) {
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (right + left) / 2;
        }
        return left;
    }

    public void test() {
//        int[] nums={1,3,5,6};
//        int target= 7;
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        Utils.printArr(this.getClass().getSimpleName(), nums);
        Utils.printNum(this, target);
        int index = solution1(nums, target);
        Utils.printNum(this, index);
    }
}
