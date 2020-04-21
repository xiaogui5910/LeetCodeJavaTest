package leetcode;

import sort.Utils;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * ps:“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 *
 */
public class PalindromeString_125 {
    public boolean solution(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        Utils.printNum(this, s);
        boolean result = solution(s);
        Utils.printNum(this, result);
    }
}
