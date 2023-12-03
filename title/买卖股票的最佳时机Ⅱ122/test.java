package title.买卖股票的最佳时机Ⅱ122;

public class test {

}

/*
class Solution {
    int res;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        dfs(prices, 0, len, 0, res)
    }

    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            res = Math.max(res, profit);
        }
        dfs(prices, index + 1, len, status, profit);
        if (status == 0) {
            dfs(prices, index + 1, len, 1, profit + prices[index]);
        } else {
            dfs(prices, index + 1, len, 0, profit - prices[index]);
        }
    }
}*/

/*
//法2：动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}*/


//法1：贪心
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) profit += temp;
        }
        return profit;
    }
}