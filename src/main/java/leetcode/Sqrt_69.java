package leetcode;

import sort.Utils;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrt_69 {
    public int solution(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x / 2;
        int mid;
        long num;
        while (left <= right) {
            mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if (num > x) {
                right = mid - 1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    /**
     * 牛顿法
     *
     * @param x 数字
     * @return 结果
     */
    public int solution1(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }


    public void test() {
        int x = 2147395599;
        Utils.printNum(this, x);
        int result = solution(x);
        Utils.printNum(this, result);
    }

}
