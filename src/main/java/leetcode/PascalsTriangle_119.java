package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangle_119 {
    public List<Integer> solution(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
    public void test(){
        int rowIndex=5;
        Utils.printNum(this,rowIndex);
        List<Integer> result = solution(rowIndex);
        Utils.printNum(this,result);
    }
}
