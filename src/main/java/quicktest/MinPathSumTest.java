package quicktest;

import sort.Utils;

/**
 * Created by xiaogui on 2021/12/28.
 */
public class MinPathSumTest {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //动态数组dp[i][j]
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //i>0,j=0
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //i=0,j>0
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //i>0,j>0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public void test() {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Utils.printArr(this.toString(), nums);
        int result = minPathSum(nums);
        Utils.printNum(this, result);

    }
}
