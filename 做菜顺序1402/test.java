package title.做菜顺序1402;

import java.util.Arrays;

public class test {
}

//method 01背包问题。。。
/*
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + satisfaction[i - 1] * j);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}*/

/*
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j;
                if (i < j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}*/

//method 2：贪心
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int pre = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            pre += satisfaction[i];
            if (pre > 0) ans += pre;
            else break;
        }
        return ans;
    }
}