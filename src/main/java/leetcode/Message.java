package leetcode;

import sort.Utils;

/**
 * 面试题 17.16. 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 */
public class Message {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return getResult(nums, nums.length, temp);
    }

    private int getResult(int[] nums, int length, int[] temp) {
        if (temp[length - 1] != 0) {
            return temp[length - 1];
        }
        if (length == 1) {
            temp[length - 1] = nums[0];
            return temp[length - 1];
        }
        if (length == 2) {
            temp[length - 1] = Math.max(nums[0], nums[1]);
            return temp[length - 1];
        }
        int m = getResult(nums, length - 2, temp) + nums[length - 1];
        int n = getResult(nums, length - 1, temp);
        temp[length - 1] = Math.max(m, n);
        return temp[length - 1];
    }

    public void test() {
//        int[] nums={1,2,3,1};
//        int[] nums={2,7,9,3,1};
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        Utils.printArr(this.getClass().getSimpleName(), nums);
        int result = solution1(nums);
        Utils.printNum(this, result);
    }

    private int solution1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = dp[i - 2] + nums[i];
            dp[i] = Math.max(dp[i - 1], temp);
        }
        return dp[len - 1];
    }
}
