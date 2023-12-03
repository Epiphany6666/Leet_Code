package title.LCR_188_买卖芯片的最佳时机;

public class test {
}

/*
class Solution {
    public int bestTiming(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int t = prices[i + 1] - prices[i];
            if (t > 0) profit += t;
        }
        return profit;
    }
}*/

class Solution {
    public int bestTiming(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}