package leetcode;

import sort.Utils;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinimumWindowSubstring_76 {
    public String solution(String s, String t) {
        //字符串t中，每个字符出现的次数
        HashMap<Character, Integer> needs = new HashMap<Character, Integer>();
        //滑动窗口出现t中字符的次数
        HashMap<Character, Integer> windows = new HashMap<Character, Integer>();

        //统计t中字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0)+1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        //windows中满足needs中字符出现的次数时，count++
        int count = 0;
        //最短包含字符t的数值
        int minLen = Integer.MAX_VALUE;
        //开始滑动窗口，右指针开始
        while (right < s.length()) {
            char c = s.charAt(right);
            //s中出现t中的字符
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0)+1);
                //使用compareTo比较，字符c是否满足needs中要求个数
                if (windows.get(c).compareTo(needs.get(c)) == 0) {
                    count++;
                }
            }
            //右指针继续右滑
            right++;

            //窗口中满足needs需要的字符个数
            while (count == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    end = right;
                    minLen = end - start;
                }

                char temp = s.charAt(left);
                //出现t中字符
                if (needs.containsKey(temp)) {
                    //更新当前窗口字符的出现次数
                    windows.put(temp, windows.getOrDefault(temp, 1) - 1);
                    //窗口出现次数小于需要的就更新count值
                    if (windows.get(temp) < needs.get(temp)) {
                        count--;
                    }
                }

                //左指针继续右滑
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
    public void test(){
        String s="ADOBECODEBANC";
        String t="ABC";
        String result = solution(s, t);
        Utils.printNum(this,result);
    }
}
