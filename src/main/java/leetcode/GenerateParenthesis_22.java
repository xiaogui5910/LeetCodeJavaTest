package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis_22 {
    public List<String> solution(int n) {
        List<String> list = new ArrayList<String>();
        helper(list, "", 0, n);
        return list;
    }

    private void helper(List<String> list, String str, int rightNeed, int leftRest) {
        if (rightNeed == 0 && leftRest == 0) {
            list.add(str);
            return;
        }
        if (rightNeed > 0) {
            helper(list, str + ")", rightNeed - 1, leftRest);
        }
        if (leftRest > 0) {
            helper(list, str + "(", rightNeed + 1, leftRest - 1);
        }
    }

    /**
     * 深度优先遍历,减法
     * 分析出的结论：
     * <p>
     * 当前左右括号都有大于 00 个可以使用的时候，才产生分支；
     * <p>
     * 产生左分支的时候，只看当前是否还有左括号可以使用；
     * <p>
     * 产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     * <p>
     * 在左边和右边剩余的括号数都等于 00 的时候结算。
     *
     * @param n
     * @return
     */
    public List<String> solution1(int n) {
        List<String> res = new ArrayList<String>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }


    public void test() {
        int n = 3;
        Utils.printNum(this, n);
        List<String> result = solution(n);
        Utils.printNum(this, result);
    }
}
