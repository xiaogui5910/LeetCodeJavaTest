package leetcode;

import sort.Utils;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers_29 {
    public int solution(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvr = Math.abs((long) divisor);

        int result = 0;
        while (dvd >= dvr) {
            long temp = dvr;
            long multiple = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            result += multiple;
        }
        return (dividend < 0) ^ (divisor < 0) ? -result : result;
    }

    public void test() {
        int dividend = 22;
        int divisor = 3;
        Utils.printNum(this, "dividend=" + dividend + ",divisor=" + divisor);
        int result = solution(dividend, divisor);
        Utils.printNum(this, result);
    }
}
