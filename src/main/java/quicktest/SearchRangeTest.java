package quicktest;

import sort.Utils;

/**
 * Created by xiaogui on 2021/12/26.
 */
public class SearchRangeTest {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid;
            } else {
                r = mid - 1;
            }
        }

        if (nums[l] == target) {
            return l;
        }
        return -1;
    }

    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
//        int[] nums = {};
        Utils.printArr(this.toString(), nums);
        int[] result = searchRange(nums, 8);
        Utils.printArr(this.toString(), result);

    }

}
