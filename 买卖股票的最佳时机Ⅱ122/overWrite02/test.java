package title.买卖股票的最佳时机Ⅱ122.overWrite02;

public class test {
}

/*
//method 1：dfs
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxProfit(int[] prices) {
        dfs(prices, 0, 0, 0);
        return ans;
    }

    private void dfs(int[] prices, int depth, int status, int profit) {
        if (depth == prices.length) {
            ans = Math.max(ans, profit);
            return;
        }

        //少了一种情况！
        dfs(prices, depth + 1, status, profit);

        if (status == 1) {
            dfs(prices, depth + 1, 0, profit + prices[depth]);
        } else {
            dfs(prices, depth + 1, 1, profit - prices[depth]);
        }
    }
}*/

//method 2：贪心
//mind 之前明明就做过一次了，再次做还是不会。。。
/*
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) ans += tmp;
        }
        return ans;
    }
}*/

//method 3：动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len - 1][0];
    }
}