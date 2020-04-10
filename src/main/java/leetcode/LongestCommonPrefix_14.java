package leetcode;

import sort.Utils;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix_14 {
    public String solution(String[] strings) {
        if (strings.length == 0) return "";
        int minLen = strings[0].length();
        for (int i = 0; i < strings.length; i++) {
            if (minLen > strings[i].length()) {
                minLen = strings[i].length();
            }
        }
        for (int i = 0; i < minLen; i++) {
            char c = strings[0].charAt(i);

            for (int j = 0; j < strings.length; j++) {
                if (c != strings[j].charAt(i)) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[0].substring(0, minLen);
    }

    public void test() {
        String[] strings = {"flower", "flow", "flight"};
//        String[] strings = {"dog", "racecar", "car"};
        Utils.printArr(this, strings);
//        String longestStr = solution(strings);
        String longestStr = longestCommonPrefix(strings);
        Utils.printNum(this, longestStr);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if ("".equals(prefix)) return "";
            }
        }
        return prefix;
    }
}
