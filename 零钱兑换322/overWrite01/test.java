package title.零钱兑换322.overWrite01;

public class test {
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                /*if (i - coins[j] >= 0) {
                    //mind 颠了，+1都忘记
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }*/
                //note 并且这里出了一个大问题，就是假如：
                if (i - coins[j] >= 0) {
                    //mind 颠了，+1都忘记
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}