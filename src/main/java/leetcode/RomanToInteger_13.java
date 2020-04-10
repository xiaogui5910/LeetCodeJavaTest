package leetcode;

import sort.Utils;

import java.util.HashMap;

public class RomanToInteger_13 {

    /**
     * 简单从s字符串从左到右，String截取，做判断
     *
     * @param s 罗马数字
     * @return 阿拉伯数字
     */
    public int solution(String s) {
        HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
        dataMap.put("I", 1);
        dataMap.put("V", 5);
        dataMap.put("X", 10);
        dataMap.put("L", 50);
        dataMap.put("C", 100);
        dataMap.put("D", 500);
        dataMap.put("M", 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            String pre = null;
            String next = null;
            if (i != 0) {
                pre = s.substring(i - 1, i);
            }
            if (i != s.length() - 1) {
                next = s.substring(i + 1, i + 2);
            }
            String current = s.substring(i, i + 1);

            Integer preNum = dataMap.get(pre);
            Integer nextNum = dataMap.get(next);
            Integer currentNum = dataMap.get(current);

            if (preNum != null && preNum < currentNum) {
                sum += currentNum - preNum;
            } else if (nextNum != null && currentNum < nextNum) {
                continue;
            } else {
                sum += currentNum;
            }
        }
        return sum;
    }

    /**
     * 从s字符串从右到左。s.charAt()
     *
     * @param s 罗马数字
     * @return 阿拉伯数字
     */
    public int solution1(String s) {
        HashMap<Character, Integer> dataMap = new HashMap<Character, Integer>();
        dataMap.put('I', 1);
        dataMap.put('V', 5);
        dataMap.put('X', 10);
        dataMap.put('L', 50);
        dataMap.put('C', 100);
        dataMap.put('D', 500);
        dataMap.put('M', 1000);

        int lenght = s.length();
        int sum = dataMap.get(s.charAt(lenght - 1));
        for (int i = lenght - 2; i >= 0; i--) {
            if (dataMap.get(s.charAt(i)) < dataMap.get(s.charAt(i + 1))) {
                sum -= dataMap.get(s.charAt(i));
            } else {
                sum += dataMap.get(s.charAt(i));
            }

        }
        return sum;
    }

    public void test() {
//        String s = "LVIII";
        String s = "MCMXCIV";
        Utils.printNum(this, s);
        int num = solution1(s);
        Utils.printNum(this, num);
    }
}
