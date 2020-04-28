package leetcode;

import com.sun.org.apache.xpath.internal.operations.String;
import sort.Utils;

/**
 * 300. 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LongestIncreasingSubsequence_300 {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //定义 dp[i]为考虑前 i个元素，以第 i个数字结尾的最长上升子序列的长度，注意nums[i] 必须被选取。
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int subMaxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    subMaxLen = Math.max(subMaxLen, dp[j]);
                }
            }
            dp[i] = subMaxLen + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 贪心+二分查找
     *
     * @param nums 数组
     * @return 结果
     */
    public int solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //维护一个数组 d[i] ，表示长度为 i的最长上升子序列的末尾元素的最小值，用 len 记录目前最长上升子序列的长度，起始时 len 为 1，d[1]=nums[0]。
        int[] d = new int[nums.length + 1];
        int len = 1;
        d[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int left = 1;
                int right = len;
                int index = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (d[mid] >= nums[i]) {
                        right = mid - 1;
                    } else {
                        index = mid;
                        left = mid + 1;
                    }
                }
                d[index + 1] = nums[i];
            }
        }
        return len;
    }

    /**
     * 贪心+二分查找（学习）
     * @param nums 数组
     * @return 结果
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }
            // 调试方法
            // printArray(nums[i], tail);
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }

    public void test() {
        int[] nums = {4, 10, 4, 3, 8, 9};
        Utils.printArr(this.getClass().getSimpleName(), nums);
        int result = solution1(nums);
        Utils.printNum(this, result);
    }
}
