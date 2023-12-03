package title.投骰子等于目标和的方法数1155;

public class test {
}

/*
//method ：动态规划
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        int Mod = (int)1e9 + 7;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % Mod;
                }
            }
        }
        return dp[n][target];
    }
}*/

//method ：动态规划-空间优化
/*
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int Mod = (int)1e9 + 7;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= target; s++) {
                for (int j = 1; j <= k; j++) {
                    if (s - j >= 0) dp[j] = (dp[j - 1] + dp[s - j]) % Mod;
                }
            }
        }
        return dp[target];
    }
}*/

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int Mod = (int)1e9 + 7;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = target; s >= 0; s--) {
                dp[s] = 0;
                for (int j = 1; j <= k; j++) {
                    if (s - j >= 0) dp[s] = (dp[s] + dp[s - j]) % Mod;
                }
            }
        }
        return dp[target];
    }
}