package leetcode;

import sort.Utils;

/**
 * 1143. 最长公共子序列
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * 通过次数17,957提交次数30,288
 * <p>
 */
public class LongestCommonSubsequence_1143 {
    public int solution(String text1, String text2) {
        char[] l1 = text1.toCharArray();
        char[] l2 = text2.toCharArray();
        int max = 0;
        int[][] dp = new int[l1.length + 1][l2.length + 1];
        for (int i = 1; i <= l1.length; i++) {
            for (int j = 1; j <= l2.length; j++) {
                //判断text1和text2在i-1和i-2的索引的字符是否相同，因为i和j都是从1开始的，索引要i-1和j-1
                if (l1[i - 1] == l2[j - 1]) {
                    //相同则有动态规范，推导分析，结果由左上角结果+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不同则由分析出，不能由前一个结果（左上角：dp[i-1][j-1]）+1(相同可以加1，不同则不能加1),
                    // 就是去掉当前两个字符i和j的结果，dp[i-1][j]和dp[i][j-1]中找到一个最大值则是当前结果
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                //记录dp[i][j]中最大值
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int solution1(String text1, String text2) {
        char[] l1 = text1.toCharArray();
        char[] l2 = text2.toCharArray();
        int[] dp = new int[l1.length + 1];
        int max = 0;
        for (int i = 1; i <= l2.length; i++) {
            int lastLeftTop = 0;
            for (int j = 1; j <= l1.length; j++) {
                int temp = dp[j];
                if (l2[i - 1] == l1[j - 1]) {
                    dp[j] = lastLeftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                max = Math.max(max, dp[j]);
                lastLeftTop = temp;
            }
        }
        return max;
    }

    public void test() {
        String text1 = "abcde";
        String text2 = "ace";
        Utils.printNum(this, text1);
        Utils.printNum(this, text2);
        int result = solution(text1, text2);
        Utils.printNum(this, result);

    }
}
