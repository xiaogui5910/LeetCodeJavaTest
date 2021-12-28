package quicktest;

import sort.Utils;

/**
 * Created by xiaogui on 2021/12/28.
 */
public class UniquePathsTest {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        //i>0,j=0
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0];
        }
        //j>0,i=0
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1];
        }
        //i>0,j>0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public void test() {
        int m = 7;
        int n = 3;
        Utils.printNum(this, "m=" + m + ",n=" + n);
        int result = uniquePaths(m, n);
        Utils.printNum(this, result);

    }
}
