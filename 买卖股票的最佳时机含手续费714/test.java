package title.买卖股票的最佳时机含手续费714;

public class test {
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int ans = 0;
        int preValue = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            preValue = Math.min(preValue, prices[i] + fee);
            if (preValue < prices[i]) {
                ans += (prices[i] - preValue);
                preValue = prices[i];
            }
        }
        return ans;
    }
}

//method 2：dp
/*
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - fee + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}*/
