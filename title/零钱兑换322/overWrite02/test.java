package title.零钱兑换322.overWrite02;

import java.util.Arrays;

public class test {
}

/**
 * 参考题解：sugar
 */
// method 1：递归，超时
class Solution01 {
    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    private void dfs(int[] coins, int amount, int cnt) {
        if (amount < 0) return;
        if (amount == 0) ans = Math.min(ans, cnt);
        for (int i = 0; i < coins.length; i++) {
            dfs(coins, amount - coins[i], cnt + 1);
        }
    }
}

// method 2：记忆化搜索
class Solution03 {
    // note 记忆化搜索只需要一级
    //    int[][] mem;
    int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        dfs(coins, amount);
        return mem[amount];
    }

    private int dfs(int[] coins, int amount) {
//        if (amount < 0) return 0;
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem[amount] != 0) return mem[amount];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int a = dfs(coins, amount - coins[i]);
            if (a >= 0 && a < min) {
                min = a + 1;
            }
        }
        mem[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return mem[amount];
    }
}

/**
 * 参考题解：sugar、画图小匠
 * 这道题我们可以去构造和拆分子问题，从而通过动态规划进行求解。
 */
// method 3：动态规划，自底向上
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
