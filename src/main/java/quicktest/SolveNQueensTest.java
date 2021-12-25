package quicktest;

import sort.Utils;

import java.util.*;

/**
 * Created by xiaogui on 2021/12/25.
 */
public class SolveNQueensTest {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        //列和两个对角线
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        //每行状态值
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, 0, n, columns, diagonals1, diagonals2, ans);

        return ans;

    }

    private void backtrack(int[] queens, int row, int n, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2, List<List<String>> ans) {
        if (row == n) {
            List<String> result = generate(queens, n);
            ans.add(result);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }

                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(queens, row + 1, n, columns, diagonals1, diagonals2, ans);

                //回溯
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);

            }
        }
    }

    private List<String> generate(int[] queens, int n) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] cArr = new char[n];
            Arrays.fill(cArr, '.');
            cArr[queens[i]] = 'Q';
            result.add(new String(cArr));
        }
        return result;
    }

    public void test() {
        int n = 4;
        Utils.printNum(this, n);
        List result = solveNQueens(n);
        Utils.printNum(this, result);

    }

}
