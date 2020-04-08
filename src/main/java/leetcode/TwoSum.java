package leetcode;

import sort.SortUtils;

import java.util.HashMap;

/**
 * 题目描述
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            } else {
                map.put(delta, i);
            }

        }
        return null;
    }
    public void test(){
        int[] nums= {2, 7, 11, 15};
        SortUtils.printArr(getClass().getSimpleName(),nums);
        int target=9;
        int[] solution = solution(nums, target);
        SortUtils.printArr(getClass().getSimpleName(),solution);
    }
}
