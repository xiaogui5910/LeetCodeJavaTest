package leetcode;

import sort.Utils;

/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 */
public class LengthOfLastWord_58 {
    public int solution(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        int start = i;
        return end - start;
    }
    public void test(){
        String s="hello world";
        Utils.printNum(this,s);
        int len = solution(s);
        Utils.printNum(this,len);
    }
}
