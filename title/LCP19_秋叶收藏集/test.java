package title.LCP19_秋叶收藏集;

import java.util.Arrays;

public class test {
}

// note 三目运算符记得加括号。。。
class Solution {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] dp = new int[3][n];
        for (int i = 0; i < n; i++) {
            if (i < 1) {
                dp[0][i] = (leaves.charAt(i) == 'r' ? 0 : 1);
            } else {
                dp[0][i] = dp[0][i - 1] + (leaves.charAt(i) == 'r' ? 0 : 1);
            }
            if (i < 1) {
                dp[1][i] = dp[0][i];
            } else {
                dp[1][i] = Math.min(dp[1][i - 1] + (leaves.charAt(i) == 'y' ? 0 : 1), dp[0][i - 1] + (leaves.charAt(i) == 'y' ? 0 : 1));
            }
            if (i < 2) {
                dp[2][i] = dp[1][i];
            } else {
                dp[2][i] = Math.min(dp[2][i - 1] + (leaves.charAt(i) == 'r' ? 0 : 1), dp[1][i - 1] + (leaves.charAt(i) == 'r' ? 0 : 1));
            }
        }
        return dp[2][n - 1];
    }
}