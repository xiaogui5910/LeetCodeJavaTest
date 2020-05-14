package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum_15 {
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //数组已排序，如果当前元素大于0，则后续元素大于当前元素，则sum>0
            if (nums[i] > 0) {
                break;
            }
            //去掉重复计算的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    //添加结果
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //简写
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
//                    //左边去重
//                    while (left < right && nums[left] == nums[left + 1]) {
//                        left++;
//                    }
//                    //右边去重
//                    while (left < right && nums[right] == nums[right - 1]) {
//                        right--;
//                    }
//                    left++;
//                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Utils.printArr(this.getClass().getSimpleName(), nums);
        List<List<Integer>> result = solution(nums);
        Utils.printNum(this, result);
    }
}
