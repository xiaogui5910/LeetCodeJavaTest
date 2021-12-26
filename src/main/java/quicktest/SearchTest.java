package quicktest;

import sort.Utils;

/**
 * Created by xiaogui on 2021/12/26.
 */
public class SearchTest {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //二分
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //左边有序
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            //右边有序
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Utils.printArr(this.toString(), nums);
        int result = search(nums, 0);
        Utils.printNum(this, result);

    }

}
