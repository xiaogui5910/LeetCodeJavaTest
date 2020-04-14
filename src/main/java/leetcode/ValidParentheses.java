package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 */
public class ValidParentheses {
    public boolean solution(String s) {
        HashMap<Character, Character> dataMap = new HashMap<Character, Character>();
        dataMap.put('(', ')');
        dataMap.put('{', '}');
        dataMap.put('[', ']');

        if (s.equals("")) {
            return true;
        }

        ArrayList<Character> list = new ArrayList<Character>();
        list.add(s.charAt(0));
        boolean result = false;

        for (int i = 1; i < s.length(); i++) {
            char c = list.size() > 0 ? list.get(list.size() - 1) : ' ';

            if (c == ' ') {
                result = false;
                list.add(s.charAt(i));
                continue;
            }

            Character character = dataMap.get(c);
            if (character == null) {
                return false;
            }
            if (character == s.charAt(i)) {
                list.remove(list.size() - 1);
                result = true;
            } else {
                c = s.charAt(i);
                list.add(c);
                result = false;
            }
        }
        return result && list.size() == 0;
    }

    /**
     * 解法2：
     * 题意是判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，当出现左括号的时候入栈，当遇到右括号时，
     * 判断栈顶的左括号是否何其匹配，不匹配的话直接返回 false 即可，最终判断是否空栈即可，这里我们可以用数组模拟栈的操作使其操作更快，
     * 有个细节注意下 top = 1;，从而省去了之后判空的操作和 top - 1 导致数组越界的错误。
     * @param s 字符串（括号）
     * @return 是否匹配正确
     */
    public boolean solution1(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

    public void test() {
//        String s = "()[]{}";
//        String s = "([)]";
//        String s = "{[]}";
        String s = "";
//        String s = "([]";
//        String s = "[])";
//        String s = "(]";
//        String s = "]";
        Utils.printNum(this, s);
        boolean result = solution(s);
        Utils.printNum(this, result);

    }

}
