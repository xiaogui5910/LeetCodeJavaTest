package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZigZagConversion_6 {
    public String solution(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> list = new ArrayList<List<Character>>();
        //去掉空行情况
//        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<Character>());
        }
        int delta = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (delta == 0) {
                flag = true;
            }
            if (delta == numRows - 1) {
                flag = false;
            }

            int index = delta;
            List<Character> subList = list.get(index);
            delta = flag ? delta + 1 : delta - 1;
            subList.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> subList : list) {
            for (Character c :
                    subList) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 方法一优化版
     */
    public String solution1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            list.get(index).append(s.charAt(i));
            if (index == 0 || index == numRows - 1) {
                flag = !flag;
            }
            index += flag ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb :
                list) {
            result.append(sb);
        }
        return result.toString();
    }

    public void test() {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        Utils.printNum(this, s);
        String result = solution1(s, numRows);
        Utils.printNum(this, result);
    }
}
