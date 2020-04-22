package leetcode;

import sort.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> solution(int numRows) {
        if (numRows == 0) {
            return null;
        }
        if (numRows == 1) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(1);
            list.add(subList);
            return list;
        }
        List<List<Integer>> preList = solution(numRows - 1);
        List<Integer> newList = new ArrayList<Integer>();
        List<Integer> preLastList = preList.get(preList.size() - 1);
        for (int i = 0; i <= preLastList.size(); i++) {
            if (i == 0 || i == preLastList.size()) {
                newList.add(1);
            } else {
                newList.add(preLastList.get(i) + preLastList.get(i - 1));
            }
        }
        preList.add(newList);
        return preList;
    }
    public void test(){
        int numRows=5;
        Utils.printNum(this,numRows);
        List<List<Integer>> result = solution(numRows);
        Utils.printNum(this,result);
    }
}
