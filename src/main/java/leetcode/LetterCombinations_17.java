package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. 电话号码的字母组合(回溯法)
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations_17 {
    private static final HashMap<String, String> letterMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> solution(String digits) {
        List<String> list = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        helper(list, "", digits);
        return list;
    }

    private void helper(List<String> list, String ans, String digits) {
        if (digits.length() == 0) {
            list.add(ans);
            return;
        }
        String digit = digits.substring(0, 1);
        String letters = letterMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            helper(list, ans + letter, digits.substring(1));
        }
    }

    public void test() {
        String digits = "23";
        Utils.printNum(this, digits);
        List<String> list = solution(digits);
        Utils.printNum(this, list);
    }
}
