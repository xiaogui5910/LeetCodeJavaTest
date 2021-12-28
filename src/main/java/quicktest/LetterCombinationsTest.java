package quicktest;

import leetcode.ListNode;
import sort.Utils;

import java.util.*;

/**
 * Created by xiaogui on 2021/12/28.
 */
public class LetterCombinationsTest {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return ans;
        }

        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        getResult(ans, map, digits, "", 0);
        return ans;
    }

    private void getResult(List<String> ans, Map<Character, String> map, String digits, String s, int i) {
        if (i == digits.length()) {
            ans.add(s);
            return;
        }
        String str = map.get(digits.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            getResult(ans, map, digits, s + str.charAt(j), i + 1);
        }
    }

    public void test() {
        String d = "23";
        Utils.printNum(this, d);
        List<String> result = letterCombinations(d);
        Utils.printNum(this, result);

    }


}
