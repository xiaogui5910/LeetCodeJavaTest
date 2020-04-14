package leetcode;

import sort.Utils;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr_28 {
    public int solution(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            if (i + l2 > l1) return -1;
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    public int solution1(String haystack, String needle) {
        int n = haystack.length();
        int l = needle.length();
        if (l == 0) {
            return 0;
        }

        int pn = 0;
        while (pn < n - l + 1) {
            //找到第一个匹配的字符
            while (pn < n - l + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                pn++;
            }

            //从pn索引开始匹配
            int currentLen = 0;
            int pl = 0;
            while (pn < n && pl < l && haystack.charAt(pn) == needle.charAt(pl)) {
                pl++;
                pn++;
                currentLen++;
            }

            //如果完全匹配（即 currentLen == l），返回匹配子串的起始坐标（即 pn - l）。
            if (currentLen == l) {
                return pn - l;
            }
            //重置pn索引，currentLen表示已经比较了长度，不是pn-currentLen
            pn = pn - currentLen + 1;
        }
        //没有结果返回-1
        return -1;
    }

    public void test() {
//        String haystack = "hello";
//        String needle = "ll";
//        String haystack = "aaaaa";
//        String needle = "bba";
        String haystack = "mississippi";
        String needle = "issip";
//        String haystack = "itemlluserlll";
//        String needle = "lll";
        Utils.printNum(this, haystack);
        Utils.printNum(this, needle);
        int len = solution1(haystack, needle);
        Utils.printNum(this, len);
    }
}
