package leetcode;

import sort.Utils;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary_67 {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;//进位
        //只要有一个数组中还有元素
        while (lenA >= 0 || lenB >= 0) {
            //char类型的'1'和'0'，相差1
            carry += lenA >= 0 ? a.charAt(lenA--) - '0' : 0;
            carry += lenB >= 0 ? b.charAt(lenB--) - '0' : 0;

            //2%2=0，1%2=1
            sb.append(carry % 2);

            //重置carry
            carry /= 2;
        }
        //处理最后一位carry==1情况
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public void test() {
        String a = "11";
        String b = "1";
        Utils.printNum(this, "a=" + a + ",b=" + b);
        String result = solution(a, b);
        Utils.printNum(this, result);
    }
}
