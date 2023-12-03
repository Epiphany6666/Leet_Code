package title.买卖股票的最佳时机Ⅱ122.overWrite01;

public class test {
}


//法1：贪心
/*class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int pre = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}*/

//贪心 - 简化
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }
}

/**法2：dfs，看懂了之后，太巧秒了，真的太巧秒了，虽然会超时，但是还是很值得学习。*/
/*
class Solution {
    int ans = 0;
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return ans;
        dfs(prices, 0, len, 0, 0);
        return ans;
    }

    private void dfs(int[] prices, int depth, int len, int status, int profit) {
        if (depth == len) {
            if (profit > ans) {
                ans = profit;
            }
            return;
        }
        dfs(prices, depth + 1, len, status, profit);
        if (status == 0) {
            dfs(prices, depth + 1, len, 1, profit + prices[depth]);
        } else {
            dfs(prices, depth + 1, len, 0, profit - prices[depth]);
        }
    }
}*/

//法3：动态规划 - 二维数组
/*class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}*/

/*//动态规划 - 一维数组
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] cash = new int[len];
        int[] hold = new int[len];
        cash[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }
}*/

//动态规划 - 滚动变量
/*
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < len; i++) {
            cash = Math.max(cash, hold + prices[i]);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}*/