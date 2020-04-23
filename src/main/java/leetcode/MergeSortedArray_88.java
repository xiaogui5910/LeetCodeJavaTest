package leetcode;

import sort.Utils;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray_88 {
    public void solution(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int index = 0;
        int[] result = new int[nums1.length];
        while (left < m && right < n) {
            //左边nums1元素小于或等于右边nums2元素
            if (nums1[left] <= nums2[right]) {
                result[index++] = nums1[left++];
            }
            //左边nums1元素大
            else if (nums1[left] > nums2[right]) {
                result[index++] = nums2[right++];
            }
        }
        //添加左边nums1剩余元素
        while (left < m) {
            result[index++] = nums1[left++];
        }
        //添加右边nums2剩余元素
        while (right < n) {
            result[index++] = nums2[right++];
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public void solution1(int[] nums1, int m, int[] nums2, int n) {
        //逆序
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] <= nums2[n]) {
                nums1[index--] = nums2[n--];
            } else {
                nums1[index--] = nums1[m--];
            }
        }
        //处理右边nums2剩余元素,左边不用处理
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }


    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        solution1(nums1, m, nums2, n);
        Utils.printArr(this.getClass().getSimpleName(), nums1);
    }

}
