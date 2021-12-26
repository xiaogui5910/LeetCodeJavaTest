package leetcode;

import sort.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int solution(String s) {
        int max = 0;
        int preIndex = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null && index > preIndex) {
                preIndex = index;
            }
            int len = i - preIndex + 1;
            max = Math.max(len, max);
            map.put(c, i + 1);
        }
        return max;
    }

    public void test() {
//        String s = "abcabcbb";
//        String s = "pwwkeabw";
        String s = "abba";
        Utils.printNum(this, s);
        int result = solution(s);
        Utils.printNum(this, result);
    }
}
