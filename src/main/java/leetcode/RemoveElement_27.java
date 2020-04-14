package leetcode;

import sort.Utils;

public class RemoveElement_27 {
    public int solution(int[] nums, int val) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }

    public void test() {
        int val = 2;
//        int[] nums={3,2,2,3};
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        Utils.printArr(this.getClass().getSimpleName(), nums);
        int len = solution(nums, val);
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print("]");
    }

    public int solution1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
