package leetcode;

import sort.Utils;

/**
 * 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class EditDistance_72 {
    public int solution(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        //base case 当一个字符串为空或者比较完成，直接根据另一个字符串的长度执行插入操作即可
        for (int i = 0; i <= arr1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= arr2.length; j++) {
            dp[0][j] = j;
        }
        //i和j从1开始
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                int left = dp[i - 1][j] + 1;
                int top = dp[i][j - 1] + 1;
                int leftTop = dp[i - 1][j - 1];

                //比较当前i和j的位置字符是否相同，索引为i-1和j-1
                if (arr1[i - 1] != arr2[j - 1]) {
                    //相同表示，这一步不要多余操作，直接和上一个dp[i-1][j-1]一样
                    //不相同则表示，上一步还需要多操作一下，可以理解成删除操作
                    leftTop++;
                }
                //可以这样理解，操作包括：添加、替换、删除，leftTop相同则和上一个一样
                // 不同就+1，最后比较这三个操作，取最小的
                dp[i][j] = Math.min(left, Math.min(top, leftTop));
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        Utils.printNum(this, word1);
        Utils.printNum(this, word2);
        int result = solution(word1, word2);
        Utils.printNum(this, result);
    }
}
