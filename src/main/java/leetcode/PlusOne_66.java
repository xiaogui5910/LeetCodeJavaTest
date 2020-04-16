package leetcode;

import sort.Utils;

import java.util.Collections;

/**
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne_66 {
    /**
     * 数字比较小的情况下可以通过，数字大了就越界出错了
     *
     * @param digits 数字
     * @return 结果
     */
    public int[] solution(int[] digits) {
        long sum = 0;
        for (int i = digits.length - 1, p = 1; i >= 0; i--, p *= 10) {
            long digit = digits[i];
            sum += digit * p;
        }
        sum += 1;
        int len = String.valueOf(sum).length();
        int[] result = new int[len];
        for (int i = len - 1, p = 1; i >= 0; i--, p *= 10) {
            long digit = sum / p % 10;
            result[i] = (int) digit;
        }
        return result;
    }

    public int[] solution1(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                flag = true;
                break;
            }
            digits[i] = 0;
        }
        //digits元素都是9的情况
        if (!flag) {
            int[] result = new int[digits.length + 1];
            //其中第一个元素设置值为1，其他默认不设置，都为0
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public void test() {
//        int[] digits = {1, 2, 3};
//        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] digits = {9, 9, 9};
        Utils.printArr(this.getClass().getSimpleName(), digits);
        int[] result = solution1(digits);
        Utils.printArr(this.getClass().getSimpleName(), result);
    }
}
