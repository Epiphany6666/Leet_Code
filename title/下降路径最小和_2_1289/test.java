package title.下降路径最小和_2_1289;

import java.util.Arrays;

/**
 * 总结
 * 1.题目并没有说下降只能根据相邻的行下降，你干嘛自己给题目加条件？
 * 2.弄明白范围的意思，题目只说了-99 <= grid[i][j] <= 99，并没有说下降路径最小值在这个范围之内！！！
 *   所以不能直接让ans=100；
 */
public class test {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        new Solution().minFallingPathSum(grid);
    }
}

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                    /*else if (j == n - 1) dp[i][j] = dp[i - 1][j - 1] + grid[i][j];
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + grid[i][j];
                    }*/
                }
            }
        }
        int ans = 100;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < ans) ans = dp[n - 1][i];
        }
        return ans;
    }
}