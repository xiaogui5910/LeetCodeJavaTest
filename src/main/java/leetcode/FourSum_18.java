package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class FourSum_18 {
    public List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length - 3; i++) {
            int num1 = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }
            int max1 = nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                int num2 = nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) {
                    break;
                }
                int max2 = nums[i] + nums[j] + nums[length - 1] + nums[length - 2];
                if (max2 < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = num1 + num2 + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(num1, num2, nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public void test() {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0, 0, 0, 0};
        int target = 0;
        Utils.printArr(this.getClass().getSimpleName(), nums);
        List<List<Integer>> list = solution(nums, target);
        Utils.printNum(this, list);
    }
}
