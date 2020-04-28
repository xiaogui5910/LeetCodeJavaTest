package leetcode;

import sort.Utils;

/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_5 {
    public String solution(String s) {
        String longest = "";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i + j <= s.length()) {
                    String t = s.substring(j, i + j);
                    if (isPalindromeString(t)) {
                        longest = longest.length() > t.length() ? longest : t;
                    }
                }
            }
        }
        return longest;
    }

    public String solution1(String s) {
        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = checkString(s, i, i);
            int len2 = checkString(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                index = i;
                maxLen = len;
            }
        }

        return s.substring(index - (maxLen - 1) / 2, index + maxLen / 2+1);
    }

    private int checkString(String s, int i, int j) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return --j - ++i + 1;

    }

    private boolean isPalindromeString(String t) {
        for (int k = 0; k < t.length() / 2; k++) {
            if (t.charAt(k) != t.charAt(t.length() - 1 - k)) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        String s = "babad";
        Utils.printNum(this, s);
        String result = solution1(s);
        Utils.printNum(this, result);
    }
}
