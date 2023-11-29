package title.买卖股票的最佳时机III123;

public class test {
}

//做不出。。。
/*
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] interval = new int[len - 1];
        int idx = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] - prices[i - 1] > 0) interval[idx++] = 
        }
    }
}*/

//method 又又又又是动态规划！！！
/*class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] +  prices[i]);
        }
        return dp[len - 1][4];
    }
}*/

//method 动态规划版本二：节省空间
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return dp[4];
    }
}