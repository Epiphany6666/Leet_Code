package title.多米诺和托米诺平铺790;

public class test {
}

//method 状态机DP
//mind 似懂非懂
class Solution {
    public int numTilings(int n) {
//        int[][] dp = new int[2][n + 1];
        int[][] dp = new int[n + 1][4];
        dp[1][0] = 1;
        dp[1][1] = 1;
        int MOD = (int)1e9 + 7;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            int cur = 0;
            //note 太粗心了
//            for (int j = 0; j < 4; j++) {
//                cur = (cur + dp[i][j]) % MOD;
//            }
//            dp[i][1] = cur;
//            dp[i][2] = (dp[i][0] + dp[i][3]) % MOD;
//            dp[i][3] = (dp[i][0] + dp[i][2]) % MOD;
            for (int j = 0; j < 4; j++) {
                cur = (cur + dp[i - 1][j]) % MOD;
            }
            dp[i][1] = cur;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
        }
        return dp[n][1];
    }
}